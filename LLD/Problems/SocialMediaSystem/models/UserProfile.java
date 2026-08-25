package LLD.Problems.SocialMediaSystem.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import LLD.Problems.SocialMediaSystem.notifications.Notification;

public class UserProfile {
  private String id;
  private String username;
  private String bio;
  private UserAccount account;
  private Set<Notification> notifications;
  private Set<ConnectionRequest> connReqs;
  private Set<Post> posts;
  private Set<UserProfile> friends;

  public UserProfile(String username, String bio, UserAccount account) {
    id = UUID.randomUUID().toString();
    this.username = username;
    this.bio = bio;
    this.account = account;
    notifications = new HashSet<>();
    connReqs = new HashSet<>();
    posts = new HashSet<>();
    friends = new HashSet<>();
  }

  public void accept(String connectionId) {
    for(ConnectionRequest reqs: connReqs) {
      if(reqs.getId() == connectionId) {
        friends.add(reqs.getUserProfile());
        reqs.getUserProfile().addFriend(this);
        connReqs.remove(reqs);
        break;
      }
    }
  }

  public void reject(String connectionId) {
    for(ConnectionRequest reqs: connReqs) {
      if(reqs.getId() == connectionId) {
        connReqs.remove(reqs);
        break;
      }
    }
  }

  public String getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getBio() {
    return bio;
  }

  public UserAccount getAccount() {
    return account;
  }

  public Set<Notification> getNotifications() {
    return notifications;
  }

  public Set<ConnectionRequest> getConnReqs() {
    return connReqs;
  }

  public Set<Post> getPosts() {
    return posts;
  }

  public Set<UserProfile> getFriends() {
    return friends;
  }

  public void addNotification(Notification notification) {
    notifications.add(notification);
  }

  public void addConnReq(ConnectionRequest connReq) {
    connReqs.add(connReq);
  }

  public void addPost(Post post) {
    posts.add(post);
  }

  public void addFriend(UserProfile friend) {
    friends.add(friend);
  }

  public void removeNotification(Notification notification) {
    notifications.remove(notification);
  }

  public void removeConnReq(ConnectionRequest connReq) {
    connReqs.remove(connReq);
  }

  public void removePost(Post post) {
    posts.remove(post);
  }

  public void removeFriend(UserProfile friend) {
    friends.remove(friend);
  }

}
