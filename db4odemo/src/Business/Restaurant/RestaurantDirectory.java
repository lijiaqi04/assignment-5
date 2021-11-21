/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harold
 */
public class RestaurantDirectory {
    ArrayList<Restaurant> restaurantList;

    public RestaurantDirectory() {
        restaurantList = new ArrayList<>();
    }
    public Restaurant createRestaurant(String name){
        Restaurant restaurant = new Restaurant();
        restaurant.setName(name);
        restaurantList.add(restaurant);
        return restaurant;
    }

    public ArrayList<Restaurant> getRestaurantArrayList() {
        return restaurantList;
    }
}
