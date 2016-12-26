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

package pm.hhp.core.services.users.save;

import pm.hhp.core.model.users.User;
import pm.hhp.core.model.users.UserFactory;
import pm.hhp.core.model.users.UserRepository;
import pm.hhp.core.model.users.exceptions.UserNotAllowedToPerfomActionException;
import pm.hhp.core.model.users.exceptions.UserNotFoundException;
import pm.hhp.core.services.Service;
import pm.hhp.core.services.UserSession;
import pm.hhp.core.services.users.UserRequest;
import pm.hhp.core.services.users.UserResponse;

public class SaveUserService implements Service<UserRequest, UserResponse> {
  private final UserRepository repository;

  private final UserFactory factory;

  private final UserSession userSession;

  /**
   * Get the save user service instance.
   * @param repository User repository.
   * @param factory User factory.
   * @param userSession User session.
   */
  public SaveUserService(UserRepository repository, UserFactory factory, UserSession userSession) {
    this.repository = repository;
    this.factory = factory;
    this.userSession = userSession;
  }

  @Override
  public UserResponse execute(UserRequest request) throws UserNotAllowedToPerfomActionException {
    if (!userSession.isLoggedInUserId(request.getUserId().orElse(null))) {
      throw new UserNotAllowedToPerfomActionException();
    }

    User user =
        factory.getUserEntity(
            request.getUserId().orElse(null), request.getName(), request.getEmail());
    try {
      repository.findById(user.getUserId());

      return factory.getUserResponse(repository.save(user));
    } catch (UserNotFoundException userNotFound) {
      return null;
    }
  }
}
