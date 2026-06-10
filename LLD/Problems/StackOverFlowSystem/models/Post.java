package LLD.Problems.StackOverFlowSystem.models;

import java.util.ArrayList;
import java.util.List;

import LLD.Problems.StackOverFlowSystem.enums.VoteType;

public class Post {
  protected String dateAdded;
  protected List<Comment> comments;
  protected List<Vote> votes;
  protected User author;
  protected int voteScore;

  protected Post(String date, User user) {
    dateAdded = date;
    author = user;
    voteScore = 0;
    comments = new ArrayList<>();
    votes = new ArrayList<>();
  }

  public void handleVote(Vote vote) {
    boolean isValidVote = true;
    boolean hasExistingVote = false;
    int existingVoteIndex = -1;

    for(int i = 0; i < votes.size(); i++) {
      Vote v = votes.get(i);
      if(v.getVoter().getId() == vote.getVoter().getId() && v.getType() == vote.getType()) {
        isValidVote = false;
      }
      if(v.getVoter().getId() == vote.getVoter().getId()) {
        hasExistingVote = true;
        existingVoteIndex = i;
      }
    }
    if(!isValidVote) {
      System.out.println("Can't perform the same vote twice.");
      return;
    }

    if(hasExistingVote) {
      voteScore = vote.getType() == VoteType.UPVOTE ? voteScore + 2 : voteScore - 2;

      int currentAuthorScore = author.getReputationScore();
      author.setReputationScore(vote.getType() == VoteType.UPVOTE ? currentAuthorScore + 2 : currentAuthorScore - 2);

      votes.set(existingVoteIndex, vote);
    } else {
      voteScore = vote.getType() == VoteType.UPVOTE ? voteScore + 1 : voteScore - 1;

      int currentAuthorScore = author.getReputationScore();
      author.setReputationScore(vote.getType() == VoteType.UPVOTE ? currentAuthorScore + 1 : currentAuthorScore - 1);

      votes.add(vote);
    } 
  }  

  public void addComment(Comment comment) {
    comments.add(comment);
  }

  public String getDateAdded() {
    return dateAdded;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public List<Vote> getVotes() {
    return votes;
  }

  public User getAuthor() {
    return author;
  }

  public int getVoteScore() {
    return voteScore;
  }
}
