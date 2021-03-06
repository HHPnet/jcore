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

package pm.hhp.core.model.albums;

import org.junit.Test;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AlbumIdTest {
  @Test
  public void itIsPossibleToGenerateAnAlbumIdGivenAUUID() {
    UUID albumId = UUID.randomUUID();

    assertThat(new AlbumId(albumId).getId()).isEqualTo(albumId.toString());
  }

  @Test
  public void itIsPossibleToGenerateARandomAlbumId() {
    assertThat(new AlbumId().getId()).isInstanceOf(String.class);
  }

  @Test
  public void itIsPossibleToGenerateAnAlbumIdGivenAnString() {
    String albumId = "832975fc-b717-4546-90e8-f7d708be1cff";
    assertThat(new AlbumId(albumId).getId()).isEqualTo(albumId);
  }
}