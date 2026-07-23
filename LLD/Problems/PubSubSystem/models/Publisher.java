package LLD.Problems.PubSubSystem.models;

public class Publisher {
  private int publisherId;
  private static int autoIncrementor = 1;
  private String name;

  public Publisher(String name) {
    publisherId = autoIncrementor++;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return publisherId;
  }
}
