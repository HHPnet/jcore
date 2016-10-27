package pm.hhp.core.model.users;

import org.junit.Test;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserIdTest {
  @Test
  public void itIsPossibleToGenerateAnUserIdGivenAUUID() {
    UUID userId = UUID.randomUUID();

    assertThat(new UserId(userId).getUserId()).isEqualTo(userId.toString());
  }

  @Test
  public void itIsPossibleToGenerateARandomUserId() {
    assertThat(new UserId().getUserId()).isInstanceOf(String.class);
  }

  @Test
  public void itIsPossibleToGenerateAnUserIdGivenAnString() {
    String userId = "832975fc-b717-4546-90e8-f7d708be1cff";
    assertThat(new UserId(userId).getUserId()).isEqualTo(userId);
  }
}
