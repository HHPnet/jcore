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

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GroupRequestTest {
  private static final String GROUP_ID = "test_id";

  private static final String GROUP_NAME = "test_name";

  private static final String GROUP_DESCRIPTION = "test_description";

  private static final String GROUP_CITY = "test_city";

  private static final String GROUP_COUNTRY = "test_country";

  @Test
  public void itIsPossibleToGenerateTheGroupRequestWithId() {
    GroupRequest request =
        new GroupRequest(GROUP_ID, GROUP_NAME, GROUP_DESCRIPTION, GROUP_CITY, GROUP_COUNTRY);

    assertThat(request.getGroupId().orElse(null)).isEqualTo(GROUP_ID);
    assertThat(request.getName()).isEqualTo(GROUP_NAME);
    assertThat(request.getDescription()).isEqualTo(GROUP_DESCRIPTION);
    assertThat(request.getCity()).isEqualTo(GROUP_CITY);
    assertThat(request.getCountry()).isEqualTo(GROUP_COUNTRY);
  }

  @Test
  public void itIsPossibleToGenerateTheGroupRequestWithoutId() {
    GroupRequest request =
        new GroupRequest(GROUP_NAME, GROUP_DESCRIPTION, GROUP_CITY, GROUP_COUNTRY);

    assertThat(request.getGroupId().isPresent()).isFalse();
    assertThat(request.getName()).isEqualTo(GROUP_NAME);
    assertThat(request.getDescription()).isEqualTo(GROUP_DESCRIPTION);
    assertThat(request.getCity()).isEqualTo(GROUP_CITY);
    assertThat(request.getCountry()).isEqualTo(GROUP_COUNTRY);
  }
}
