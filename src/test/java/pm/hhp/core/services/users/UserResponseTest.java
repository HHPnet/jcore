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

package pm.hhp.core.services.users;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pm.hhp.core.model.users.User;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.doReturn;

public class UserResponseTest {
  private UserResponse userResponse;

  @Mock
  private User user;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    userResponse = new UserResponse(user);
  }

  @After
  public void tearDown() throws Exception {
    userResponse = null;
    user = null;
  }

  @Test
  public void itIsPossibleToGetUserId() {
    doReturn("test").when(user).getUserId();

    assertThat(userResponse.getUserId()).isEqualTo("test");
  }

  @Test
  public void itIsPossibleToGetUserName() {
    doReturn("test").when(user).getName();

    assertThat(userResponse.getName()).isEqualTo("test");
  }

  @Test
  public void itIsPossibleToGetUserEmail() {
    doReturn("test").when(user).getEmail();

    assertThat(userResponse.getEmail()).isEqualTo("test");
  }
}