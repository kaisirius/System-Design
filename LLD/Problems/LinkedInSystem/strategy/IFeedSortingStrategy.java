package LLD.Problems.LinkedInSystem.strategy;

import java.util.List;

import LLD.Problems.LinkedInSystem.models.Post;

public interface IFeedSortingStrategy {
  public List<Post> filterFeed(List<Post> posts);
}
