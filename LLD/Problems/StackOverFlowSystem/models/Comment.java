package LLD.Problems.StackOverFlowSystem.models;

public class Comment {
  private String commentId;
  private String comment;
  private User author;
  private String dateAdded;

  public Comment(String id, String comment, String date, User user) {
    commentId = id;
    this.comment = comment;
    author = user;
    dateAdded = date;
  }

  public String getId() {
    return commentId;
  }

  public String getComment() {
    return comment;
  }

  public String getDateAdded() {
    return dateAdded;
  }

  public User getAuthor() {
    return author;
  }
}
