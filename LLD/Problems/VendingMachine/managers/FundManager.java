package LLD.Problems.VendingMachine.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InsufficientResourcesException;

public class FundManager {
  private Map<Integer, Integer> coins; // value, quantity
  private Map<Integer, Integer> notes;
  public List<Integer> denominations;


  public FundManager() {
    coins = new HashMap<>();
    notes = new HashMap<>();

    coins.put(1, 10);
    coins.put(2, 10);
    coins.put(5, 10);

    notes.put(10, 10);
    notes.put(20, 10);
    notes.put(50, 10);

    denominations = List.of(1, 2, 5, 10, 20, 50, 100, 200);
  }

  public void addCoin(int denomination) {
    if(coins.containsKey(denomination)) {
      int currentQuantity = coins.get(denomination);
      coins.put(denomination, currentQuantity + 1);
    } else {
      coins.put(denomination, 1);
    }
  }

  public void addNote(int denomination) {
    if(notes.containsKey(denomination)) {
      int currentQuantity = notes.get(denomination);
      notes.put(denomination, currentQuantity + 1);
    } else {
      notes.put(denomination, 1);
    }
  }

  public void reduceCoin(int denomination) {
    if(coins.containsKey(denomination)) {
      int currentQuantity = coins.get(denomination);
      coins.put(denomination, Math.max(currentQuantity - 1, 0));
    } else {
      coins.put(denomination, 0);
    }
  }

  public void reduceNote(int denomination) {
    if(notes.containsKey(denomination)) {
      int currentQuantity = notes.get(denomination);
      notes.put(denomination, Math.max(currentQuantity - 1, 0));
    } else {
      coins.put(denomination, 0);
    }
  }

  public List<Integer> giveExchange(double refund) throws InsufficientResourcesException {
    int numOfDenominations = denominations.size();
    List<Integer> exchange = new ArrayList<>();

    for(int i = numOfDenominations - 1; i >= 0; i--) {
      int denomination = denominations.get(i);
      while(refund >= denomination && coins.containsKey(denomination) && coins.get(denomination) > 0) {
        exchange.add(denomination);
        refund -= denomination;
        reduceCoin(denomination);
      }

      while(refund >= denomination && notes.containsKey(denomination) && notes.get(denomination) > 0) {
        exchange.add(denomination);
        refund -= denomination;
        reduceCoin(denomination);
      }
    }

    if(refund != 0) throw new InsufficientResourcesException();

    return exchange;
  }

}
