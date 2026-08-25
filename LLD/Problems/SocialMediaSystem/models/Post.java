package LLD.Problems.SocialMediaSystem.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Post {
  private String id;
  private String caption;
  private UserProfile profile;
  private Set<Like> likes;
  private List<Comment> comments;

  public Post(String caption, UserProfile profile) {
    this.caption = caption;
    this.profile = profile;
    id = UUID.randomUUID().toString();
    likes = new HashSet<>();
    comments = new ArrayList<>();
  } 

  public String getId() {
    return id;
  }

  public String getCaption() {
    return caption;
  }

  public UserProfile getProfile() {
    return profile;
  }

  public Set<Like> getLikes() {
    return likes;
  }

  public void addLike(Like like) {
    likes.add(like);
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void addComment(Comment comment) {
    comments.add(comment);
  }

}
