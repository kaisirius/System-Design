package LLD.Problems.LibraryManagementSystem.state;

import LLD.Problems.LibraryManagementSystem.models.ItemCopy;
import LLD.Problems.LibraryManagementSystem.models.Member;
import LLD.Problems.LibraryManagementSystem.services.LoanService;

public class CheckedOutState implements ItemState {
  public void checkoutItem(ItemCopy copy, Member member) {
    System.out.println("Cannot check out an existing checked out item.");
  }
  public void returnItem(ItemCopy copy) {
    LoanService.getInstance().endLoan(copy);
    // when some one is returning two possiblities either someone vailable for hold or directly avaialble
    if(copy.getLibraryItem().hasObservers()) {
      copy.getLibraryItem().notifyObserver();
      copy.setState(new OnHoldState());
    } else {
      copy.setState(new AvailableState());
    }
  }
  public void holdItem(ItemCopy copy, Member member) {
    System.out.println("Placing hold on " + copy.getId());
    copy.getLibraryItem().addObserver(member);
  }
}
