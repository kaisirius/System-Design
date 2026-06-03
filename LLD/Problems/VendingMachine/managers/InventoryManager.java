package LLD.Problems.VendingMachine.managers;

import java.util.Map;

import LLD.Problems.VendingMachine.models.Item;

import java.util.HashMap;

public class InventoryManager {
  private Map<String, Item> itemsInStock; // code, item
  private Map<String, Integer> skuQuantity; // sku, integer

  public InventoryManager() {
    itemsInStock = new HashMap<>();
    skuQuantity = new HashMap<>();
  }

  public void addItem(Item item) {
    itemsInStock.put(item.getCode(), item);
  }

  public void removeItem(String code) {
    if(itemsInStock.containsKey(code)) {
      itemsInStock.remove(code);
    }
  }

  public void addSkuQuantity(String sku) {
    if(skuQuantity.containsKey(sku)) {
      int currentQuantity = skuQuantity.get(sku);
      skuQuantity.put(sku, currentQuantity + 1);
    } else {
      skuQuantity.put(sku, 1);
    }
  }

  public void reduceSkuQuantity(String sku) {
    if(skuQuantity.containsKey(sku)) {
      int currentQuantity = skuQuantity.get(sku);
      skuQuantity.put(sku, currentQuantity - 1);
    }
  }

  public boolean isAvailable(String sku) {
    return skuQuantity.containsKey(sku);
  }

  public Item getItem(String code) throws IllegalArgumentException {
    if(itemsInStock.containsKey(code))
    return itemsInStock.get(code);
    
    throw new IllegalArgumentException();
  }

  public int getQuantity(String sku) throws Exception {
    if(!skuQuantity.containsKey(sku)) throw new IllegalArgumentException();
    
    return skuQuantity.get(sku);
  }

}
