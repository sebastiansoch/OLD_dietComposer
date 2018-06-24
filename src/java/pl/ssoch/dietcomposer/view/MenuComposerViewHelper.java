/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.view;

import java.util.List;
import pl.ssoch.dietcomposer.data.DishType;
import pl.ssoch.dietcomposer.data.FactoryDAO;
import pl.ssoch.dietcomposer.services.Menu;
import pl.ssoch.dietcomposer.services.MenuGenerator;

/**
 *
 * @author Seba
 */
public class MenuComposerViewHelper {

    private DishViewInfo dishesMetConditions;
    private DishViewInfo dishesNotMetConditions;

    public MenuComposerViewHelper(DishType dishType, int calories) {
        prepareView(dishType, calories);
    }

    private void prepareView(DishType dishType, int calories) {
        MenuGenerator menuGen = FactoryDAO.getMenuGenerator();
        Menu menu = menuGen.createMenu(calories);
        menu.getMetConditionDishes(dishType);
        menu.getNotMetConditionDishes(dishType);
    }

    public List<String> getMetConditionsDishesInfo() {
        return dishesMetConditions.getDishesView();
    }

    public List<String> getNotMetConditionsDishesInfo() {
        return dishesNotMetConditions.getDishesView();
    }

}
