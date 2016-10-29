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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pm.hhp.core.services.groups.GroupResponse;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GroupFactoryTest {
  private static final String GROUP_ID = "832975fc-b717-4546-90e8-f7d708be1cff";

  private static final String GROUP_NAME = "test_name";

  private static final String GROUP_DESCRIPTION = "test_email";

  private static final String GROUP_CITY = "test_city";

  private static final String GROUP_COUNTRY = "test_country";

  @Mock private GroupId groupId;

  @Mock private Group group;

  private GroupFactory factory;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    factory = new GroupFactory();
  }

  @After
  public void tearDown() throws Exception {
    factory = null;
    groupId = null;
    group = null;
  }

  @Test
  public void itIsPossibleToGetGroupEntityGivenAGroupIdInstance() {
    assertThat(
            factory.getGroupEntity(
                groupId, GROUP_NAME, GROUP_DESCRIPTION, GROUP_CITY, GROUP_COUNTRY))
        .isInstanceOf(Group.class);
  }

  @Test
  public void itIsPossibleToGetGroupEntityGivenAStringAsGroupId() {
    assertThat(
            factory.getGroupEntity(
                GROUP_ID, GROUP_NAME, GROUP_DESCRIPTION, GROUP_CITY, GROUP_COUNTRY))
        .isInstanceOf(Group.class);
  }

  @Test
  public void itIsPossibleToGetGroupEntityGivenAUUIDgAsGroupId() {
    assertThat(
            factory.getGroupEntity(
                UUID.fromString(GROUP_ID),
                GROUP_NAME,
                GROUP_DESCRIPTION,
                GROUP_CITY,
                GROUP_COUNTRY))
        .isInstanceOf(Group.class);
  }

  @Test
  public void itIsPossibleToGetGroupEntityGivenNameAndEmail() {
    assertThat(factory.getGroupEntity(GROUP_NAME, GROUP_DESCRIPTION, GROUP_CITY, GROUP_COUNTRY))
        .isInstanceOf(Group.class);
  }

  @Test
  public void itIsPossibleToGetAGroupResponseEntityGivenAnGroup() {
    assertThat(factory.getGroupResponse(group)).isInstanceOf(GroupResponse.class);
  }
}
