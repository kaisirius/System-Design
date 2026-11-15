package LLD.Problems.Splitwise.strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import LLD.Problems.Splitwise.models.User;

public class ExactSplitStratgey implements ISplitStrategy {
  @Override
  public Map<User, Double> splitExpense(double totalAmount, List<User> participants ,Map<User, Double> splitData) {
    Map<User, Double> splits = new HashMap<>(); // Map to hold the calculated split
    for (User user : participants) {
      double amount = splitData.getOrDefault(user, 0.0);
      splits.put(user, amount);
    }
    return splits;
  }
}
