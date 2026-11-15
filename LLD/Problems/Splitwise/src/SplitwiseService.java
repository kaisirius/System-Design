import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.InvalidAttributeValueException;
import javax.naming.directory.InvalidAttributeIdentifierException;

import LLD.Problems.Splitwise.enums.SplitType;
import LLD.Problems.Splitwise.factory.SplitMethodFactory;
import LLD.Problems.Splitwise.models.Expense;
import LLD.Problems.Splitwise.models.ExpenseGroup;
import LLD.Problems.Splitwise.models.User;
import LLD.Problems.Splitwise.strategy.ISplitStrategy;

public class SplitwiseService {
  private final Map<String, User> users;
  private final Map<String, Expense> expenses;
  private final Map<String, ExpenseGroup> expenseGroups;
  private static SplitwiseService instance;
  
  private SplitwiseService() {
    users = new HashMap<>();
    expenses = new HashMap<>();
    expenseGroups = new HashMap<>();
  }

  public static SplitwiseService getIntance() {
    if(instance == null) {
      synchronized(SplitwiseService.class) {
        if(instance == null) {
          instance = new SplitwiseService();
        }
      }
    }
    return instance;
  }
  
  public void addUser(User user) {
    users.put(user.getUserId(), user);
  }

  public void addExpenseGroup(ExpenseGroup group) {
    expenseGroups.put(group.getGroupId(), group);
  }

  public void addExpense(Expense expense) {
    expenses.put(expense.getExpenseId(), expense);
    
  }

  public Expense createExpense(String groupId, String userId, double totalAmount, SplitType splitType, String expenseName, Map<User, Double> splitData, List<User> participants) throws Exception {
    User user = users.get(userId);
    ExpenseGroup group = expenseGroups.get(groupId);

    ISplitStrategy splitStrategy = SplitMethodFactory.createSplitMethod(splitType);
    Map<User, Double> splits = splitStrategy.splitExpense(totalAmount, participants, splitData);
    
    Expense expense = new Expense(group, user, totalAmount, expenseName, splitType, participants, splits);
    addExpense(expense);
    group.addExpense(expense);

    return expense;
  } 

  public double getUserBalanceForGroup(String userId, String groupId) {
    User user = users.get(userId);
    ExpenseGroup group = expenseGroups.get(groupId);

    return group.getBalanceForGroupMember(user);
  }

  public ExpenseGroup getExpenseGroupById(String groupId) {
    return expenseGroups.get(groupId);
  }
}
