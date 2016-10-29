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

package pm.hhp.core.services.users.create;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pm.hhp.core.model.users.User;
import pm.hhp.core.model.users.UserFactory;
import pm.hhp.core.model.users.UserRepository;
import pm.hhp.core.model.users.exceptions.UserNotFoundException;
import pm.hhp.core.services.users.UserRequest;
import pm.hhp.core.services.users.UserResponse;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreateUserServiceTest {
  private static final String USER_NAME = "test_name";

  private static final String USER_EMAIL = "test_email";

  private CreateUserService createUserService;

  @Mock private UserRepository repository;

  @Mock private UserFactory factory;

  @Mock private UserRequest request;

  @Mock private User user;

  @Mock private UserResponse userResponse;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    createUserService = new CreateUserService(repository, factory);
  }

  @After
  public void tearDown() throws Exception {
    createUserService = null;
    repository = null;
    factory = null;
    request = null;
    user = null;
    userResponse = null;
  }

  @Test
  public void itDoesNotSaveAnUserWhenEmailAlreadyExists() throws UserNotFoundException {
    givenARequestToCreateAnUser();
    andGetAnUserEntityFromTheFactory();
    emailWasFound();

    assertThat(createUserService.execute(request)).isNull();
  }

  @Test
  public void itSavesAnUserWhenEmailDoesNotExist() throws UserNotFoundException {
    givenARequestToCreateAnUser();
    andGetAnUserEntityFromTheFactory();
    emailWasNotFound();
    andUserIsSaved();

    assertThat(createUserService.execute(request)).isEqualTo(userResponse);
    verify(repository, times(1)).save(user);
  }

  private void givenARequestToCreateAnUser() {
    doReturn(USER_NAME).when(request).getName();
    doReturn(USER_EMAIL).when(request).getEmail();
  }

  private void andGetAnUserEntityFromTheFactory() {
    doReturn(user).when(factory).getUserEntity(USER_NAME, USER_EMAIL);
    doReturn(USER_EMAIL).when(user).getEmail();
  }

  private void emailWasNotFound() throws UserNotFoundException {
    doThrow(new UserNotFoundException()).when(repository).findByEmail(USER_EMAIL);
  }

  private void emailWasFound() throws UserNotFoundException {
    doReturn(user).when(repository).findByEmail(USER_EMAIL);
  }

  private void andUserIsSaved() {
    doReturn(user).when(repository).save(user);
    doReturn(userResponse).when(factory).getUserResponse(user);
  }
}
