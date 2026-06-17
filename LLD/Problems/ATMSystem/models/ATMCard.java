package LLD.Problems.ATMSystem.models;

public class ATMCard {
  private String cardNo;
  private String pin;
  private BankService bankService;

  public ATMCard(String no, String pass, BankService service) {
    cardNo = no;
    pin = pass;
    bankService = service;
  }

  public String getCardNo() {
    return cardNo;
  }

  public String getPin() {
    return pin;
  }

  public BankService getBankService() {
    return bankService;
  }

  public void setPin(String newPin) {
    pin = newPin;
  }
}
