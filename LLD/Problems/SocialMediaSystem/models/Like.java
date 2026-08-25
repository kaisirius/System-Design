package LLD.Problems.SocialMediaSystem.models;

public class Like {
  private Post post;
  private UserProfile fromProfile;

  public Like(Post post, UserProfile fromProfile) {
    this.post = post;
    this.fromProfile = fromProfile;
  }

  public UserProfile getUserProfile() {
    return fromProfile;
  }

  public Post getPost() {
    return post;
  }

}
