import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import LLD.Problems.DigitalWalletService.enums.Currency;
import LLD.Problems.DigitalWalletService.enums.TransactionType;
import LLD.Problems.DigitalWalletService.models.Account;
import LLD.Problems.DigitalWalletService.models.Transaction;
import LLD.Problems.DigitalWalletService.utils.CurrencyConverter;

public class DigitalWallet {
  // straight forward 
  public synchronized void transferFunds(Account sourceAccount, Account destinationAccount, BigDecimal amount, Currency currency) {
        if (sourceAccount.getCurrency() != currency) {
            amount = CurrencyConverter.convert(amount, currency, sourceAccount.getCurrency());
        }
        sourceAccount.withdraw(amount);

        if (destinationAccount.getCurrency() != sourceAccount.getCurrency()) {
            amount = CurrencyConverter.convert(amount, sourceAccount.getCurrency(), destinationAccount.getCurrency());
        }
        destinationAccount.deposit(amount);

        String transactionId = generateTransactionId();
        Transaction transaction_src = new Transaction(amount, sourceAccount, destinationAccount, TransactionType.DEBIT, sourceAccount.getCurrency());
        sourceAccount.addTransaction(transaction_src);
        Transaction transaction_dest = new Transaction(amount, sourceAccount, destinationAccount, TransactionType.CREDIT, destinationAccount.getCurrency());
        destinationAccount.addTransaction(transaction_dest);
    }

    public List<Transaction> getTransactionHistory(Account account) {
        return account.getTransactionHistory();
    }

    private String generateTransactionId() {
        return "TXN" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    // add funds for acc, amount and paymethod(for actual transaction)
}
