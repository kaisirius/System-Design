package LLD.Problems.LibraryManagementSystem.state;

import LLD.Problems.LibraryManagementSystem.models.ItemCopy;
import LLD.Problems.LibraryManagementSystem.models.Member;

public interface ItemState {
  public void checkoutItem(ItemCopy copy, Member member);
  public void returnItem(ItemCopy copy);
  public void holdItem(ItemCopy copy, Member member);
}
