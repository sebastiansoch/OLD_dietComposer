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
import pl.ssoch.dietcomposer.data.DishItems;
import pl.ssoch.dietcomposer.data.DishType;
import pl.ssoch.dietcomposer.services.Menu;
import pl.ssoch.dietcomposer.services.MenuGenerator;

/**
 *
 * @author Seba
 */
public class MealComposerViewHelper {

    //DishType, List<DishName>
    private Map<String, List<String>> dishesMetConditions;
    private Map<String, List<String>> dishesNotMetConditions;

    //DishName, List<DishComponents>
    private Map<String, List<DishComponentViewHelper>> dishesComponents;

    public MealComposerViewHelper(List<DishType> dishTypeList, int calories) {
        dishesMetConditions = new HashMap<>();
        dishesNotMetConditions = new HashMap<>();
        dishesComponents = new HashMap<>();
        prepareView(dishTypeList, calories);
    }

    public Map<String, List<String>> getMetConditionsDishesInfo() {
        return dishesMetConditions;
    }

    public Map<String, List<String>> getNotMetConditionsDishesInfo() {
        return dishesNotMetConditions;
    }

    public Map<String, List<DishComponentViewHelper>> getDishesComponents() {
        return dishesComponents;
    }

    private void prepareView(List<DishType> dishTypeList, int calories) {
        MenuGenerator menuGen = FactoryDAOAbs.getFactoryDAO().getMenuGenerator();
        Menu menu = menuGen.createMenu(calories);

        for (DishType dishType : dishTypeList) {

            List<String> dishesMet = new ArrayList<>();
            for (Dish dish : menu.getMetConditionDishes(dishType)) {
                dishesMet.add(dish.getDishName());

                getDishComponents(dish);
            }
            dishesMetConditions.put(convertDishTypeToString(dishType), dishesMet);

            List<String> dishesNotMet = new ArrayList<>();
            for (Dish dish : menu.getNotMetConditionDishes(dishType)) {
                dishesNotMet.add(dish.getDishName());

                getDishComponents(dish);
            }
            dishesNotMetConditions.put(convertDishTypeToString(dishType), dishesNotMet);
        }
    }

    private void getDishComponents(Dish dish) {
        List<DishComponentViewHelper> dishComponents = new ArrayList<>();
        for (DishItems dishItem : dish.getDishItems()) {
            dishComponents.add(new DishComponentViewHelper(dishItem));
        }
        dishesComponents.put(dish.getDishName(), dishComponents);
    }

    private String convertDishTypeToString(DishType dishType) {
        switch (dishType) {
            case BREAKFAST:
                return "Śniadanie";
            case SECOND_BREAKFAST:
                return "Drugie śniadanie";
            case SOUP:
                return "Zupa";
            case MAIN_COURSE:
                return "Danie główne";
            case TEA:
                return "Podwieczorek";
            case SUPPER:
                return "Obiad";
            default:
                return "Nie znany posiłek";
        }
    }

}
