package LLD.Problems.LinkedInSystem.models;

import java.time.LocalDateTime;

public class Like {
  private LocalDateTime timestamp;
  private Account author;

  public Like(LocalDateTime time, Account liker) {
    author = liker;
    timestamp = time;
  }

  public Account getAuthor() {
    return author;
  }

  public LocalDateTime getTimeStamp() {
    return timestamp;
  }
}
