package LLD.Problems.VendingMachine.state.interfaces;

import LLD.Problems.VendingMachine.models.VendingMachine;

public interface IMachineState {
  public void selectItem(VendingMachine machine, String code);
  public void insertMoneyInMachine(VendingMachine machine, int value, String typeOfMoney); 
  public void dispenseItem(VendingMachine machine);
}
