#ifndef RESTAURANT_H
#define RESTAURANT_H

#include <string>
#include <vector>
#include "MenuItem.h"
using namespace std;

class Restaurant {
  private:
    int restaurantId;
    string name;
    string location;
    vector<MenuItem*> menu;
    inline static int autoId = 1;
  
  public:
    Restaurant(const string& name, const string& location): name(name), location(location) {
      restaurantId = autoId++;
    }

    void addMenuItem(MenuItem* newItem) {
      menu.push_back(newItem);
    }
    // Can add deleteMenuItem method
    
    //GETTERS & SETTERS
    string getName() const {
      return name;
    }
    string getLocation() const {
      return location;
    }
    vector<MenuItem*> getMenu() const {
      return menu;
    }
    void setName(const string& name) {
      this->name = name;
    }
    void setLocation(const string& location) {
      this->location = location;      
    }

};


#endif