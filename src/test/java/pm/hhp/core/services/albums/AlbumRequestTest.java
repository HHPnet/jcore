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

package pm.hhp.core.services.albums;

import org.junit.Test;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AlbumRequestTest {
  private static final String ALBUM_ID = "test_id";

  private static final String GROUP_ID = "test_group_id";

  private static final String NAME = "test_name";

  private static final Date RELEASE_DATE = new Date();

  private static final String DESCRIPTION = "test_description";

  private static final String COVER = "test_cover";

  @Test
  public void itIsPossibleToGenerateARequestWithAnAlbumId() {
    AlbumRequest request = new AlbumRequest(ALBUM_ID, GROUP_ID, NAME, RELEASE_DATE, DESCRIPTION, COVER);

    assertThat(request.getAlbumId().isPresent()).isTrue();
    assertThat(request.getGroupId()).isEqualTo(GROUP_ID);
    assertThat(request.getName()).isEqualTo(NAME);
    assertThat(request.getReleaseDate()).isEqualTo(RELEASE_DATE);
    assertThat(request.getDescription()).isEqualTo(DESCRIPTION);
    assertThat(request.getCover()).isEqualTo(COVER);
  }

  @Test
  public void itIsPossibleToGenerateARequestWithoutAlbumId() {
    AlbumRequest request = new AlbumRequest(GROUP_ID, NAME, RELEASE_DATE, DESCRIPTION, COVER);

    assertThat(request.getAlbumId().isPresent()).isFalse();
    assertThat(request.getGroupId()).isEqualTo(GROUP_ID);
    assertThat(request.getName()).isEqualTo(NAME);
    assertThat(request.getReleaseDate()).isEqualTo(RELEASE_DATE);
    assertThat(request.getDescription()).isEqualTo(DESCRIPTION);
    assertThat(request.getCover()).isEqualTo(COVER);
  }
}