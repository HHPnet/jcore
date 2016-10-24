package net.hiphopproducciones.dev.core.model.users;

import java.util.UUID;

class UserId {
  private UUID userId;

  public UserId(UUID userId) {
    this.userId = userId;
  }

  public UserId() {
    this.userId = UUID.randomUUID();
  }

  public UserId(String userId) {
    this.userId = UUID.fromString(userId);
  }

  public String getUserId() {
    return userId.toString();
  }
}
