/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.services;

import java.util.ArrayList;
import java.util.List;
import pl.ssoch.dietcomposer.data.Dish;
import pl.ssoch.dietcomposer.data.DishComponent;
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
    
    public List<Dish> pickDishes(List<Dish> dishList, double calPerMeal) {
        List<Dish> pickedDishes = new ArrayList<>();

        for (Dish d : dishList) {
            double calories = 0;

            for (DishItems di : d.getDishItems()) {
                calories += di.getDishComponentCalories();
            }

            if (checkDish(calories, calPerMeal)) {
                pickedDishes.add(d);
            }
        }

        return pickedDishes;
    }

    //TODO -- sprawdzic implementacje (baza danych ma za duzo kalorii)
    private boolean checkDish(double calories, double calPerMeal) {
//        double factorTmp = factor;
//        factorTmp *= calPerMeal;
//        if ((calories < (calPerMeal - factorTmp)) || (calories > (calPerMeal + factorTmp))) {
//            return false;
//        }
//        
        return true;
    }

}
