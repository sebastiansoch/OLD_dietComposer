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
    private Map<DishType, List<Dish>> dishesPerType = new HashMap<>();
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
            dishesPerType.put(dt, getDishesForType(dt, percentForType.get(dt) * calories));
        }
        
        menu.setDishes(dishesPerType);
        return menu;
    }

    private List<Dish> getDishesForType(DishType dishType, double calPerMeal) {
        List<Dish> dishList = dishes.getAllDishesForType(dishType);
        DishPicker dishPicker = new DishPicker();
        List<Dish> pickedDishes = dishPicker.pickDishes(dishList, calPerMeal);

        return pickedDishes;
    }

}
