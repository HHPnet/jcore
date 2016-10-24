package pm.hhp.core.model.users;

import java.util.UUID;

public class UserFactory {
  public User getUserEntity(UserId userId, String name, String email) {
    return new User(userId, name, email);
  }

  public User getUserEntity(String userId, String name, String email) {
    return getUserEntity(new UserId(userId), name, email);
  }

  public User getUserEntity(UUID userId, String name, String email) {
    return getUserEntity(new UserId(userId), name, email);
  }

  public User getUserEntity(String name, String email) {
    return getUserEntity(new UserId(), name, email);
  }
}
