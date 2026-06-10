package LLD.Problems.StackOverFlowSystem.models;

public class User {
  private String userId;
  private String name;
  private int reputationScore;

  public User(String id, String name) {
    this.userId = id;
    this.name = name;
    reputationScore = 0;
  }

  public String getName() {
    return name;
  }

  public String getId() {
    return userId;
  }

  public int getReputationScore() {
    return reputationScore;
  }

  public void setReputationScore(int score) {
    reputationScore = score;
  }
}
