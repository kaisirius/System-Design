package LLD.Problems.ATMSystem.state;

import LLD.Problems.ATMSystem.models.ATMCard;
import LLD.Problems.ATMSystem.models.ATMSystem;
import LLD.Problems.ATMSystem.models.BankService;

public class AuthenticateUserState implements IMachineState {
  @Override
  public void insertCard(ATMSystem system, ATMCard card) {
    System.out.println("Card already inserted");
  }

  @Override
  public void authenticate(ATMSystem system) {
    BankService bankService = system.getInsertedCard().getBankService();
    boolean auth = bankService.authenticate(system.getInsertedCard().getCardNo());
    if(!auth) {
      System.out.println("Not a valid card. Try inserting other card or same card again.");
    } else {
      system.setStatus(new PerformOperationState());
    } 
  }

  @Override
  public void enterPin(ATMSystem system, String pin) {
    System.out.println("Authenticating card.");
  }

  @Override
  public void withdrawOperation(ATMSystem system, int debitAmount) {
    System.out.println("Authenticating card.");  
}

  @Override
  public void depositOperation(ATMSystem system, int creditAmount) {
    System.out.println("Authenticating card.");
  }

  @Override
  public void getBalance(ATMSystem system) {
    System.out.println("Authenticating card.");
  }
}
