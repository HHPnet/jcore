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

public class User {

  private UserId userId;

  private String name;

  private String email;

  /**
   * Create an user entity.
   *
   * @param userId Id of the user.
   * @param name Name of the user.
   * @param email Email of the user.
   */
  User(UserId userId, String name, String email) {
    this.userId = userId;
    this.name = name;
    this.email = email;
  }

  /**
   * Get the id of the user.
   *
   * @return String
   */
  public String getUserId() {
    return userId.getUserId();
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
   * Set user's name.
   *
   * @param name New user's name.
   * @return User
   */
  User setName(String name) {
    this.name = name;

    return this;
  }

  /**
   * Get the user's email.
   *
   * @return String
   */
  public String getEmail() {
    return email;
  }

  /**
   * Set new user's email.
   *
   * @param email New user's email.
   * @return User
   */
  User setEmail(String email) {
    this.email = email;

    return this;
  }
}
