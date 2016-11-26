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
import pm.hhp.core.services.albums.AlbumResponse;

import java.util.Date;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AlbumFactoryTest {
  private AlbumFactory factory;

  @Mock
  private Album album;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    factory = new AlbumFactory();
  }

  @After
  public void tearDown() throws Exception {
    factory = null;
    album = null;
  }

  @Test
  public void itGeneratesAnAlbumEntityGivenAnAlbumId() {
    assertThat(factory.getAlbumEntity(new AlbumId(), "test", "test", new Date(), "tests", "test")).isInstanceOf(Album.class);
  }

  @Test
  public void itGeneratesAnAlbumEntityGivenAStringAsAlbumId() {
    assertThat(factory.getAlbumEntity(UUID.randomUUID().toString(), "test", "test", new Date(), "tests", "test")).isInstanceOf(Album.class);
  }

  @Test
  public void itGeneratesAnAlbumEntityWithoutAnAlbumIdProvided() {
    assertThat(factory.getAlbumEntity("test", "test", new Date(), "tests", "test")).isInstanceOf(Album.class);
  }

  @Test
  public void itGeneratesAnAlbumResponse() {
    assertThat(factory.getAlbumResponse(album)).isInstanceOf(AlbumResponse.class);
  }
}