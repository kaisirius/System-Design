#ifndef MENUITEM_H
#define MENUITEM_H

#include <string>

using namespace std;

class MenuItem {
  private:
    string code;
    string name;
    int price;
  public:
    MenuItem(const string& code, const string& name, const int& price): code(code), name(name), price(price) {}

    // GETTERS & SETTERS
    string getCode() const {
      return code;
    }
    string getName() const {
      return name;
    }
    int getPrice() const {
      return price;
    }
    void setCode(const string& code) {
      this->code = code;
    }
    void setName(const string& name) {
      this->name = name;
    }
    void setPrice(const int& price) {
      this->price = price;
    }
};

#endif