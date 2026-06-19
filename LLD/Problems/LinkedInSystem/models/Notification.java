package LLD.Problems.LinkedInSystem.models;

import java.time.LocalDateTime;

import LLD.Problems.LinkedInSystem.enums.NotificationType;

public class Notification {
  private String id;
  private String notifContent;
  private NotificationType notifType;
  private LocalDateTime timestamp;
  private boolean isRead;

  public Notification(String id, String content, NotificationType type, LocalDateTime time) {
    this.id = id;
    notifContent = content;
    notifType = type;
    timestamp = time;
    isRead = false;
  }

  public String getId() {
    return id;
  }

  public String getNotificationContent() {
    return notifContent;
  }

  public NotificationType getType() {
    return notifType;
  }

  public boolean isNotifRead() {
    return isRead;
  }

  public void markAsRead() {
    isRead = true;
  }
}
