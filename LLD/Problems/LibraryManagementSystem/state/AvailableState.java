package LLD.Problems.LibraryManagementSystem.state;

import LLD.Problems.LibraryManagementSystem.models.ItemCopy;
import LLD.Problems.LibraryManagementSystem.models.Member;
import LLD.Problems.LibraryManagementSystem.services.LoanService;

public class AvailableState implements ItemState {
  public void checkoutItem(ItemCopy copy, Member member) {
    LoanService.getInstance().createLoan(copy, member);
    copy.setState(new CheckedOutState());
  }
  public void returnItem(ItemCopy copy) {
    System.out.println("Cannot return an available item.");
  }
  public void holdItem(ItemCopy copy, Member member) {
    System.out.println("Cannot hold an available item."); 
  }
}
