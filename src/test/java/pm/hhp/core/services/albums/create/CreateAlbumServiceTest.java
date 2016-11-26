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

package pm.hhp.core.services.albums.create;

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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class CreateAlbumServiceTest {
  private static final String GROUP_ID = "test_group_id";

  private static final String NAME = "test_name";

  private static final Date RELEASE_DATE = new Date();

  private static final String DESCRIPTION = "test_description";

  private static final String COVER = "test_cover";

  private CreateAlbumService service;

  @Mock
  private AlbumRepository repository;

  @Mock
  private AlbumFactory factory;

  @Mock
  private Album album;

  @Mock
  private AlbumRequest request;

  @Mock
  private AlbumResponse response;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    service = new CreateAlbumService(repository, factory);
  }

  @After
  public void tearDown() throws Exception {
    service = null;
    repository = null;
    factory = null;
    album = null;
    request = null;
    response = null;
  }

  @Test
  public void itCreatesANewAlbumWhenNotFoundInDatabase() throws AlbumNotFoundException {
    givenARequestToCreateANewAlbum();
    doThrow(new AlbumNotFoundException()).when(repository).findByGroupAndName(GROUP_ID, NAME);
    doReturn(album).when(repository).save(album);
    doReturn(response).when(factory).getAlbumResponse(album);

    assertThat(service.execute(request)).isEqualTo(response);
  }

  @Test
  public void itIsNotPossibleToCreateAnAlbumWhenGivenGroupHasAnAlbumWithSameName() throws AlbumNotFoundException {
    givenARequestToCreateANewAlbum();
    doReturn(album).when(repository).findByGroupAndName(GROUP_ID, NAME);

    assertThat(service.execute(request)).isNull();
    verify(repository, never()).save(album);
  }

  private void givenARequestToCreateANewAlbum() {
    doReturn(GROUP_ID).when(request).getGroupId();
    doReturn(NAME).when(request).getName();
    doReturn(RELEASE_DATE).when(request).getReleaseDate();
    doReturn(DESCRIPTION).when(request).getDescription();
    doReturn(COVER).when(request).getCover();

    doReturn(album).when(factory).getAlbumEntity(GROUP_ID, NAME, RELEASE_DATE, DESCRIPTION, COVER);

    doReturn(GROUP_ID).when(album).getGroupId();
    doReturn(NAME).when(album).getName();
  }
}