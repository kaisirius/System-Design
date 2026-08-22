package LLD.Problems.LibraryManagementSystem.models;

public class Book extends LibraryItem {
  private String author;

  public Book(String title, String author) {
    super(title);
    this.author = author;
  }

  @Override
  public String getAuthorOrPublisher() {
    return author;
  }
}
