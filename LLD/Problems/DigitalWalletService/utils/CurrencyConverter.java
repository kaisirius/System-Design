package LLD.Problems.DigitalWalletService.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import LLD.Problems.DigitalWalletService.enums.Currency;

public class CurrencyConverter {
  private static final Map<Currency, BigDecimal> exchangeRates = new HashMap<>();

    static {
        // Initialize exchange rates
        exchangeRates.put(Currency.USD, BigDecimal.ONE);
        exchangeRates.put(Currency.INR, new BigDecimal("95.35"));
        exchangeRates.put(Currency.YEN, new BigDecimal("158.98"));
        // Add more exchange rates as needed
    }

    public static BigDecimal convert(BigDecimal amount, Currency sourceCurrency, Currency targetCurrency) {
        BigDecimal sourceRate = exchangeRates.get(sourceCurrency);
        BigDecimal targetRate = exchangeRates.get(targetCurrency);
        return amount.multiply(targetRate).divide(sourceRate, RoundingMode.HALF_UP);
    }
}
