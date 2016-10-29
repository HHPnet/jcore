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

package pm.hhp.core.services.users.getprofile;

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

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GetUserProfileServiceTest {
  private static final String USER_ID = "test_id";

  private GetUserProfileService service;

  @Mock private UserRepository repository;

  @Mock private UserFactory factory;

  @Mock private UserRequest request;

  @Mock private User user;

  @Mock private UserResponse response;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    service = new GetUserProfileService(repository, factory);
  }

  @After
  public void tearDown() throws Exception {
    service = null;
    repository = null;
    factory = null;
    request = null;
    user = null;
    response = null;
  }

  @Test
  public void itDoesNotGetDataForANonExistingUser() throws UserNotFoundException {
    givenARequestToFindAnUser();
    userCouldNotBeFound();

    assertThat(service.execute(request)).isNull();
  }

  @Test
  public void itGetsAnUserWhenExisting() throws UserNotFoundException {
    givenARequestToFindAnUser();
    userExistsInDatabase();
    andGetAnUserEntityFromTheFactory();

    assertThat(service.execute(request)).isEqualTo(response);
    verify(repository, times(1)).findById(USER_ID);
  }

  private void givenARequestToFindAnUser() {
    doReturn(Optional.of(USER_ID)).when(request).getUserId();
    doReturn(null).when(request).getName();
    doReturn(null).when(request).getEmail();
  }

  private void userCouldNotBeFound() throws UserNotFoundException {
    doThrow(new UserNotFoundException()).when(repository).findById(USER_ID);
  }

  private void userExistsInDatabase() throws UserNotFoundException {
    doReturn(user).when(repository).findById(USER_ID);
  }

  private void andGetAnUserEntityFromTheFactory() {
    doReturn(response).when(factory).getUserResponse(user);
  }
}
