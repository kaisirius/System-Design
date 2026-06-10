package LLD.Problems.StackOverFlowSystem.models;

import LLD.Problems.StackOverFlowSystem.enums.VoteType;

public class Vote {
  private User voter;
  private VoteType type;

  public Vote(User voteUser, VoteType typeOfVote) {
    voter = voteUser;
    type = typeOfVote;
  }

  public User getVoter() {
    return voter;
  }

  public VoteType getType() {
    return type;
  }

  public void changeVoteType(VoteType newType) {
    type = newType;
  }
}
