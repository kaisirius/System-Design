package LLD.Problems.LinkedInSystem.strategy;

import java.util.List;

import LLD.Problems.LinkedInSystem.models.Post;

public class ChronologicalFeedSortingStrategy implements IFeedSortingStrategy {
  @Override
  public List<Post> filterFeed(List<Post> posts) {
    // custom logic
    return posts;
  }
}
