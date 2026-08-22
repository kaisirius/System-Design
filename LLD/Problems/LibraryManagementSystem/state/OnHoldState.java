package LLD.Problems.LibraryManagementSystem.state;

import LLD.Problems.LibraryManagementSystem.models.ItemCopy;
import LLD.Problems.LibraryManagementSystem.models.Member;
import LLD.Problems.LibraryManagementSystem.services.LoanService;

public class OnHoldState implements ItemState {
  public void checkoutItem(ItemCopy copy, Member member) {
    if(copy.getLibraryItem().isObserver(member)) {
      LoanService.getInstance().createLoan(copy, member);
      copy.getLibraryItem().removeObserver(member);
      copy.setState(new CheckedOutState());
      System.out.println("Hold fulfilled. " + copy.getId() + " checked out by " + member.getName());
    } else {
      System.out.println("Item only available for other members.");
    }
  }
  public void returnItem(ItemCopy copy) {
    System.out.println("Cannot return an on hold item.");
  }
  public void holdItem(ItemCopy copy, Member member) {
    System.out.println("Cannot hold an already on hold item."); 
  }
}
