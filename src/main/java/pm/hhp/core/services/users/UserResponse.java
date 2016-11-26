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

import pm.hhp.core.model.users.User;
import pm.hhp.core.services.ServiceResponse;

public class UserResponse implements ServiceResponse {
  private final User user;

  /**
   * Generates an user response entity.
   *
   * @param user User to return.
   */
  public UserResponse(User user) {
    this.user = user;
  }

  /**
   * Get the id of the user.
   *
   * @return String
   */
  String getUserId() {
    return user.getUserId();
  }

  /**
   * Get the name of the user.
   *
   * @return String
   */
  String getName() {
    return user.getName();
  }

  /**
   * Get the email of the user.
   *
   * @return String
   */
  String getEmail() {
    return user.getEmail();
  }
}
