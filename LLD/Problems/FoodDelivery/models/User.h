#ifndef USER_H
#define USER_H

#include <string>
#include "Cart.h"
using namespace std;

class User {
  private:
    int userId;
    string name;
    string address;
    Cart* cart; 
    inline static int autoId = 1;
  
  public:
    User(const string& name, const string& address) : name(name), address(address) {
      this->cart = new Cart();
      userId = autoId++;
    }

    //GETTERS & SETTERS
    string getName() const {
      return name;
    }
    string getAddress() const {
      return address;
    }
    Cart* getCart() const {
      return cart;
    }
    void setName(const string& name) {
      this->name = name;
    }
    void setAddress(const string& address) {
      this->address = address;      
    }

    ~User() {
      delete cart;
    }
};

#endif