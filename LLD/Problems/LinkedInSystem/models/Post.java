package LLD.Problems.LinkedInSystem.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import LLD.Problems.LinkedInSystem.enums.NotificationType;
import LLD.Problems.LinkedInSystem.observer.INotificationObserver;

public class Post {
  private String id;
  private String content;
  private Account author;
  private List<Like> likes;
  private List<Comment> comments;
  private LocalDateTime postedAt;
  private List<INotificationObserver> observers;

  public Post(String id, String content, Account author, LocalDateTime time) {
    this.id = id;
    this.content = content;
    this.author = author;
    likes = new ArrayList<>();
    comments = new ArrayList<>();
    postedAt = time;
    observers = new ArrayList<>();
    observers.add(author);
  }

  public void addLike(Like like) {
    likes.add(like);
    // notify observers
    Notification notification = new Notification("random-uuid", "Liked by: " + like.getAuthor().getName(), NotificationType.POST_LIKE, LocalDateTime.now());
    notifyObservers(notification);
  }

  public void addComment(Comment comment) {
    comments.add(comment);
    // notify observers
    Notification notification = new Notification("random-uuid", "Comment from: " + comment.getAuthor().getName(), NotificationType.POST_COMMENT, LocalDateTime.now());
    notifyObservers(notification);
  }

  public void addObserver(INotificationObserver obs) {
    observers.add(obs);
  }

  public void removeObserver(INotificationObserver obs) {
    observers.remove(obs);
  }

  public void notifyObservers(Notification notif) {
    for(INotificationObserver obs: observers) {
      obs.update(notif);
    }
  }


  public String getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  public Account getAuthor() {
    return author;
  }

  public List<Like> getLikes() {
    return likes;
  }

  public List<Comment> getComment() {
    return comments;
  }

  public LocalDateTime getTimeStamp() {
    return postedAt;
  }
}
