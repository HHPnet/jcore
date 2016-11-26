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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AlbumTest {
  private static final String GROUP_ID = "test_group_id";

  private static final String ALBUM_NAME = "test_name";

  private static final Date ALBUM_RELEASE_DATE = new Date(100000L);

  private static final String ALBUM_DESCRIPTION = "test_description";

  private static final String ALBUM_COVER = "test_cover";

  private Album album;

  @Mock
  private AlbumId albumId;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    album = new Album(albumId, GROUP_ID, ALBUM_NAME, ALBUM_RELEASE_DATE, ALBUM_DESCRIPTION, ALBUM_COVER);
  }

  @After
  public void tearDown() throws Exception {
    album = null;
    albumId = null;
  }

  @Test
  public void itIsPossibleToGetAlbumId() {
    assertThat(album.getAlbumId()).isEqualTo(albumId.getId());
  }

  @Test
  public void itIsPossibleToGetAlbumsGroup() {
    assertThat(album.getGroupId()).isEqualTo(GROUP_ID);
  }

  @Test
  public void itIsPossibleToGetAlbumsName() {
    assertThat(album.getName()).isEqualTo(ALBUM_NAME);
  }

  @Test
  public void itIsPossibleToSetANewAlbumsName() {
    String newName = "new_test_name";

    assertThat(album.setName(newName).getName()).isEqualTo(newName);
  }

  @Test
  public void itIsPossibleToGetAlbumsReleaseDate() {
    assertThat(album.getReleaseDate()).isEqualTo(ALBUM_RELEASE_DATE);
  }

  @Test
  public void itIsPossibleToSetANewAlbumsReleaseDate() {
    Date newDate = new Date(200000L);

    assertThat(album.setReleaseDate(newDate).getReleaseDate()).isEqualTo(newDate);
  }

  @Test
  public void itIsPossibleToGetAlbumsDescription() {
    assertThat(album.getDescription()).isEqualTo(ALBUM_DESCRIPTION);
  }

  @Test
  public void itIsPossibleToSetANewAlbumsDescription() {
    String newDescription = "new_test_description";

    assertThat(album.setDescription(newDescription).getDescription()).isEqualTo(newDescription);
  }

  @Test
  public void itIsPossibleToGetAlbumsCover() {
    assertThat(album.getCover()).isEqualTo(ALBUM_COVER);
  }

  @Test
  public void itIsPossibleToSetANewAlbumsCover() {
    String newCover = "new_test_cover";

    assertThat(album.setCover(newCover).getCover()).isEqualTo(newCover);
  }
}