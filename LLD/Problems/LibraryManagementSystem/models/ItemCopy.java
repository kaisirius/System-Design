package LLD.Problems.LibraryManagementSystem.models;

import java.util.UUID;

import LLD.Problems.LibraryManagementSystem.state.AvailableState;
import LLD.Problems.LibraryManagementSystem.state.ItemState;

public class ItemCopy {
  private String id;
  private ItemState currentState;
  private LibraryItem item;

  public ItemCopy(LibraryItem item) {
    this.item = item;
    id = UUID.randomUUID().toString();
    currentState = new AvailableState();
  }
  
  public String getId() {
    return id;
  }

  public boolean isAvailable() {
    return (currentState instanceof AvailableState) ? true : false;
  }

  public LibraryItem getLibraryItem() {
    return item;
  }

  public void checkout(Member member) {
    currentState.checkoutItem(this, member);
  }

  public void hold(Member member) {
    currentState.holdItem(this, member);
  }

  public void returnItem() {
    currentState.returnItem(this);
  }

  public void setState(ItemState state) {
    currentState = state;
  }
}
