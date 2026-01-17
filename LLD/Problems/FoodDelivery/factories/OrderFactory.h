#ifndef ORDER_FACTORY_H
#define ORDER_FACTORY_H

#include <vector>
#include <string>
#include "../models/User.h"
#include "../models/Restaurant.h"
#include "../models/Order.h"
#include "../strategies/PaymentStrategy.h"

using namespace std;

class OrderFactory {
  public:
    virtual Order* createOrder(User* user, Cart* cart, Restaurant* restaurant, const vector<MenuItem*> menuItems,
                              PaymentStrategy* paymentStrategy, const string& orderType) = 0;
    virtual ~OrderFactory() {}
};

#endif