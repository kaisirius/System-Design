#ifndef ORDER_H
#define ORDER_H

#include <iostream>
#include <string>
#include <vector>
#include "User.h"
#include "Restaurant.h"
#include "MenuItem.h"
#include "../strategies/PaymentStrategy.h"

using namespace std;

class Order {
  private:
    int orderId;
    int total;
    inline static int autoId = 1;
    User* user;
    Restaurant* restaurant;
    vector<MenuItem*> items;
    PaymentStrategy* strategy;
    string scheduled;

  public:
    Order() {
      orderId = autoId++;
      total = 0;
      user = nullptr;
      restaurant = nullptr;
      strategy = nullptr;
      scheduled = "";
    }

    virtual string getType() const = 0; 

    bool processPayment() {
      if(strategy) {
        strategy->pay(total);
        return true;
      } else {
        cout << "Please choose a payment mode to complete the transaction." << endl;
        return false;
      }
    }

    // GETTERS & SETTERS
    int getOrderId() const {
      return orderId;
    }
    int getTotal() const {
      return total;
    }
    User* getUser() const {
      return user;
    }
    Restaurant* getRestaurant() const {
      return restaurant;
    }
    vector<MenuItem*> getItems() const {
      return items;
    }
    PaymentStrategy* getPaymentStrategy() const {
      return strategy;
    }
    string getScheduled() const {
      return scheduled;
    }
    void setUser(User* u) {
      user = u;
    }
    void setRestaurant(Restaurant* r) {
      restaurant = r;
    }
    void setItems(const vector<MenuItem*> items) {
      this->items = items;
      total = 0;
      for (auto &i : items) {
          total += i->getPrice();
      }
    }
    void setPaymentStrategy(PaymentStrategy* newStrategy) {
      strategy = newStrategy;
    }
    void setScheduled(const string& newSchedule) {
      scheduled = newSchedule;
    }

    ~Order() {
      delete user;
      delete restaurant;
      delete strategy;
      for(auto item: items) {
        delete item;
      }
      items.clear();
    }
};


#endif