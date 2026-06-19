package LLD.Problems.LinkedInSystem.services;

import java.util.ArrayList;
import java.util.List;

import LLD.Problems.LinkedInSystem.models.Account;

public class SearchService {
  private List<Account> allAccounts;

  public SearchService() {
    allAccounts = new ArrayList<>();
  }

  public void addAccount(Account account) {
    allAccounts.add(account);
  }

  public List<Account> searchAccountByName(String name) {
    List<Account> searchedAccounts = new ArrayList<>();
    for(Account account: allAccounts) {
      if(account.getName() == name) searchedAccounts.add(account);
    }
    return searchedAccounts;
  }
}
