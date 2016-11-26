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

import pm.hhp.core.model.albums.Album;
import pm.hhp.core.model.albums.AlbumFactory;
import pm.hhp.core.model.albums.AlbumRepository;
import pm.hhp.core.model.albums.exceptions.AlbumNotFoundException;
import pm.hhp.core.services.Service;
import pm.hhp.core.services.albums.AlbumRequest;
import pm.hhp.core.services.albums.AlbumResponse;

public class CreateAlbumService implements Service<AlbumRequest, AlbumResponse> {
  private AlbumRepository repository;

  private AlbumFactory factory;

  public CreateAlbumService(AlbumRepository repository, AlbumFactory factory) {
    this.repository = repository;
    this.factory = factory;
  }

  @Override
  public AlbumResponse execute(AlbumRequest request) {
    Album album = factory.getAlbumEntity(
            request.getGroupId(),
            request.getName(),
            request.getReleaseDate(),
            request.getDescription(),
            request.getCover()
    );

    try {
      repository.findByGroupAndName(album.getGroupId(), album.getName());
      return null;
    } catch (AlbumNotFoundException albumNotFoundException) {
      return factory.getAlbumResponse(repository.save(album));
    }
  }
}
