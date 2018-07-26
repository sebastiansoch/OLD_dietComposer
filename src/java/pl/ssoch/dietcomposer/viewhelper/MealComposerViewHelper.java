/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.viewhelper;

import java.util.ArrayList;
import java.util.HashMap;
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

    private Map<String, List<DishViewHelper>> dishesMetConditions;
    private Map<String, List<DishViewHelper>> dishesNotMetConditions;

    public MealComposerViewHelper(List<DishType> dishTypeList, int calories) {
        dishesMetConditions = new HashMap<>();
        dishesNotMetConditions = new HashMap<>();
        prepareView(dishTypeList, calories);
    }

    private void prepareView(List<DishType> dishTypeList, int calories) {
        MenuGenerator menuGen = FactoryDAOAbs.getFactoryDAO().getMenuGenerator();
        Menu menu = menuGen.createMenu(calories);

        for (DishType dishType : dishTypeList) {
            List<DishViewHelper> dvhMet = new ArrayList<>();
            
            for (Dish dish : menu.getMetConditionDishes(dishType)) {
                dvhMet.add(new DishViewHelper(dish));
            }
            dishesMetConditions.put(dishType.toString(), dvhMet);

            List<DishViewHelper> dvhNotMet = new ArrayList<>();
            for (Dish dish : menu.getNotMetConditionDishes(dishType)) {
                dvhNotMet.add(new DishViewHelper(dish));
            }
            dishesNotMetConditions.put(dishType.toString(), dvhNotMet);
        }
    }

    public Map<String, List<DishViewHelper>> getMetConditionsDishesInfo() {
        return dishesMetConditions;
    }

    public Map<String, List<DishViewHelper>> getNotMetConditionsDishesInfo() {
        return dishesNotMetConditions;
    }

}
