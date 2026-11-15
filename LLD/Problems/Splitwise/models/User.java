package LLD.Problems.Splitwise.models;

import java.util.UUID;

public class User {
  private final String userId;
  private final String username;
  private final String email;

  public User(String username, String email) {
    userId = UUID.randomUUID().toString();
    this.username = username;
    this.email = email;
  }

  public String getUserName() {
    return username;
  }

  public String getEmailAddress() {
    return email;
  }

  public String getUserId() {
    return userId;
  }
}
