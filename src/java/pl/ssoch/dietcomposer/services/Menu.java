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
    private Map<DishType, List<Dish>> metConditionsDishes;
    private Map<DishType, List<Dish>> notMetConditionsDishes;
    
    public void setMetConditionsDishes(Map<DishType, List<Dish>> dishesPerType) {
        this.metConditionsDishes.putAll(dishesPerType);
    }

    public void setNotMetConditionsDishes(Map<DishType, List<Dish>> dishesPerType) {
        this.notMetConditionsDishes.putAll(dishesPerType);
    }
    
    public List<Dish> getMetConditionDishes(DishType dishType) {
        return metConditionsDishes.get(dishType);
    }
    
    public List<Dish> getNotMetConditionDishes(DishType dishType) {
        return notMetConditionsDishes.get(dishType);
    }
}
