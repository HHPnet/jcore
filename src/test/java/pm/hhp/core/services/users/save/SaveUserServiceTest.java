/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package pm.hhp.core.services.users.save;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pm.hhp.core.model.users.User;
import pm.hhp.core.model.users.UserFactory;
import pm.hhp.core.model.users.UserRepository;
import pm.hhp.core.model.users.exceptions.UserNotAllowedToPerfomActionException;
import pm.hhp.core.model.users.exceptions.UserNotFoundException;
import pm.hhp.core.services.UserSession;
import pm.hhp.core.services.users.UserRequest;
import pm.hhp.core.services.users.UserResponse;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class SaveUserServiceTest {
  private static final String USER_ID = "test_id";

  private static final String USER_NAME = "test_name";

  private static final String USER_EMAIL = "test_email";

  private SaveUserService saveUserService;

  @Mock private UserRepository repository;

  @Mock private UserFactory factory;

  @Mock private UserRequest request;

  @Mock private User user;

  @Mock private UserResponse userResponse;

  @Mock private UserSession userSession;

  @Mock private User userWithGivenEmail;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    saveUserService = new SaveUserService(repository, factory, userSession);
  }

  @After
  public void tearDown() throws Exception {
    saveUserService = null;
    repository = null;
    factory = null;
    request = null;
    user = null;
    userResponse = null;
    userSession = null;
  }

  @Test
  public void itDoesNotSaveDataForANonExistingUser()
          throws UserNotFoundException, UserNotAllowedToPerfomActionException {
    givenARequestToSaveAnUser();
    andGivenUserInSessionIsRequestedUser();
    andGetAnUserEntityFromTheFactory();
    userCouldNotBeFound();

    assertThat(saveUserService.execute(request)).isNull();
  }

  @Test
  public void itSavesAnUserWhenExisting()
          throws UserNotFoundException, UserNotAllowedToPerfomActionException {
    givenARequestToSaveAnUser();
    andGivenUserInSessionIsRequestedUser();
    andGetAnUserEntityFromTheFactory();
    userExistsInDatabase();
    andNotOtherUserHasGivenEmailRegistered();
    andUserIsSaved();

    assertThat(saveUserService.execute(request)).isEqualTo(userResponse);
    verify(repository, times(1)).save(user);
  }

  @Test
  public void itDoesNotSaveUserWhenGivenEmailAlreadyExistsInOtherUser()
          throws UserNotFoundException, UserNotAllowedToPerfomActionException {
    givenARequestToSaveAnUser();
    andGivenUserInSessionIsRequestedUser();
    andGetAnUserEntityFromTheFactory();
    userExistsInDatabase();
    andOtherUserHasGivenEmailRegistered();

    assertThat(saveUserService.execute(request)).isNull();
    verify(repository, never()).save(user);
  }

  @Test(expected = UserNotAllowedToPerfomActionException.class)
  public void itFailsWhenGivenUserInSessionIsNotRequestedUser()
          throws UserNotAllowedToPerfomActionException {
    givenARequestToSaveAnUser();
    andGivenUserInSessionIsNotRequestedUser();

    saveUserService.execute(request);
  }

  private void givenARequestToSaveAnUser() {
    doReturn(Optional.of(USER_ID)).when(request).getUserId();
    doReturn(USER_NAME).when(request).getName();
    doReturn(USER_EMAIL).when(request).getEmail();
  }

  private void andGetAnUserEntityFromTheFactory() {
    doReturn(user).when(factory).getUserEntity(USER_ID, USER_NAME, USER_EMAIL);
    doReturn(USER_ID).when(user).getUserId();
  }

  private void userCouldNotBeFound() throws UserNotFoundException {
    doThrow(new UserNotFoundException()).when(repository).findById(USER_ID);
  }

  private void userExistsInDatabase() throws UserNotFoundException {
    doReturn(user).when(repository).findById(USER_ID);
  }

  private void andNotOtherUserHasGivenEmailRegistered() throws UserNotFoundException {
    doThrow(new UserNotFoundException()).when(repository).findByEmail(USER_EMAIL);
  }

  private void andOtherUserHasGivenEmailRegistered() throws UserNotFoundException {
    doReturn(userWithGivenEmail).when(repository).findByEmail(USER_EMAIL);
    doReturn(USER_EMAIL).when(userWithGivenEmail).getEmail();
    doReturn(UUID.randomUUID().toString()).when(userWithGivenEmail).getUserId();
  }

  private void andUserIsSaved() {
    doReturn(user).when(repository).save(user);
    doReturn(userResponse).when(factory).getUserResponse(user);
  }

  private void andGivenUserInSessionIsRequestedUser() {
    doReturn(true).when(userSession).isLoggedInUserId(USER_ID);
  }

  private void andGivenUserInSessionIsNotRequestedUser() {
    doReturn(false).when(userSession).isLoggedInUserId(USER_ID);
  }
}
