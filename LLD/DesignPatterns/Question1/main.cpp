#include <iostream>
#include <memory>
#include <string>
#include <stdexcept>

// Factory & Strategy pattern 

class PaymentStrategy {
  public:
    virtual void pay(const double amount) = 0;
};

class DiscountStrategy {
  public:
    virtual double apply(double amount) = 0;
};


class CreditCardPayment: public PaymentStrategy {
  public:
    void pay(const double amount) override {
      std::cout << "Paying amount : " << amount << " " << "via credit card." << std::endl;
    }
};

class UpiPayment: public PaymentStrategy {
  public:
    void pay(const double amount) override {
      std::cout << "Paying amount : " << amount << " " << "via UPI." << std::endl;
    }
};

class WalletPayment: public PaymentStrategy {
  public:
    void pay(const double amount) override {
      std::cout << "Paying amount : " << amount << " " << "from wallet." << std::endl;
    }
};

class CouponDiscount: public DiscountStrategy {
  public:
    double apply(double amount) override {
      // logic of discount
      return amount;
    }
};

class FestivalDiscount: public DiscountStrategy {
  public:
    double apply(double amount) override {
      // logic of discount
      return amount;
    }
};

class LoyaltyDiscount: public DiscountStrategy {
  public:
    double apply(double amount) override {
      // logic of discount
      return amount;
    }
};


class PaymentFactory {
  public:
    static std::unique_ptr<PaymentStrategy> createPayment(const std::string type) {
      if(type == "Credit Card") {
        return std::make_unique<CreditCardPayment>();
      } else if(type == "UPI") {
        return std::make_unique<UpiPayment>();
      } else if(type == "Wallet") {
        return std::make_unique<WalletPayment>();
      } 
      throw std::invalid_argument("Unknown type of payment : " + type);
    }
};

class DiscountFactory {
  public:
    static std::unique_ptr<DiscountStrategy> createDiscount(const std::string type) {
      if(type == "Coupon") {
        return std::make_unique<CouponDiscount>();
      } else if(type == "Festival") {
        return std::make_unique<FestivalDiscount>();
      } else if(type == "Loyalty") {
        return std::make_unique<LoyaltyDiscount>();
      } 
      throw std::invalid_argument("Unknown type of payment : " + type);
    }
};

class checkoutService {
  private:
    std::unique_ptr<PaymentStrategy> payment;
    std::unique_ptr<DiscountStrategy> discount;
  public:
    void setPaymentStrategy(std::unique_ptr<PaymentStrategy> &payment) {
      this->payment = std::move(payment);
    }
    void setDiscountStrategy(std::unique_ptr<DiscountStrategy> &discount) {
      this->discount = std::move(discount);
    }
    void checkout(double amount) {
      // should check and throw error if discount strategy not set
      double CheckoutAmount = discount->apply(amount);
      payment->pay(CheckoutAmount);
      std::cout << "Payment Successfull.\n" << "Checkout complete" << std::endl;
    }
};

int main() {
  checkoutService checkoutSVC;
  std::unique_ptr<PaymentStrategy> payStrategy = PaymentFactory::createPayment("UPI");
  std::unique_ptr<DiscountStrategy> discountStrategy = DiscountFactory::createDiscount("Coupon");
  checkoutSVC.setPaymentStrategy(payStrategy);
  checkoutSVC.setDiscountStrategy(discountStrategy);
  checkoutSVC.checkout(1999.99);
  return 0;
}