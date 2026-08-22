package LLD.Problems.LibraryManagementSystem.factory;

import LLD.Problems.LibraryManagementSystem.enums.ItemType;
import LLD.Problems.LibraryManagementSystem.models.Book;
import LLD.Problems.LibraryManagementSystem.models.LibraryItem;
import LLD.Problems.LibraryManagementSystem.models.Magazine;

public class ItemFactory {
  public static LibraryItem createItem(ItemType type, String title, String auhorOrPublisher) {
    if(type == ItemType.BOOK) {
      return new Book(title, auhorOrPublisher);
    } else if(type == ItemType.MAGAZINE) {
      return new Magazine(title, auhorOrPublisher);
    } else {
      throw new RuntimeException();
    }
  }
}
