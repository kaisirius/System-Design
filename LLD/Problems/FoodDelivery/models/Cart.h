#ifndef CART_H
#define CART_H

#include <iostream>
#include <vector>
#include <stdexcept>
#include "Restaurant.h"
#include "MenuItem.h"
using namespace std;

class Cart {
  private:
    Restaurant* restaurant ;
    vector<MenuItem*> items;

  public:
    Cart() {
      restaurant = nullptr;
    }

    void addItem(MenuItem* newItem) {
      if(restaurant == nullptr) {
        cerr << "NOTE: Restaurant must be selected before adding items to cart" << endl;
        return;
      }
      items.push_back(newItem);
    }

    int getTotalCost() {
      int cost = 0;
      for(int i = 0; i < (int)items.size(); i++) {
        cost += items[i]->getPrice();
      }
      return cost;
    }

    void clear() {
      cout << "Cart is now empty!" << endl;
      items.clear();
    }

    bool isEmpty() {
      if((int)items.size()) return false;
      return true;
    }

    // GETTERS & SETTERS
    Restaurant* getRestaurant() const {
      return restaurant;
    }
    void setRestaurant(Restaurant* restaurant) {
      this->restaurant = restaurant;
    }
    vector<MenuItem*> getItems() const {
      return items;
    }

  ~Cart() {
    for(auto item: items) {
      delete item;
    }
    items.clear();
    delete restaurant;
  }
};

#endif