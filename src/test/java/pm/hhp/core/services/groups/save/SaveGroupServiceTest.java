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

package pm.hhp.core.services.groups.save;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pm.hhp.core.model.groups.Group;
import pm.hhp.core.model.groups.GroupFactory;
import pm.hhp.core.model.groups.GroupRepository;
import pm.hhp.core.model.groups.exceptions.GroupNotFoundException;
import pm.hhp.core.services.groups.GroupRequest;
import pm.hhp.core.services.groups.GroupResponse;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class SaveGroupServiceTest {
  private static final String GROUP_ID = "test_id";

  private static final String GROUP_NAME = "test_name";

  private static final String GROUP_DESCRIPTION = "test_description";

  private static final String GROUP_CITY = "test_city";

  private static final String GROUP_COUNTRY = "test_country";

  private SaveGroupService service;

  @Mock private GroupRepository repository;

  @Mock private GroupFactory factory;

  @Mock private GroupRequest request;

  @Mock private Group group;

  @Mock private GroupResponse response;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    service = new SaveGroupService(repository, factory);
  }

  @After
  public void tearDown() throws Exception {
    service = null;
    repository = null;
    factory = null;
    request = null;
    group = null;
    response = null;
  }

  @Test
  public void itFailsWhenGivenGroupDoesNotExist() throws GroupNotFoundException {
    givenARequestToCreateAGroup();
    groupDoesNotExist();

    assertThat(service.execute(request)).isNull();
  }

  @Test
  public void itSavesGroupWhenExists() throws GroupNotFoundException {
    givenARequestToCreateAGroup();
    groupAlreadyExists();
    groupIsCreatedAndSaved();

    assertThat(service.execute(request)).isEqualTo(response);
    verify(repository, times(1)).save(group);
  }

  private void givenARequestToCreateAGroup() {
    doReturn(Optional.of(GROUP_ID)).when(request).getGroupId();
    doReturn(GROUP_NAME).when(request).getName();
    doReturn(GROUP_DESCRIPTION).when(request).getDescription();
    doReturn(GROUP_CITY).when(request).getCity();
    doReturn(GROUP_COUNTRY).when(request).getCountry();
    doReturn(group)
        .when(factory)
        .getGroupEntity(GROUP_ID, GROUP_NAME, GROUP_DESCRIPTION, GROUP_CITY, GROUP_COUNTRY);
    doReturn(GROUP_ID).when(group).getGroupId();
  }

  private void groupAlreadyExists() throws GroupNotFoundException {
    doReturn(group).when(repository).findById(GROUP_ID);
  }

  private void groupDoesNotExist() throws GroupNotFoundException {
    doThrow(new GroupNotFoundException()).when(repository).findById(GROUP_ID);
  }

  private void groupIsCreatedAndSaved() {
    doReturn(group).when(repository).save(group);
    doReturn(response).when(factory).getGroupResponse(group);
  }
}
