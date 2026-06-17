import LLD.Problems.ATMSystem.models.ATMCard;
import LLD.Problems.ATMSystem.models.ATMSystem;
import LLD.Problems.ATMSystem.models.BankService;
import LLD.Problems.ATMSystem.models.HDFCBankService;

public class App {
    public static void main(String[] args) throws Exception {
        ATMSystem system = new ATMSystem();

        BankService hdfc = new HDFCBankService();
        
        hdfc.addAccount("123");
        hdfc.createATMCard("XXXX-XXXX-XXXX", "ABCD", "123");

        ATMCard card = new ATMCard("XXXX-XXXX-XXXX", "ABCD", hdfc);
        system.insertCard(card);
        system.authenticate();
        system.enterPin("ABCD");
        system.deposit(2000);
    }
}
