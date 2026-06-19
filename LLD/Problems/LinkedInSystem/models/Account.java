package LLD.Problems.LinkedInSystem.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import LLD.Problems.LinkedInSystem.observer.INotificationObserver;

public class Account implements INotificationObserver {

  private String accountId;
  private String name;
  private String email;
  private Profile userProfile;
  private List<Notification> notifications;
  private List<Post> posts;
  private Set<Account> connections;

  public Account(String id, String name, String email) {
    accountId = id;
    this.name = name;
    this.email = email;
    userProfile = new Profile();
    notifications = new ArrayList<>();
    posts = new ArrayList<>();
    connections = new HashSet<>();
  }

  public void addPost(Post post) {
    posts.add(post);
    // can make notif to all connections
  }

  public void removePost(Post post) {
    posts.remove(post);
  }

  public void addConnection(Account account) {
    connections.add(account);
  }

  public void removeConnection(Account account) {
    connections.remove(account);
  }

  @Override
  public void update(Notification notif) {
    notifications.add(notif);
    System.out.println("----Received a notification in account named : " + name + " " + notif.getNotificationContent());
  }

  public String getId() {
    return accountId;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public Profile getProfile() {
    return userProfile;
  }

  public List<Notification> getAllNotifications() {
    return notifications;
  }

  public List<Post> getAllPosts() {
    return posts;
  }

  public Collection<Account> getConnections() {
    return connections;
  }
}
