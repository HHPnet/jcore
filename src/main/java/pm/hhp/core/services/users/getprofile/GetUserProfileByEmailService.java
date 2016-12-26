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

package pm.hhp.core.services.users.getprofile;

import pm.hhp.core.model.users.UserFactory;
import pm.hhp.core.model.users.UserRepository;
import pm.hhp.core.model.users.exceptions.UserNotFoundException;
import pm.hhp.core.services.Service;
import pm.hhp.core.services.users.UserRequest;
import pm.hhp.core.services.users.UserResponse;

public class GetUserProfileByEmailService implements Service<UserRequest, UserResponse> {
  private final UserRepository repository;

  private final UserFactory factory;

  public GetUserProfileByEmailService(UserRepository repository, UserFactory factory) {
    this.repository = repository;
    this.factory = factory;
  }

  @Override
  public UserResponse execute(UserRequest request) {
    try {
      return factory.getUserResponse(repository.findByEmail(request.getEmail()));
    } catch (UserNotFoundException userNotFoundException) {
      return null;
    }
  }
}
