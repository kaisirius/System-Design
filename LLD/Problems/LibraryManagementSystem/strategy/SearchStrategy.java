package LLD.Problems.LibraryManagementSystem.strategy;

import java.util.List;

import LLD.Problems.LibraryManagementSystem.models.LibraryItem;

public interface SearchStrategy {
  public List<LibraryItem> search(List<LibraryItem> items, String key);
}
