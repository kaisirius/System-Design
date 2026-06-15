package LLD.Problems.CoffeeVendingMachine.abstracts;

import java.util.Map;

import LLD.Problems.CoffeeVendingMachine.enums.Ingredient;

public abstract class Coffee {
  protected String description = "Plain Coffee";

  public void prepare() {
    grindBeans();
    brew();
    addCondiments();
    addToCup();
  }

  public void grindBeans() {
    System.out.println("Grinding coffee beans.");
  }

  public void brew() {
    System.out.println("Brewing fresh coffee beans.");
  }

  public void addToCup() {
    System.out.println("Pouring coffee in cup.");
  }

  public abstract void addCondiments();
  public abstract int getPrice();
  public abstract Map<Ingredient, Integer> getRecipe();
  public String getDescription() {
    return description;
  }
}
