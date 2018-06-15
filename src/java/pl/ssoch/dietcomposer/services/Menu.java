/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import pl.ssoch.dietcomposer.data.Dish;
import pl.ssoch.dietcomposer.data.DishType;

/**
 *
 * @author ssoch
 */
public class Menu {
    private Map<DishType, List<Dish>> dishesPerType;
    
    void setDishes(Map<DishType, List<Dish>> dishesPerType) {
        this.dishesPerType = dishesPerType;
    }

    public List<Dish> getDishesForType(DishType dishType) {
        return dishesPerType.get(dishType);
    }
    
}
