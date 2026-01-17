#ifndef RESTAURANT_MANAGER_H
#define RESTAURANT_MANAGER_H

#include <vector>
#include "../models/Restaurant.h"

class RestaurantManager {
  private:
    vector<Restaurant*> listOfRestaurants;
    static RestaurantManager* instance;
    RestaurantManager() = default;
    RestaurantManager(RestaurantManager&) = delete;

  public:
    static RestaurantManager* getInstance() {
      if(!instance) {
        instance = new RestaurantManager();
      }
      return instance;
    }

    void addRestaurant(Restaurant* newRestaurant) {
      listOfRestaurants.push_back(newRestaurant);
    }

    vector<Restaurant*> searchByLocation(const string& loc) {
      vector<Restaurant*> result;
      for(auto restaurant: listOfRestaurants) {
        if(restaurant->getLocation() == loc) {
          result.push_back(restaurant);
        }
      }
      return result;
    }
};

RestaurantManager* RestaurantManager::instance = nullptr;

#endif