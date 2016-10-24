package net.hiphopproducciones.dev.core.model.users;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserTest {
  private static final String USER_NAME = "test";

  private static final String USER_EMAIL = "test@test.com";

  private static final UserId USER_ID = new UserId();

  private User user;

  @Before
  public void setUp() throws Exception {
    user = new User(USER_ID, USER_NAME, USER_EMAIL);
  }

  @After
  public void tearDown() throws Exception {
    user = null;
  }

  @Test
  public void itIsPossibleToGetUserId() {
    assertThat(user.getUserId()).isEqualTo(USER_ID.getUserId());
  }

  @Test
  public void itIsPossibleToGetUserName() {
    assertThat(user.getName()).isEqualTo(USER_NAME);
  }

  @Test
  public void itIsPossibleToGetUserEmail() {
    assertThat(user.getEmail()).isEqualTo(USER_EMAIL);
  }

  @Test
  public void itIsPossibleToSetNewUserName() {
    String userName = "test_new";
    assertThat(user.setName(userName).getName()).isEqualTo(userName);
  }

  @Test
  public void itIsPossibleToSetNewUserEmail() {
    String userEmail = "test_new@test.com";
    assertThat(user.setEmail(userEmail).getEmail()).isEqualTo(userEmail);
  }
}
