package LLD.Problems.LinkedInSystem.services;

import java.util.ArrayList;
import java.util.List;

import LLD.Problems.LinkedInSystem.models.Account;
import LLD.Problems.LinkedInSystem.models.Post;
import LLD.Problems.LinkedInSystem.strategy.IFeedSortingStrategy;

public class FeedService {
  private List<Post> allPosts;

  public FeedService() {
    allPosts = new ArrayList<>();
  }

  public void addPost(Post post) {
    allPosts.add(post);
  }

  public List<Post> displayFeedForAccount(Account account, IFeedSortingStrategy sortingStrategy) {
    // custom logic from allPosts
    List<Post> personalFeed = allPosts;
    return sortingStrategy.filterFeed(personalFeed);
  }
}
