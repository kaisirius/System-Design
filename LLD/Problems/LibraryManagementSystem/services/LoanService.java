package LLD.Problems.LibraryManagementSystem.services;

import java.util.HashMap;
import java.util.Map;

import LLD.Problems.LibraryManagementSystem.models.ItemCopy;
import LLD.Problems.LibraryManagementSystem.models.Loan;
import LLD.Problems.LibraryManagementSystem.models.Member;

public class LoanService {
  private static LoanService instance;
  private Map<String, Loan> activeLoans;

  private LoanService() {
    activeLoans = new HashMap<>();
  }

  public static LoanService getInstance() {
    if(instance == null) {
      synchronized(LoanService.class) {
        if(instance == null) {
          instance = new LoanService();
        }
      }
    } 
    return instance;
  }

  public void createLoan(ItemCopy copy, Member member) {
    Loan loan = new Loan(copy, member);
    activeLoans.put(copy.getId(), loan);
    member.addLoan(loan);
  }

  public void endLoan(ItemCopy copy) {
    Loan loan = activeLoans.remove(copy.getId());
    loan.getMember().removeLoan(loan);
  }
}
