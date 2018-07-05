/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pl.ssoch.dietcomposer.data.Dish;
import pl.ssoch.dietcomposer.data.DishItems;

/**
 *
 * @author ssoch
 */
class DishPicker {
    private double factor = 0.1;
    
    public void setFactor(double factor) {
        this.factor = factor;
    }
    
    public Map<Condition, List<Dish>> pickDishes(List<Dish> dishList, double calPerMeal) {
        Map<Condition, List<Dish>> dishes = new HashMap<>();

        List<Dish> pickedDishesList = new ArrayList<>();
        List<Dish> otherDishesList = new ArrayList<>();

        for (Dish d : dishList) {
            double calories = 0;

            for (DishItems di : d.getDishItems()) {
                calories += di.getDishComponentCalories();
            }

            if (checkDish(calories, calPerMeal)) {
                pickedDishesList.add(d);
            } else {
                otherDishesList.add(d);
            }
        }

        dishes.put(Condition.MET_CONDITIONS, pickedDishesList);
        dishes.put(Condition.NOT_MET_CONDITIONS, otherDishesList);

        return dishes;
    }

    private boolean checkDish(double calories, double calPerMeal) {
        double factorTmp = factor;
        factorTmp *= calPerMeal;
        if ((calories < (calPerMeal - factorTmp)) || (calories > (calPerMeal + factorTmp))) {
            return false;
        }
        
        return true;
    }
}

enum Condition {
    MET_CONDITIONS,
    NOT_MET_CONDITIONS
}