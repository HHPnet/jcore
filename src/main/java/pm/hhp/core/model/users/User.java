package pm.hhp.core.model.users;

public class User {
  private UserId userId;

  private String name;

  private String email;

  public User(UserId userId, String name, String email) {
    this.userId = userId;
    this.name = name;
    this.email = email;
  }

  public String getUserId() {
    return userId.getUserId();
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public User setName(String name) {
    this.name = name;

    return this;
  }

  public User setEmail(String email) {
    this.email = email;

    return this;
  }
}
