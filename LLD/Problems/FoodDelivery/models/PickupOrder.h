#ifndef PICKUPORDER_H
#define PICKUPORDER_H

#include "Order.h"

class PickUpOrder: public Order {
  private:
    string restaurantAddress;
  public:
    PickUpOrder() {
      restaurantAddress = "";
    }

    string getType() const override {
      return "PickUp";
    }
    // GETTERS & SETTERS
    void setRestaurantAddress(const string& addr) {
        restaurantAddress = addr;
    }

    string getRestaurantAddress() const {
        return restaurantAddress;
    }
};

#endif