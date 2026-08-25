package LLD.Problems.SocialMediaSystem.notifications;

import LLD.Problems.SocialMediaSystem.models.Post;

public class PostCreationNotification extends Notification {

  private Post likeOn;

  public PostCreationNotification(String msg, Post post) {
    super(msg);
    likeOn = post;
  }

  public Post getPost() {
    return likeOn;
  }
}
