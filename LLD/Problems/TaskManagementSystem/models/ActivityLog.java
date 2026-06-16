package LLD.Problems.TaskManagementSystem.models;

import java.time.LocalDateTime;

public class ActivityLog {
  private String description;
  private LocalDateTime timestamp;

  public ActivityLog(String description) {
    this.description = description;
    timestamp = LocalDateTime.now();
  }

  public String getLogDescription() {
    return description;
  }

  public LocalDateTime getLogTimeStamp() {
    return timestamp;
  }
}
