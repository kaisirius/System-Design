package LLD.Problems.LibraryManagementSystem.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class LibraryItem {
  private String id;
  private String title;
  private List<ItemCopy> copies;
  private List<Member> observers;

  public LibraryItem(String title) {
    this.title = title;
    id = UUID.randomUUID().toString();
    copies = new ArrayList<>();
    observers = new ArrayList<>();
  }

  public void addObserver(Member member) {
    observers.add(member);
  }

  public void removeObserver(Member member) {
    observers.remove(member);
  }

  public void addCopy(ItemCopy copy) {
    copies.add(copy);
  }

  public void removeCopy(ItemCopy copy) {
    copies.remove(copy);
  }

  public boolean hasObservers() {
    return observers.size() > 0 ? true : false;
  }

  public void notifyObserver() {
    for(Member member: observers) {
      System.out.println("Hello " + member.getName() + ". Item named: " + title + " is ready. You may proceed to checkout before others as it is FCFS.");
    }
  }

  public ItemCopy getAvailableCopy() {
    return copies.stream().filter(cpy -> cpy.isAvailable()).findFirst().orElse(null);
  }

  public boolean isObserver(Member member) {
    return observers.contains(member);
  }

  public abstract String getAuthorOrPublisher();

  public String getTitle() {
    return title;
  }

  public List<ItemCopy> getCopies() {
    return copies;
  }

  public String getId() {
    return id;
  }

  public int getAvailableCopyCount() {
    return (int)copies.stream().filter(cpy -> cpy.isAvailable()).count();
  }
}
