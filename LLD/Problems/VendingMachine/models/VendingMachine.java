package LLD.Problems.VendingMachine.models;

import LLD.Problems.VendingMachine.managers.FundManager;
import LLD.Problems.VendingMachine.managers.InventoryManager;
import LLD.Problems.VendingMachine.state.SelectingItemState;
import LLD.Problems.VendingMachine.state.interfaces.IMachineState;

public class VendingMachine {
  private static VendingMachine instance;
  private InventoryManager inventoryManager;
  private FundManager fundManager;
  private IMachineState machineState;
  private String selectedItemCode;
  private int balanceInserted;

  private VendingMachine() {
    inventoryManager = new InventoryManager();
    fundManager = new FundManager();
    machineState = new SelectingItemState();
    selectedItemCode = null;
    balanceInserted = 0;
  }

  // methods for client interactions
  public void selectItem(String code) {
    machineState.selectItem(getInstance(), code);
  }

  public void insertCoin(int denomination) {
    machineState.insertMoneyInMachine(getInstance(), denomination, "coin");
  }

  public void insertNote(int denomination) {
    machineState.insertMoneyInMachine(getInstance(), denomination, "note");
  }

  public void dispenseItem() {
    machineState.dispenseItem(getInstance());
  }

  // Getter & setters
  public Item getSelectedItem() {
    try {
      return inventoryManager.getItem(selectedItemCode);
    } catch(IllegalArgumentException e) {
      System.out.println(e);
      return null;
    }
  }

  public String getSelectedItemCode() {
    return selectedItemCode;
  }

  public int getBalanceInserted() {
    return this.balanceInserted;
  }

  public static VendingMachine getInstance() {
    if(instance == null) {
      synchronized(VendingMachine.class) {
        if(instance == null) {
          instance = new VendingMachine();
        }
      }
    } 
    return instance;
  }

  public void setState(IMachineState newState) {
    this.machineState = newState;
  }

  public void setSelectedItemCode(String code) {
    this.selectedItemCode = code;
  }

  public InventoryManager getInventoryManager() {
    return inventoryManager;
  }

  public FundManager getFundManager() {
    return fundManager;
  }

  public void addBalance(int value) {
    balanceInserted += value;
  }

  public void addItemsInInventory(Item item) {
    inventoryManager.addItem(item);
    inventoryManager.addSkuQuantity(item.getSKU());
  }

  public void reset() {
    machineState = new SelectingItemState();
    selectedItemCode = null;
    balanceInserted = 0;
  }

}
