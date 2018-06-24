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
import pl.ssoch.dietcomposer.data.DishesDAO;
import pl.ssoch.dietcomposer.data.DishesDAOFake;
import pl.ssoch.dietcomposer.data.FactoryDAO;

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

        for (DishType dt : percentForType.keySet()) {
           dishesForMeal.putAll(getDishesForType(dt, percentForType.get(dt) * calories));
        }

        for (Condition con : dishesForMeal.keySet()) {
            if (con.equals(Condition.MET_CONDITIONS)) {
                menu.setMetConditionsDishes(dishesForMeal.get(con));    
            } else {
                menu.setNotMetConditionsDishes(dishesForMeal.get(con));    
            }
        }
        return menu;
    }

    private Map<Condition, Map<DishType, List<Dish>>> getDishesForType(DishType dishType, double calPerMeal) {
        Map<Condition, Map<DishType, List<Dish>>> dishesMAp =  new HashMap<>();
        List<Dish> dishList = dishes.getAllDishesForType(dishType);
        DishPicker dishPicker = new DishPicker();
        Map<Condition, List<Dish>> dishesMap = dishPicker.pickDishes(dishList, calPerMeal);
        
        for (Condition key : dishesMap.keySet()) {
            Map<DishType, List<Dish>> dishesPerType = new HashMap<>();
            dishesPerType.put(dishType, dishesMap.get(key));
            dishesMAp.put(key, dishesPerType);
        }

        return dishesMAp;
    }

}
