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

package pm.hhp.core.services.groups.create;

import pm.hhp.core.model.groups.Group;
import pm.hhp.core.model.groups.GroupFactory;
import pm.hhp.core.model.groups.GroupRepository;
import pm.hhp.core.model.groups.exceptions.GroupNotFoundException;
import pm.hhp.core.services.Service;
import pm.hhp.core.services.groups.GroupRequest;
import pm.hhp.core.services.groups.GroupResponse;

public class CreateGroupService implements Service<GroupRequest, GroupResponse> {
  private GroupRepository repository;

  private GroupFactory factory;

  public CreateGroupService(GroupRepository repository, GroupFactory factory) {
    this.repository = repository;
    this.factory = factory;
  }

  @Override
  public GroupResponse execute(GroupRequest request) {
    Group group =
        factory.getGroupEntity(
            request.getName(), request.getDescription(), request.getCity(), request.getCountry());

    try {
      repository.findByName(group.getName());
      return null;
    } catch (GroupNotFoundException groupNotFoundException) {
      return factory.getGroupResponse(repository.save(group));
    }
  }
}
