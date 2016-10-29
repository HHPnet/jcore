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

import pm.hhp.core.services.groups.GroupResponse;

import java.util.UUID;

public class GroupFactory {
  /**
   * Generates a group entity given a groupId.
   *
   * @param groupId Id of the group.
   * @param name Name of the group.
   * @param description Description of the group.
   * @param city City of the group.
   * @param country Country of the group.
   * @return Group
   */
  Group getGroupEntity(
      GroupId groupId, String name, String description, String city, String country) {
    return new Group(groupId, name, description, city, country);
  }

  /**
   * Generates a group entity given a string as group id.
   *
   * @param groupId Id of the group.
   * @param name Name of the group.
   * @param description Description of the group.
   * @param city City of the group.
   * @param country Country of the group.
   * @return Group
   */
  public Group getGroupEntity(
      String groupId, String name, String description, String city, String country) {
    return getGroupEntity(new GroupId(groupId), name, description, city, country);
  }

  /**
   * Generates a group entity given a UUID as group id.
   *
   * @param groupId Id of the group.
   * @param name Name of the group.
   * @param description Description of the group.
   * @param city City of the group.
   * @param country Country of the group.
   * @return Group
   */
  Group getGroupEntity(UUID groupId, String name, String description, String city, String country) {
    return getGroupEntity(new GroupId(groupId), name, description, city, country);
  }

  /**
   * Generates a group entity generating a group id.
   *
   * @param name Name of the group.
   * @param description Description of the group.
   * @param city City of the group.
   * @param country Country of the group.
   * @return Group
   */
  public Group getGroupEntity(String name, String description, String city, String country) {
    return getGroupEntity(new GroupId(), name, description, city, country);
  }

  /**
   * Generate a group response object.
   *
   * @param group Group entity.
   * @return GroupResponse
   */
  public GroupResponse getGroupResponse(Group group) {
    return new GroupResponse(group);
  }
}
