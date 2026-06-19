package LLD.Problems.LinkedInSystem.models;

import java.time.LocalDateTime;

public class Comment {
  private LocalDateTime timestamp;
  private Account author;
  private String comment;

  public Comment(LocalDateTime time, Account commenter, String message) {
    author = commenter;
    timestamp = time;
    comment = message;
  }

  public Account getAuthor() {
    return author;
  }

  public LocalDateTime getTimeStamp() {
    return timestamp;
  }

  public String getComment() {
    return comment;
  }
}
