package LLD.Problems.SocialMediaSystem.strategy;

import java.util.List;

import LLD.Problems.SocialMediaSystem.models.Post;
import LLD.Problems.SocialMediaSystem.models.UserProfile;

public interface FeedGenStrategy {
  public List<Post> getNextFeedResults(UserProfile profile, List<Post> posts);
}
