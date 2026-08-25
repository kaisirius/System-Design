package LLD.Problems.SocialMediaSystem.notifications;

import LLD.Problems.SocialMediaSystem.models.Post;
import LLD.Problems.SocialMediaSystem.models.UserProfile;

public class CommentNotification extends Notification {
  private UserProfile likeFrom;
  private Post likeOn;

  public CommentNotification(String msg, UserProfile profile, Post post) {
    super(msg);
    likeFrom = profile;
    likeOn = post;
  }

  public UserProfile getUserProfile() {
    return likeFrom;
  }

  public Post getPost() {
    return likeOn;
  }
}
