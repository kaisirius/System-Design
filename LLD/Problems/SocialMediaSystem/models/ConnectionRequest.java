package LLD.Problems.SocialMediaSystem.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class ConnectionRequest {
  private String id;
  private UserProfile fromProfile;
  private LocalDateTime timestamp;

  public ConnectionRequest(UserProfile profile) {
    id = UUID.randomUUID().toString();
    fromProfile = profile;
    timestamp = LocalDateTime.now();
  }

  public String getId() {
    return id;
  }

  public UserProfile getUserProfile() {
    return fromProfile;
  }

  public LocalDateTime getTimeStamp() {
    return timestamp;
  }
}
