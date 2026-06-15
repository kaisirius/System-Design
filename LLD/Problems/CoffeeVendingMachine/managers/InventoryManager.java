package LLD.Problems.CoffeeVendingMachine.managers;

import java.util.HashMap;
import java.util.Map;

import LLD.Problems.CoffeeVendingMachine.enums.Ingredient;

public class InventoryManager {
  private Map<Ingredient, Integer> stock;
  private int threshold = 5;

  public InventoryManager() {
    stock = new HashMap<>();
    for(Ingredient ingredient: Ingredient.values()) {
      stock.put(ingredient, 0);
    }
  }

  public void addIngredient(Ingredient ingredient, int quantity) {
    int currentQuantity = stock.get(ingredient);
    stock.put(ingredient, currentQuantity + quantity);
  }

  public void reduceIngredient(Ingredient ingredient, int quantity) {
    int currentQuantity = stock.get(ingredient);
    stock.put(ingredient, Math.max(currentQuantity - quantity, 0));
  }

  public boolean checkInventoryStock() {
    for(Ingredient ingredient: Ingredient.values()) {
      int quantity = stock.get(ingredient);
      if(quantity < threshold) return false; // lame ahh logic as of now
    }
    return true;
  }
}
