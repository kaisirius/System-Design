package LLD.Problems.LibraryManagementSystem.models;

import java.time.LocalDateTime;

public class Loan {
  private ItemCopy copy;
  private Member member;
  private LocalDateTime checkoutDate;

  public Loan(ItemCopy copy, Member member) {
    this.copy = copy;
    this.member = member;
    checkoutDate = LocalDateTime.now();
  }

  public ItemCopy getCopy() {
    return copy;
  }

  public Member getMember() {
    return member;
  }

  public LocalDateTime getCheckoutDateTime() {
    return checkoutDate;
  }
}
