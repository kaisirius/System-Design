package LLD.Problems.SocialMediaSystem.models;

import java.util.UUID;

public class UserAccount {
  private String id;
  private String email;
  private UserProfile profile;

  public UserAccount(String email, UserProfile profile) {
    id = UUID.randomUUID().toString();
    this.email = email;
    this.profile = profile;
  }

  public String getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String get() {
    return id;
  }

  public UserProfile getProfile() {
    return profile;
  }


}
