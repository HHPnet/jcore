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

package pm.hhp.core.services.groups.getinformation;

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

public class GetGroupInformationServiceTest {
  private static final String GROUP_ID = "test_id";

  private GetGroupInformationService service;

  @Mock private GroupRepository repository;

  @Mock private GroupFactory factory;

  @Mock private GroupRequest request;

  @Mock private Group group;

  @Mock private GroupResponse response;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    service = new GetGroupInformationService(repository, factory);
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
  public void itDoesNotGetDataForANonExistingGroup() throws GroupNotFoundException {
    givenARequestToFindAnGroup();
    groupCouldNotBeFound();

    assertThat(service.execute(request)).isNull();
    verify(repository, times(1)).findById(GROUP_ID);
  }

  @Test
  public void itGetsAnGroupWhenExisting() throws GroupNotFoundException {
    givenARequestToFindAnGroup();
    groupExistsInDatabase();
    andGetAnGroupEntityFromTheFactory();

    assertThat(service.execute(request)).isEqualTo(response);
    verify(repository, times(1)).findById(GROUP_ID);
  }

  private void givenARequestToFindAnGroup() {
    doReturn(Optional.of(GROUP_ID)).when(request).getGroupId();
  }

  private void groupCouldNotBeFound() throws GroupNotFoundException {
    doThrow(new GroupNotFoundException()).when(repository).findById(GROUP_ID);
  }

  private void groupExistsInDatabase() throws GroupNotFoundException {
    doReturn(group).when(repository).findById(GROUP_ID);
  }

  private void andGetAnGroupEntityFromTheFactory() {
    doReturn(response).when(factory).getGroupResponse(group);
  }
}
