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

package pm.hhp.core.model.groups;

public class Group {

  private GroupId groupId;

  private String name;

  private String description;

  private String city;

  private String country;

  /**
   * Create a group entity.
   *
   * @param groupId Id of the group.
   * @param name Name of the group.
   * @param description Description of the group.
   * @param city City of the group.
   * @param country Country of the group.
   */
  Group(GroupId groupId, String name, String description, String city, String country) {
    this.groupId = groupId;
    this.name = name;
    this.description = description;
    this.city = city;
    this.country = country;
  }

  /**
   * Get the id of the group.
   *
   * @return String
   */
  public String getGroupId() {
    return groupId.getId();
  }

  /**
   * Get the name of the group.
   *
   * @return String
   */
  public String getName() {
    return name;
  }

  /**
   * Set a new name to the group.
   *
   * @param name Name of the group.
   * @return Group
   */
  Group setName(String name) {
    this.name = name;

    return this;
  }

  /**
   * Get the description of the group.
   *
   * @return String
   */
  public String getDescription() {
    return description;
  }

  /**
   * Set a new description for the group.
   *
   * @param description Description of the group.
   * @return Group
   */
  Group setDescription(String description) {
    this.description = description;

    return this;
  }

  /**
   * Get the city of the group.
   *
   * @return String
   */
  public String getCity() {
    return city;
  }

  /**
   * Set a new city for the group.
   *
   * @param city City of the group.
   * @return Group
   */
  Group setCity(String city) {
    this.city = city;

    return this;
  }

  /**
   * Get the country of the group.
   *
   * @return String
   */
  public String getCountry() {
    return country;
  }

  /**
   * Set a new country for the group.
   *
   * @param country Country of the group.
   * @return Group
   */
  Group setCountry(String country) {
    this.country = country;

    return this;
  }
}
