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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GroupTest {
  private static final GroupId GROUP_ID = new GroupId();

  private static final String GROUP_NAME = "test_name";

  private static final String GROUP_DESCRIPTION = "test_email";

  private static final String GROUP_CITY = "test_city";

  private static final String GROUP_COUNTRY = "test_country";

  private Group group;

  @Before
  public void setUp() throws Exception {
    group = new Group(GROUP_ID, GROUP_NAME, GROUP_DESCRIPTION, GROUP_CITY, GROUP_COUNTRY);
  }

  @After
  public void tearDown() throws Exception {
    group = null;
  }

  @Test
  public void itIsPossibleToGetGroupId() {
    assertThat(group.getGroupId()).isEqualTo(GROUP_ID.getId());
  }

  @Test
  public void itIsPossibleToGetGroupName() {
    assertThat(group.getName()).isEqualTo(GROUP_NAME);
  }

  @Test
  public void itIsPossibleToChangeGroupName() {
    String groupName = "new_name";

    assertThat(group.setName(groupName).getName()).isEqualTo(groupName);
  }

  @Test
  public void itIsPossibleToGetGroupDescription() {
    assertThat(group.getDescription()).isEqualTo(GROUP_DESCRIPTION);
  }

  @Test
  public void itIsPossibleToChangeGroupDescription() {
    String groupDescription = "new_description";

    assertThat(group.setDescription(groupDescription).getDescription()).isEqualTo(groupDescription);
  }

  @Test
  public void itIsPossibleToGetGroupCity() {
    assertThat(group.getCity()).isEqualTo(GROUP_CITY);
  }

  @Test
  public void itIsPossibleToChangeGroupCity() {
    String groupCity = "new_city";

    assertThat(group.setCity(groupCity).getCity()).isEqualTo(groupCity);
  }

  @Test
  public void itIsPossibleToGetGroupCountry() {
    assertThat(group.getCountry()).isEqualTo(GROUP_COUNTRY);
  }

  @Test
  public void itIsPossibleToChangeGroupCountry() {
    String groupCountry = "new_country";

    assertThat(group.setCountry(groupCountry).getCountry()).isEqualTo(groupCountry);
  }
}
