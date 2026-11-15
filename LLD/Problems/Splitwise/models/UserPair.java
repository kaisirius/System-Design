package LLD.Problems.Splitwise.models;

public class UserPair {
  private final User givesBack;
  private final User getsBack;
  
  public UserPair(User from, User to) {
    givesBack = from;
    getsBack = to;
  }

  public User getPayer() {
    return givesBack;
  }

  public User getReceiver() {
    return getsBack;
  }
}
