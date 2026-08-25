package LLD.Problems.SocialMediaSystem.models;

public class Comment {
  private Post post;
  private UserProfile fromProfile;
  private String comment;

  public Comment(Post post, UserProfile fromProfile, String comment) {
    this.post = post;
    this.fromProfile = fromProfile;
    this.comment = comment;
  }

  public UserProfile getUserProfile() {
    return fromProfile;
  }

  public Post getPost() {
    return post;
  }

  public String getComment() {
    return comment;
  }
}
