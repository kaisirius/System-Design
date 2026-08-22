package LLD.Problems.LibraryManagementSystem.strategy;

import java.util.ArrayList;
import java.util.List;

import LLD.Problems.LibraryManagementSystem.models.LibraryItem;

public class SearchByTitle implements SearchStrategy {
  @Override
  public List<LibraryItem> search(List<LibraryItem> items, String key) {
    List<LibraryItem> searchResult = new ArrayList<>();

    for(LibraryItem item: items) {
      if(item.getTitle() == key) searchResult.add(item);
    }
    return searchResult;
  }
}
