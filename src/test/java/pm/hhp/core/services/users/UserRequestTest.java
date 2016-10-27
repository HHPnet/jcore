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

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserRequestTest {
  @Test
  public void itIsPossibleToGenerateTheUserRequestWithId() {
    UserRequest request = new UserRequest("test_id", "test_name", "test_email");

    assertThat(request.getUserId().orElse(null)).isEqualTo("test_id");
    assertThat(request.getName()).isEqualTo("test_name");
    assertThat(request.getEmail()).isEqualTo("test_email");
  }

  @Test
  public void itIsPossibleToGenerateTheUserRequestWithoutId() {
    UserRequest request = new UserRequest("test_name", "test_email");

    assertThat(request.getUserId().isPresent()).isFalse();
    assertThat(request.getName()).isEqualTo("test_name");
    assertThat(request.getEmail()).isEqualTo("test_email");
  }

  @Test
  public void itIsPossibleToGenerateTheUserRequestOnlyWithId() {
    UserRequest request = new UserRequest("test_id");

    assertThat(request.getUserId().orElse(null)).isEqualTo("test_id");
    assertThat(request.getName()).isNull();
    assertThat(request.getEmail()).isNull();
  }
}