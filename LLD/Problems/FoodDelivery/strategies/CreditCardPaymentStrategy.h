#ifndef CREDIT_CARD_PAYMENT_STRATEGY_H
#define CREDIT_CARD_PAYMENT_STRATEGY_H

#include "PaymentStrategy.h"

class CreditCardPaymentStrategy: public PaymentStrategy {
  private:
    string creditCardNo;
  public:
    CreditCardPaymentStrategy(const string &cardNo) {
      creditCardNo = cardNo;
    }

    void pay(double amount) override {
      cout << "Paid $" << amount << " using credit card (" << creditCardNo << ")" << endl;
    }
};

#endif