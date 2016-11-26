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

import pm.hhp.core.services.ServiceRequest;

import java.util.Optional;

public class UserRequest implements ServiceRequest {
  private final String userId;

  private final String name;

  private final String email;

  /**
   * Generate a request to save an user.
   *
   * @param userId Id of the user to save.
   * @param name Name of the user.
   * @param email Email of the user.
   */
  public UserRequest(String userId, String name, String email) {
    this.userId = userId;
    this.name = name;
    this.email = email;
  }

  /**
   * Generate a request to save an user without id, a new one will be generated.
   *
   * @param name Name of the user.
   * @param email Email of the user.
   */
  public UserRequest(String name, String email) {
    this.userId = null;
    this.name = name;
    this.email = email;
  }

  /**
   * Generate a user request given only the user id.
   *
   * @param userId Id of the user.
   */
  public UserRequest(String userId) {
    this.userId = userId;
    this.name = null;
    this.email = null;
  }

  /**
   * Get the user id to save.
   *
   * @return Optional of String
   */
  public Optional<String> getUserId() {
    return Optional.ofNullable(userId);
  }

  /**
   * Get the name of the user.
   *
   * @return String
   */
  public String getName() {
    return name;
  }

  /**
   * Get the email of the user.
   *
   * @return String
   */
  public String getEmail() {
    return email;
  }
}
