package LLD.Problems.Splitwise.strategy;

import java.util.List;
import java.util.Map;

import LLD.Problems.Splitwise.models.User;

public interface ISplitStrategy {
  public Map<User, Double> splitExpense(double totalAmount, List<User> participants, Map<User, Double> splitData); 
}
