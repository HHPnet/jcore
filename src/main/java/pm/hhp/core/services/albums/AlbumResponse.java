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

import pm.hhp.core.model.albums.Album;
import pm.hhp.core.services.ServiceResponse;

import java.util.Date;

public class AlbumResponse implements ServiceResponse {
  private final Album album;

  /**
   * Generates an album response.
   *
   * @param album Album to generate the response.
   */
  public AlbumResponse(Album album) {
    this.album = album;
  }

  /**
   * Getter for property 'albumId'.
   *
   * @return Value for property 'albumId'.
   */
  public String getAlbumId() {
    return album.getAlbumId();
  }

  /**
   * Getter for property 'groupId'.
   *
   * @return Value for property 'groupId'.
   */
  public String getGroupId() {
    return album.getGroupId();
  }

  /**
   * Getter for property 'name'.
   *
   * @return Value for property 'name'.
   */
  public String getName() {
    return album.getName();
  }

  /**
   * Getter for property 'releaseDate'.
   *
   * @return Value for property 'releaseDate'.
   */
  public Date getReleaseDate() {
    return album.getReleaseDate();
  }

  /**
   * Getter for property 'description'.
   *
   * @return Value for property 'description'.
   */
  public String getDescription() {
    return album.getDescription();
  }

  /**
   * Getter for property 'cover'.
   *
   * @return Value for property 'cover'.
   */
  public String getCover() {
    return album.getCover();
  }
}
