/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.view;

import java.util.ArrayList;
import java.util.List;
import pl.ssoch.dietcomposer.data.DishType;
import pl.ssoch.dietcomposer.servlet.DishTapeInfo;

/**
 *
 * @author ssoch
 */
public class HomeViewHelper {

    public List<DishTapeInfo> getMeals() {
        List<DishTapeInfo> meals = new ArrayList<>();
        meals.add(new DishTapeInfo(DishType.BREAKFAST, "Sniadanie"));
        meals.add(new DishTapeInfo(DishType.SECOND_BREAKFAST, "Drugie Sniadanie"));
        meals.add(new DishTapeInfo(DishType.SOUP, "Zupa"));
        meals.add(new DishTapeInfo(DishType.MAIN_COURSE, "Drugie danie"));
        meals.add(new DishTapeInfo(DishType.TEA, "Podwieczorek"));
        meals.add(new DishTapeInfo(DishType.SUPPER, "Kolacja"));
        
        return meals;
    }
}
