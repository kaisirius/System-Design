#ifndef ORDER_MANAGER_H
#define ORDER_MANAGER_H

#include "../models/Order.h"

class OrderManager {
  private:
    static OrderManager* instance;
    vector<Order*> orders;
    OrderManager() = default;
    OrderManager(OrderManager&) = delete;
  
  public:
    static OrderManager* getInstance() {
      if(!instance) {
        instance = new OrderManager();
      }
      return instance;
    }

    void addOrder(Order* order) {
      orders.push_back(order);
    }

    void listOrders() {
      cout << "\n--- All Orders ---" << endl;
      for (auto order : orders) {
          cout << order->getType() << " order for " << order->getUser()->getName()
                  << " | Total: $" << order->getTotal()
                  << " | At: " << order->getScheduled() << endl;
      }
    }
};

OrderManager* OrderManager::instance = nullptr;

#endif