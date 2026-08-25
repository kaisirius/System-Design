package LLD.Problems.SocialMediaSystem.repositories;

import java.util.HashMap;
import java.util.Map;

import LLD.Problems.SocialMediaSystem.models.UserAccount;

public class UserRepository {
  private Map<String, UserAccount> accounts;
  private static UserRepository INSTANCE = new UserRepository();

  private UserRepository() {
    accounts = new HashMap<>();
  }

  public static UserRepository getInstance() {
    return INSTANCE;
  }

  public void addUser(UserAccount account) {
    accounts.put(account.getId(), account);
  }

  public UserAccount getAccById(String id) {
    return accounts.get(id);
  }
}
