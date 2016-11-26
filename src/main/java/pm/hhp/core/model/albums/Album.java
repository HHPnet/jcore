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

import java.util.Date;

public class Album {
  private final AlbumId albumId;

  private final String groupId;

  private String name;

  private Date releaseDate;

  private String description;

  private String cover;

  /**
   * Get the Album entity.
   *  @param albumId Id of the album.
   * @param groupId Group that owns the album.
   * @param name Name of the album.
   * @param releaseDate Release date of the album.
   * @param description Description of the album.
   * @param cover Cover of the album.
   */
  Album(
          AlbumId albumId,
          String groupId,
          String name,
          Date releaseDate,
          String description,
          String cover
  ) {
    this.albumId = albumId;
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
  public String getAlbumId() {
    return albumId.getId();
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
   * Setter for property 'name'.
   *
   * @param name Value to set for property 'name'.
   */
  public Album setName(String name) {
    this.name = name;

    return this;
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
   * Setter for property 'releaseDate'.
   *
   * @param releaseDate Value to set for property 'releaseDate'.
   */
  public Album setReleaseDate(Date releaseDate) {
    this.releaseDate = releaseDate;

    return this;
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
   * Setter for property 'description'.
   *
   * @param description Value to set for property 'description'.
   */
  public Album setDescription(String description) {
    this.description = description;

    return this;
  }

  /**
   * Getter for property 'cover'.
   *
   * @return Value for property 'cover'.
   */
  public String getCover() {
    return cover;
  }

  /**
   * Setter for property 'cover'.
   *
   * @param cover Value to set for property 'cover'.
   */
  public Album setCover(String cover) {
    this.cover = cover;

    return this;
  }
}
