package LLD.Problems.Splitwise.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.swing.SpinnerDateModel;

import LLD.Problems.Splitwise.enums.SplitType;

public class Expense {
  private final String expenseId;
  private final ExpenseGroup group;
  private final User paidBy;
  private final double totalAmount;
  private final String name;
  private final SplitType splitType;
  private final List<User> participants;
  private final Map<User, Double> splits;
  private final LocalDateTime createdAt;

  public Expense(ExpenseGroup group, User paidBy, double totalAmount, String name, SplitType splitType, List<User> participants, Map<User, Double> splits) {
    expenseId = UUID.randomUUID().toString();
    createdAt = LocalDateTime.now();
    this.group = group;
    this.paidBy = paidBy;
    this.totalAmount = totalAmount;
    this.name = name;
    this.splitType = splitType;
    this.participants = participants;
    this.splits = splits;
  }

  public String getExpenseId() {
    return expenseId;
  }

  public ExpenseGroup getGroup() {
    return group;
  }

  public User getPaidBy() {
    return paidBy;
  }

  public double getTotalAmount() {
    return totalAmount;
  }

  public String getName() {
    return name;
  }

  public SplitType getSplitType() {
    return splitType;
  }

  public List<User> getParticipants() {
    return participants;
  }

  public Map<User, Double> getSplits() {
    return splits;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
}
