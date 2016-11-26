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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pm.hhp.core.model.albums.Album;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.doReturn;

public class AlbumResponseTest {
  private AlbumResponse response;

  @Mock
  private Album album;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    response = new AlbumResponse(album);
  }

  @After
  public void tearDown() throws Exception {
    album = null;
    response = null;
  }

  @Test
  public void itIsPossibleToGetAlbumId() {
    doReturn("test_id").when(album).getAlbumId();

    assertThat(response.getAlbumId()).isEqualTo("test_id");
  }

  @Test
  public void itIsPossibleToGetTheGroupThatCreatedTheAlbum() {
    doReturn("test_group_id").when(album).getGroupId();

    assertThat(response.getGroupId()).isEqualTo("test_group_id");
  }

  @Test
  public void itIsPossibleToGetAlbumName() {
    doReturn("test_name").when(album).getName();

    assertThat(response.getName()).isEqualTo("test_name");
  }

  @Test
  public void itIsPossibleToGetAlbumReleaseDate() {
    Date releaseDate = new Date();
    doReturn(releaseDate).when(album).getReleaseDate();

    assertThat(response.getReleaseDate()).isEqualTo(releaseDate);
  }

  @Test
  public void itIsPossibleToGetAlbumDescription() {
    doReturn("test_description").when(album).getDescription();

    assertThat(response.getDescription()).isEqualTo("test_description");
  }

  @Test
  public void itIsPossibleToGetAlbumCover() {
    doReturn("test_cover").when(album).getCover();

    assertThat(response.getCover()).isEqualTo("test_cover");
  }

}