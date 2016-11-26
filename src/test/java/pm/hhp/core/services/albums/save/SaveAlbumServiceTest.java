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

package pm.hhp.core.services.albums.save;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pm.hhp.core.model.albums.Album;
import pm.hhp.core.model.albums.AlbumFactory;
import pm.hhp.core.model.albums.AlbumRepository;
import pm.hhp.core.model.albums.exceptions.AlbumNotFoundException;
import pm.hhp.core.services.albums.AlbumRequest;
import pm.hhp.core.services.albums.AlbumResponse;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class SaveAlbumServiceTest {
  private static final String ALBUM_ID = "test_id";

  private static final String GROUP_ID = "test_group_id";

  private static final String ALBUM_NAME = "test_name";

  private static final Date ALBUM_RELEASE_DATE = new Date();

  private static final String ALBUM_DESCRIPTION = "test_description";

  private static final String ALBUM_COVER = "test_cover";

  private SaveAlbumService service;

  @Mock
  private AlbumRepository repository;

  @Mock private AlbumFactory factory;

  @Mock private AlbumRequest request;

  @Mock private Album album;

  @Mock private AlbumResponse response;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    service = new SaveAlbumService(repository, factory);
  }

  @After
  public void tearDown() throws Exception {
    service = null;
    repository = null;
    factory = null;
    request = null;
    album = null;
    response = null;
  }

  @Test
  public void itFailsWhenGivenAlbumDoesNotExist() throws AlbumNotFoundException {
    givenARequestToCreateAnAlbum();
    albumDoesNotExist();

    assertThat(service.execute(request)).isNull();
  }

  @Test
  public void itSavesAlbumWhenExists() throws AlbumNotFoundException {
    givenARequestToCreateAnAlbum();
    albumAlreadyExists();
    albumIsCreatedAndSaved();

    assertThat(service.execute(request)).isEqualTo(response);
    verify(repository, times(1)).save(album);
  }

  private void givenARequestToCreateAnAlbum() {
    doReturn(Optional.of(ALBUM_ID)).when(request).getAlbumId();
    doReturn(GROUP_ID).when(request).getGroupId();
    doReturn(ALBUM_NAME).when(request).getName();
    doReturn(ALBUM_RELEASE_DATE).when(request).getReleaseDate();
    doReturn(ALBUM_DESCRIPTION).when(request).getDescription();
    doReturn(ALBUM_COVER).when(request).getCover();

    doReturn(album)
            .when(factory)
            .getAlbumEntity(ALBUM_ID, GROUP_ID, ALBUM_NAME, ALBUM_RELEASE_DATE, ALBUM_DESCRIPTION, ALBUM_COVER);
    doReturn(ALBUM_ID).when(album).getAlbumId();
  }

  private void albumAlreadyExists() throws AlbumNotFoundException {
    doReturn(album).when(repository).findById(ALBUM_ID);
  }

  private void albumDoesNotExist() throws AlbumNotFoundException {
    doThrow(new AlbumNotFoundException()).when(repository).findById(ALBUM_ID);
  }

  private void albumIsCreatedAndSaved() {
    doReturn(album).when(repository).save(album);
    doReturn(response).when(factory).getAlbumResponse(album);
  }

}