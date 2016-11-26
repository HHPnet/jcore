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

import pm.hhp.core.services.albums.AlbumResponse;

import java.util.Date;

public class AlbumFactory {
  /**
   * Generates an album entity given an AlbumId object.
   *
   * @param albumId Id of the album.
   * @param groupId Group that owns the album.
   * @param name Name of the album.
   * @param releaseDate Date when the album was released.
   * @param description Description of the album.
   * @param cover Cover of the album.
   * @return Album
   */
  Album getAlbumEntity(
          AlbumId albumId,
          String groupId,
          String name,
          Date releaseDate,
          String description,
          String cover
  ) {
    return new Album(albumId, groupId, name, releaseDate, description, cover);
  }

  /**
   * Generates an album entity given an string as album id.
   *
   * @param albumId Id of the album.
   * @param groupId Group that owns the album.
   * @param name Name of the album.
   * @param releaseDate Date when the album was released.
   * @param description Description of the album.
   * @param cover Cover of the album.
   * @return Album
   */
  public Album getAlbumEntity(
          String albumId,
          String  groupId,
          String name,
          Date releaseDate,
          String description,
          String cover
  ) {
    return getAlbumEntity(new AlbumId(albumId), groupId, name, releaseDate, description, cover);
  }

  /**
   * Generates an album entity given an string as album id.
   *
   * @param groupId Group that owns the album.
   * @param name Name of the album.
   * @param releaseDate Date when the album was released.
   * @param description Description of the album.
   * @param cover Cover of the album.
   * @return Album
   */
  public Album getAlbumEntity(
          String  groupId,
          String name,
          Date releaseDate,
          String description,
          String cover
  ) {
    return getAlbumEntity(new AlbumId(), groupId, name, releaseDate, description, cover);
  }

  /**
   * Generates an album response.
   *
   * @param album Album to generate the response.
   * @return AlbumResponse
   */
  public AlbumResponse getAlbumResponse(Album album) {
    return new AlbumResponse(album);
  }
}
