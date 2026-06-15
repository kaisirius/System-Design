package LLD.Problems.CoffeeVendingMachine.managers;

import java.util.HashMap;
import java.util.Map;

public class FundManager {
  private Map<Integer, Integer> notes;

  public FundManager() {
    notes = new HashMap<>();
    notes.put(10, 0);
    notes.put(20, 0);
    notes.put(50, 0);
    notes.put(100, 0);
    notes.put(200, 0);
  }

  public void addMoney(int noteValue, int quantity) {
    int currentQuantity = notes.get(noteValue);
    notes.put(noteValue, currentQuantity + quantity);
  }

  public void reduceMoney(int noteValue, int quantity) {
    int currentQuantity = notes.get(noteValue);
    notes.put(noteValue, Math.max(currentQuantity - quantity, 0));
  }

  public void getChange(int change) {
    System.out.println("Returning change: " + change);
  }
}
