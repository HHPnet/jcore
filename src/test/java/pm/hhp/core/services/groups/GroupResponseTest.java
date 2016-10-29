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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pm.hhp.core.model.groups.Group;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.doReturn;

public class GroupResponseTest {
  private GroupResponse response;

  @Mock private Group group;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    response = new GroupResponse(group);
  }

  @After
  public void tearDown() throws Exception {
    response = null;
    group = null;
  }

  @Test
  public void itIsPossibleToGetGroupId() {
    doReturn("test").when(group).getGroupId();

    assertThat(response.getGroupId()).isEqualTo("test");
  }

  @Test
  public void itIsPossibleToGetGroupName() {
    doReturn("test").when(group).getName();

    assertThat(response.getName()).isEqualTo("test");
  }

  @Test
  public void itIsPossibleToGetGroupDescription() {
    doReturn("test").when(group).getDescription();

    assertThat(response.getDescription()).isEqualTo("test");
  }

  @Test
  public void itIsPossibleToGetGroupCity() {
    doReturn("test").when(group).getCity();

    assertThat(response.getCity()).isEqualTo("test");
  }

  @Test
  public void itIsPossibleToGetGroupCountry() {
    doReturn("test").when(group).getCountry();

    assertThat(response.getCountry()).isEqualTo("test");
  }
}
