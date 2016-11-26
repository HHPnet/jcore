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

import pm.hhp.core.services.ServiceRequest;

import java.util.Date;
import java.util.Optional;

public class AlbumRequest implements ServiceRequest {
  private final String albumId;

  private final String groupId;

  private final String name;

  private final Date releaseDate;

  private final String description;

  private final String cover;

  /**
   * Generate a request to interact with album services.
   * @param albumId Id of the album.
   * @param groupId Group that owns the album.
   * @param name Name of the album.
   * @param releaseDate Date when the album was released.
   * @param description Description of the album.
   * @param cover Cover of the album.
   */
  public AlbumRequest(String albumId, String groupId, String name, Date releaseDate, String description, String cover) {
    this.albumId = albumId;
    this.groupId = groupId;
    this.name = name;
    this.releaseDate = releaseDate;
    this.description = description;
    this.cover = cover;
  }

  /**
   * Generate a request to interact with album services.
   * @param groupId Group that owns the album.
   * @param name Name of the album.
   * @param releaseDate Date when the album was released.
   * @param description Description of the album.
   * @param cover Cover of the album.
   */
  public AlbumRequest(String groupId, String name, Date releaseDate, String description, String cover) {
    this.albumId = null;
    this.groupId = groupId;
    this.name = name;
    this.releaseDate = releaseDate;
    this.description = description;
    this.cover = cover;
  }

  /**
   * Getter for property 'albumId'.
   *
   * @return Value for property 'albumId'.
   */
  public Optional<String> getAlbumId() {
    return Optional.ofNullable(albumId);
  }

  /**
   * Getter for property 'groupId'.
   *
   * @return Value for property 'groupId'.
   */
  public String getGroupId() {
    return groupId;
  }

  /**
   * Getter for property 'name'.
   *
   * @return Value for property 'name'.
   */
  public String getName() {
    return name;
  }

  /**
   * Getter for property 'releaseDate'.
   *
   * @return Value for property 'releaseDate'.
   */
  public Date getReleaseDate() {
    return releaseDate;
  }

  /**
   * Getter for property 'description'.
   *
   * @return Value for property 'description'.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Getter for property 'cover'.
   *
   * @return Value for property 'cover'.
   */
  public String getCover() {
    return cover;
  }
}
