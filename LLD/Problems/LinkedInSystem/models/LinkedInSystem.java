package LLD.Problems.LinkedInSystem.models;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import LLD.Problems.LinkedInSystem.services.ConnectionService;
import LLD.Problems.LinkedInSystem.services.FeedService;
import LLD.Problems.LinkedInSystem.services.SearchService;
import LLD.Problems.LinkedInSystem.strategy.ChronologicalFeedSortingStrategy;

public class LinkedInSystem {
  private FeedService feedService;
  private SearchService searchService;
  private ConnectionService connectionService;
  private Map<String, Account> accounts;
  private Map<String, Post> posts;
  private static int counter = 1;
  private static int postCounter = 1;

  public LinkedInSystem() {
    feedService = new FeedService();
    searchService = new SearchService();
    connectionService = new ConnectionService();
    accounts = new HashMap<>();
    posts = new HashMap<>();
  }

  public String createAccount(String name, String email) {
    String id = "random-uuid-" + counter++;
    Account account = new Account(id, name, email);
    accounts.put(id, account);
    searchService.addAccount(account);

    return id;
  }

  public Account getAccount(String id) {
    return accounts.get(id);
  }

  public String createPost(String accountId, String content) {
    String id = "random-uuid-" + postCounter++;
    Post post = new Post(id, content, accounts.get(accountId), LocalDateTime.now());
    posts.put(id, post);
    feedService.addPost(post);
    accounts.get(accountId).addPost(post);

    return id;
  }

  public Post getPost(String id) {
    return posts.get(id);
  }

  public List<Account> searchByName(String name) {
    return searchService.searchAccountByName(name);
  }

  public List<Post> viewFeed(String id) {
    return feedService.displayFeedForAccount(accounts.get(id), new ChronologicalFeedSortingStrategy());
  }

  public String sendConnection(String fromAccountId, String toAccountId) {
    return connectionService.addConnection(accounts.get(fromAccountId), accounts.get(toAccountId), LocalDateTime.now());
  }

  public void acceptConnection(String id) {
    connectionService.acceptConnection(id);
  }

  public void likePost(String id, String accountId) {
    Like like = new Like(LocalDateTime.now(), accounts.get(accountId));
    posts.get(id).addLike(like);
  }

  public void commentPost(String id, String accountId, String comment) {
    Comment newComment = new Comment(LocalDateTime.now(), accounts.get(accountId), comment);
    posts.get(id).addComment(newComment);
  }
}
