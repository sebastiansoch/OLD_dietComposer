/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.viewhelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import pl.ssoch.dietcomposer.dao.FactoryDAOAbs;
import pl.ssoch.dietcomposer.data.Dish;
import pl.ssoch.dietcomposer.data.DishType;
import pl.ssoch.dietcomposer.services.Menu;
import pl.ssoch.dietcomposer.services.MenuGenerator;

/**
 *
 * @author Seba
 */
public class MealComposerViewHelper {

    //DishType, List<DishName>
    private List<DishViewHelper> dishesMetConditions;
    private List<DishViewHelper> dishesNotMetConditions;

    public MealComposerViewHelper(Map<DishType, Double> caloriesForType) {
        dishesMetConditions = new ArrayList<>();
        dishesNotMetConditions = new ArrayList<>();
        prepareView(caloriesForType);
    }

    public List<DishViewHelper> getMetConditionsDishesInfo() {
        return dishesMetConditions;
    }

    public List<DishViewHelper> getNotMetConditionsDishesInfo() {
        return dishesNotMetConditions;
    }

    private void prepareView(Map<DishType, Double> caloriesForTypes) {
        MenuGenerator menuGen = FactoryDAOAbs.getFactoryDAO().getMenuGenerator();
        Menu menu = menuGen.createMenu(caloriesForTypes);

        for (DishType dt : caloriesForTypes.keySet()) {

            for (Dish dish : menu.getMetConditionDishes(dt)) {
                dishesMetConditions.add(new DishViewHelper(dish.getDishId(), dish.getDishName(), dt));
            }

            for (Dish dish : menu.getNotMetConditionDishes(dt)) {
                dishesNotMetConditions.add(new DishViewHelper(dish.getDishId(), dish.getDishName(), dt));
            }
        }
    }
}
