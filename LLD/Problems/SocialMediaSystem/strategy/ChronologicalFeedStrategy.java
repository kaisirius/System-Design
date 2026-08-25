package LLD.Problems.SocialMediaSystem.strategy;

import java.util.ArrayList;
import java.util.List;

import LLD.Problems.SocialMediaSystem.models.Post;
import LLD.Problems.SocialMediaSystem.models.UserProfile;

public class ChronologicalFeedStrategy implements FeedGenStrategy {
  @Override
  public List<Post> getNextFeedResults(UserProfile profile, List<Post> posts) {
    List<Post> results = new ArrayList<>();

    // for(Post post:  posts) {
    //   if(post.getProfile() == profile) results.add(post);
    //   else if(profile.getFriends().contains(post.getProfile())) results.add(post);
    // }

    return results;
  }
}
