package LLD.Problems.ATMSystem.models;

import java.util.Map;
import java.util.TreeMap;

import LLD.Problems.ATMSystem.enums.Denomination;

public class CashDispenser {
  private Map<Denomination, Integer> funds;

  public CashDispenser() {
    funds = new TreeMap<>();
    for(Denomination denomination: Denomination.values()) {
      funds.put(denomination, 0);
    }
  }

  public void addCash(int amount) {
    System.out.println("----Adding money to funds----");
  }

  public void dispenseCash(int amount) {
    System.out.println("----Dispensing cash----");
  }
}
