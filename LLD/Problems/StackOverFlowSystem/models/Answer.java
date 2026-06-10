package LLD.Problems.StackOverFlowSystem.models;

import java.util.ArrayList;
import java.util.List;

public class Answer extends Post {
  private String ansId;
  private String ansContent;
  private boolean isAccepted;
  private Question question;

  public Answer(String id, String content, String date, User user, Question ques) {
    super(date, user);
    ansId = id;
    ansContent = content;
    isAccepted = false;
    question = ques;
  }

  public void markAnswerAccepted() {
    isAccepted = true;
  }

  public void unMarkAnswerAccepted() {
    isAccepted = false;
  }

  public String getId() {
    return ansId;
  }

  public String getAnsContent() {
    return ansContent;
  }

  public Question getQuestion() {
    return question;
  }

  public boolean isMarkedAsAccepted() {
    return isAccepted;
  }
}
