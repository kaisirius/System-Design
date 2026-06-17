package LLD.Problems.ATMSystem.state;

import LLD.Problems.ATMSystem.models.ATMCard;
import LLD.Problems.ATMSystem.models.ATMSystem;

public interface IMachineState {
  public void insertCard(ATMSystem system, ATMCard card);
  public void authenticate(ATMSystem system);
  public void enterPin(ATMSystem system, String pin);
  public void withdrawOperation(ATMSystem system, int debitAmount);
  public void depositOperation(ATMSystem system, int creditAmount);
  public void getBalance(ATMSystem system);
}
