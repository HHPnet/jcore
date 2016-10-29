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

import org.junit.Test;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GroupIdTest {
  @Test
  public void itIsPossibleToGenerateAnGroupIdGivenAUUID() {
    UUID groupId = UUID.randomUUID();

    assertThat(new GroupId(groupId).getId()).isEqualTo(groupId.toString());
  }

  @Test
  public void itIsPossibleToGenerateARandomGroupId() {
    assertThat(new GroupId().getId()).isInstanceOf(String.class);
  }

  @Test
  public void itIsPossibleToGenerateAnGroupIdGivenAnString() {
    String groupId = "832975fc-b717-4546-90e8-f7d708be1cff";
    assertThat(new GroupId(groupId).getId()).isEqualTo(groupId);
  }
}
