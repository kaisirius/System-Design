package LLD.Problems.StackOverFlowSystem.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import LLD.Problems.StackOverFlowSystem.enums.VoteType;

public class StackOverflowSystem {
  // make it singleton, too lazy to do it again
  private Map<String, Question> questions;
  private Map<String, Answer> answers;
  private Map<String, User> users;
  private Map<String, Tag> tags;

  public StackOverflowSystem() {
    questions = new HashMap<>();
    answers = new HashMap<>();
    users = new HashMap<>();
    tags = new HashMap<>();
  }

  public Question postQuestion(String heading, String description, String userId, List<Tag> tags) {
    Question ques = new Question("random1", heading, description, "10-06-2026", users.get(userId), tags);
    questions.put(ques.getId(), null);

    return ques;
  }  

  public Answer postAnswer(String description, String date, String userId, String quesId) {
    Answer ans = new Answer("random2", description, date, users.get(userId), questions.get(quesId));
    answers.put(ans.getId(), ans);
    questions.get(quesId).addAnswer(ans);

    return ans;
  } 
  
  public Comment addComment(String comment, String date, String userId, Post post) {
    Comment newComment = new Comment("random3", comment, date, users.get(userId));
    post.addComment(newComment);

    return newComment;
  }

  public void vote(String userId, VoteType type, Post post) {
    Vote vote = new Vote(users.get(userId), type);
    post.handleVote(vote);
  }

  public void acceptAnswer(String ansId) {
    answers.get(ansId).markAnswerAccepted();
  }

  public List<Question> searchQuestionByTag(String tag) {
    List<Question> result = new ArrayList<>();

    for(Map.Entry<String, Question> ques: questions.entrySet()) {
      List<Tag> tags = ques.getValue().getTags();
      if(tags.contains(tag)) {
        result.add(ques.getValue());
      } 
    }

    return result;
  }

  public List<Question> searchQuestionByUser(String userId) {
    List<Question> result = new ArrayList<>();

    for(Map.Entry<String, Question> ques: questions.entrySet()) {
      if(ques.getValue().getAuthor().getId() == userId) {
        result.add(ques.getValue());
      } 
    }

    return result;
  }
}
