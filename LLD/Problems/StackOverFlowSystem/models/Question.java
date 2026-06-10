package LLD.Problems.StackOverFlowSystem.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Question extends Post {
  private String quesId;
  private String quesHeading;
  private String quesDescription;
  private Answer acceptedAnswer;
  private List<Answer> answers;
  private List<Tag> tags;

  public Question(String id, String header, String content, String date, User user, List<Tag> tags) {
    super(date, user);
    quesId = id;
    quesHeading = header;
    quesDescription = content;
    acceptedAnswer = null;
    answers = new ArrayList<>();
    this.tags = tags; 
  }

  public void addAnswer(Answer newAnswer) {
    answers.add(newAnswer);
  }

  public void addTag(Tag newTag) {
    tags.add(newTag);
  }

  public void setAcceptedAnswer(String ansId) {
    for(int i = 0; i < answers.size(); i++) {
      if(answers.get(i).getId() == ansId) {
        acceptedAnswer = answers.get(i);
      }
    }
  }

  public String getId() {
    return quesId;
  }

  public String getQuestionHeading() {
    return quesHeading;
  }

  public String getQuestionDescription() {
    return quesDescription;
  }

  public Answer getAcceptedAnswer() {
    if(acceptedAnswer != null) return acceptedAnswer;
    return null;
  }

  public List<Answer> getAnswers() {
    return answers;
  }

  public List<Tag> getTags() {
    return tags;
  }
}
