package LLD.Problems.LibraryManagementSystem.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Member {
  private String id;
  private String name;
  private List<Loan> loans;
  
  public Member(String name) {
    id = UUID.randomUUID().toString();
    this.name = name;
    loans = new ArrayList<>();
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<Loan> getMemberActiveLoans() {
    return loans;
  }

  public void addLoan(Loan loan) {
    loans.add(loan);
  }

  public void removeLoan(Loan loan) {
    loans.remove(loan);
  }
}
