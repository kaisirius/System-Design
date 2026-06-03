package LLD.Problems.VendingMachine.state;

import java.util.List;

import javax.naming.InsufficientResourcesException;

import LLD.Problems.VendingMachine.models.Item;
import LLD.Problems.VendingMachine.models.VendingMachine;
import LLD.Problems.VendingMachine.state.interfaces.IMachineState;

public class DispensingItemState implements IMachineState { 
  @Override
  public void selectItem(VendingMachine machine, String code) {
    System.out.println("Can't select item. Dispensing current Item!");
  }

  @Override
  public void insertMoneyInMachine(VendingMachine machine, int value, String typeOfMoney) {
    System.out.println("Can't insert money. Dispensing current Item!");
  }

  @Override
  public void dispenseItem(VendingMachine machine) {
    
    if(machine.getBalanceInserted() > machine.getSelectedItem().getPrice()) {
      try {
        List<Integer> exchange = machine.getFundManager().giveExchange(machine.getBalanceInserted() - machine.getSelectedItem().getPrice());
        System.out.println(exchange);
      } catch(InsufficientResourcesException e) {
        System.out.println(e);
      }
    }
    
    // System.out.println(machine.getSelectedItemCode());
    Item itemToRemove = machine.getSelectedItem();
    machine.getInventoryManager().reduceSkuQuantity(itemToRemove.getSKU());
    machine.getInventoryManager().removeItem(itemToRemove.getCode());
    
    System.out.println("Dispensing item -> " + itemToRemove.getSKU());
    machine.reset();
  }
} 
