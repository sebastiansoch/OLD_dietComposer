/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.viewhelper;

import java.util.ArrayList;
import java.util.List;
import pl.ssoch.dietcomposer.data.Dish;
import pl.ssoch.dietcomposer.data.DishType;
import pl.ssoch.dietcomposer.data.FactoryDAOFake;
import pl.ssoch.dietcomposer.services.Menu;
import pl.ssoch.dietcomposer.services.MenuGenerator;

/**
 *
 * @author Seba
 */
public class MenuComposerViewHelper {

    private List<DishViewHelper> dishesMetConditions;
    private List<DishViewHelper> dishesNotMetConditions;

    public MenuComposerViewHelper(DishType dishType, int calories) {
        dishesMetConditions = new ArrayList<>();
        dishesNotMetConditions = new ArrayList<>();
        prepareView(dishType, calories);
    }

    private void prepareView(DishType dishType, int calories) {
        MenuGenerator menuGen = FactoryDAOFake.getMenuGenerator();
        Menu menu = menuGen.createMenu(calories);

        for (Dish dish : menu.getMetConditionDishes(dishType)) {
            DishViewHelper dvi = new DishViewHelper(dish);
            dishesMetConditions.add(dvi);
        }

        for (Dish dish : menu.getNotMetConditionDishes(dishType)) {
            DishViewHelper dvi = new DishViewHelper(dish);
            dishesNotMetConditions.add(dvi);
        }
    }

    public List<DishViewHelper> getMetConditionsDishesInfo() {
        return dishesMetConditions;
    }

    public List<DishViewHelper> getNotMetConditionsDishesInfo() {
        return dishesNotMetConditions;
    }

}
