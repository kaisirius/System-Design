package LLD.Problems.SocialMediaSystem.repositories;

import java.util.HashMap;
import java.util.Map;

import LLD.Problems.SocialMediaSystem.models.Post;
import LLD.Problems.SocialMediaSystem.models.UserAccount;

public class PostRepository {
  private Map<String, Post> posts;
  private static PostRepository INSTANCE = new PostRepository();

  private PostRepository() {
    posts = new HashMap<>();
  }

  public static PostRepository getInstance() {
    return INSTANCE;
  }

  public void addPost(Post post) {
    posts.put(post.getId(), post);
  }

  public Post getAccById(String id) {
    return posts.get(id);
  }
}
