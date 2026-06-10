package LLD.Problems.StackOverFlowSystem.enums;

public enum VoteType {
  UPVOTE(1),
  DOWNVOTE(-1);

  int value;
  VoteType(int value) {
    this.value = value;
  }
}
