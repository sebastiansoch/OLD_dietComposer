/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.services;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import pl.ssoch.dietcomposer.data.Dish;
import pl.ssoch.dietcomposer.data.DishType;
import pl.ssoch.dietcomposer.dao.DishesDAO;

/**
 *
 * @author ssoch
 */
public class MenuGeneratorImpl implements MenuGenerator {

    private final Map<DishType, Double> percentForType = new LinkedHashMap<>();
    private Map<Condition, Map<DishType, List<Dish>>> dishesForMeal = new HashMap<>();
    private DishesDAO dishes;

    public MenuGeneratorImpl(DishesDAO dishes) {
        this.dishes = dishes;

        percentForType.put(DishType.BREAKFAST, 0.15);
        percentForType.put(DishType.SECOND_BREAKFAST, 0.15);
        percentForType.put(DishType.SOUP, 0.2);
        percentForType.put(DishType.MAIN_COURSE, 0.3);
        percentForType.put(DishType.TEA, 0.1);
        percentForType.put(DishType.SUPPER, 0.1);
    }

    @Override
    public Menu createMenu(int calories) {
        Menu menu = new Menu();

        for (DishType dishType : percentForType.keySet()) {
            List<Dish> dishesList = dishes.getAllDishesForType(dishType);

            DishPicker dishPicker = new DishPicker();
            Map<Condition, List<Dish>> pickedDishes = dishPicker.pickDishes(dishesList, percentForType.get(dishType) * calories);
            
            Map<DishType, List<Dish>> tmp = new HashMap<>();
            tmp.put(dishType, pickedDishes.get(Condition.MET_CONDITIONS));
            menu.setMetConditionsDishes(tmp);
            tmp.clear();
            tmp.put(dishType, pickedDishes.get(Condition.NOT_MET_CONDITIONS));
            menu.setNotMetConditionsDishes(tmp);
        }
        return menu;
    }


}
