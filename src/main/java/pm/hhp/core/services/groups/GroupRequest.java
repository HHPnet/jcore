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

package pm.hhp.core.services.groups;

import pm.hhp.core.services.ServiceRequest;

import java.util.Optional;

public class GroupRequest implements ServiceRequest {
  private final String groupId;

  private final String name;

  private final String description;

  private final String city;

  private final String country;

  /**
   * Generate a request to interact with group services.
   *
   * @param name Group name.
   * @param description Group description.
   * @param city Group city.
   * @param country Group country.
   */
  public GroupRequest(String name, String description, String city, String country) {
    this.groupId = null;
    this.name = name;
    this.description = description;
    this.city = city;
    this.country = country;
  }

  /**
   * Generate a request to interact with group services.
   *
   * @param groupId Id of the group.
   * @param name Group name.
   * @param description Group description.
   * @param city Group city.
   * @param country Group country.
   */
  public GroupRequest(
      String groupId, String name, String description, String city, String country
  ) {
    this.groupId = groupId;
    this.name = name;
    this.description = description;
    this.city = city;
    this.country = country;
  }

  /**
   * Get group id.
   *
   * @return String
   */
  public Optional<String> getGroupId() {
    return Optional.ofNullable(groupId);
  }

  /**
   * Get group name.
   *
   * @return String
   */
  public String getName() {
    return name;
  }

  /**
   * Get group description.
   *
   * @return String
   */
  public String getDescription() {
    return description;
  }

  /**
   * Get group city.
   *
   * @return String
   */
  public String getCity() {
    return city;
  }

  /**
   * Get group country.
   *
   * @return String
   */
  public String getCountry() {
    return country;
  }
}
