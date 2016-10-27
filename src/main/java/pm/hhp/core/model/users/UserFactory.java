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

import pm.hhp.core.services.users.UserResponse;

import java.util.UUID;

public class UserFactory {
  /**
   * Generates an user entity given an UserId.
   *
   * @param userId Id of the user.
   * @param name Name of the user.
   * @param email Email of the user.
   * @return User
   */
  User getUserEntity(UserId userId, String name, String email) {
    return new User(userId, name, email);
  }

  /**
   * Generates an user entity given a string as user id.
   *
   * @param userId Id of the user.
   * @param name Name of the user.
   * @param email Email of the user.
   * @return User
   */
  public User getUserEntity(String userId, String name, String email) {
    return getUserEntity(new UserId(userId), name, email);
  }

  /**
   * Generates an user entity given a UUID as user id.
   *
   * @param userId Id of the user.
   * @param name Name of the user.
   * @param email Email of the user.
   * @return User
   */
  User getUserEntity(UUID userId, String name, String email) {
    return getUserEntity(new UserId(userId), name, email);
  }

  /**
   * Generates an user entity generating an user id.
   *
   * @param name Name of the user.
   * @param email Email of the user.
   * @return User
   */
  public User getUserEntity(String name, String email) {
    return getUserEntity(new UserId(), name, email);
  }

  /**
   * Generate a user response object.
   *
   * @param user User entity.
   * @return UserResponse
   */
  public UserResponse getUserResponse(User user) {
    return new UserResponse(user);
  }
}
