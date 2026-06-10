package LLD.Problems.StackOverFlowSystem.models;

public class Tag {
  private String tagId;
  private String tagName;

  public Tag(String id, String name) {
    tagId = id;
    tagName = name;
  }

  public String getId() {
    return tagId;
  }

  public String getTagName() {
    return tagName;
  }
}
