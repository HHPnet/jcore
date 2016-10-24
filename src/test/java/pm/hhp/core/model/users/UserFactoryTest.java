package pm.hhp.core.model.users;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserFactoryTest {
  private static final String USER_ID = "832975fc-b717-4546-90e8-f7d708be1cff";

  private static final String USER_NAME = "test";

  private static final String USER_EMAIL = "test";

  @Mock
  private UserId userId;

  private UserFactory factory;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    factory = new UserFactory();
  }

  @After
  public void tearDown() throws Exception {
    factory = null;
    userId = null;
  }

  @Test
  public void itIsPossibleToGetUserEntityGivenAUserIdInstance() {
    assertThat(factory.getUserEntity(userId, USER_NAME, USER_EMAIL)).isInstanceOf(User.class);
  }

  @Test
  public void itIsPossibleToGetUserEntityGivenAStringAsUserId() {
    assertThat(factory.getUserEntity(USER_ID, USER_NAME, USER_EMAIL)).isInstanceOf(User.class);
  }

  @Test
  public void itIsPossibleToGetUserEntityGivenAUUIDgAsUserId() {
    assertThat(factory.getUserEntity(UUID.fromString(USER_ID), USER_NAME, USER_EMAIL)).isInstanceOf(User.class);
  }

  @Test
  public void itIsPossibleToGetUserEntityGivenNameAndEmail() {
    assertThat(factory.getUserEntity(USER_NAME, USER_EMAIL)).isInstanceOf(User.class);
  }
}
