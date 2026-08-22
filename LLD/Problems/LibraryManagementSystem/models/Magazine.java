package LLD.Problems.LibraryManagementSystem.models;

public class Magazine extends LibraryItem {
  private String publisher;

  public Magazine(String title, String publisher) {
    super(title);
    this.publisher = publisher;
  }

  @Override
  public String getAuthorOrPublisher() {
    return publisher;
  }
}
