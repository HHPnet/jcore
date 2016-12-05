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

import pm.hhp.core.model.groups.Group;
import pm.hhp.core.services.ServiceResponse;

public class GroupResponse implements ServiceResponse {
  private final Group group;

  /**
   * Generates a group response.
   *
   * @param group Group to generate the response.
   */
  public GroupResponse(Group group) {
    this.group = group;
  }

  /**
   * Getter for property 'groupId'.
   *
   * @return Value for property 'groupId'.
   */
  public String getGroupId() {
    return group.getGroupId();
  }

  /**
   * Getter for property 'name'.
   *
   * @return Value for property 'name'.
   */
  public String getName() {
    return group.getName();
  }

  /**
   * Getter for property 'description'.
   *
   * @return Value for property 'description'.
   */
  public String getDescription() {
    return group.getDescription();
  }

  /**
   * Getter for property 'city'.
   *
   * @return Value for property 'city'.
   */
  public String getCity() {
    return group.getCity();
  }

  /**
   * Getter for property 'country'.
   *
   * @return Value for property 'country'.
   */
  public String getCountry() {
    return group.getCountry();
  }
}
