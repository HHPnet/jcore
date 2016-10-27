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

package pm.hhp.core.model.users;

import java.util.UUID;

class UserId {
  private UUID userId;

  /**
   * Generates an user id given a UUID.
   *
   * @param userId Id of the user to set up.
   */
  UserId(UUID userId) {
    this.userId = userId;
  }

  /**
   * Generates a random user id.
   */
  UserId() {
    this.userId = UUID.randomUUID();
  }

  /**
   * Generates an user id given an string.
   *
   * @param userId Id of the user to set up.
   */
  UserId(String userId) {
    this.userId = UUID.fromString(userId);
  }

  /**
   * Get the value of the user id.
   *
   * @return String
   */
  String getUserId() {
    return userId.toString();
  }
}
