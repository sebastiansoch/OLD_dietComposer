/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.services;

import java.util.ArrayList;
import java.util.List;
import pl.ssoch.dietcomposer.data.Dish;
import pl.ssoch.dietcomposer.dao.DishesDAO;

/**
 *
 * @author Seba
 */
public class DishManager {

    private DishesDAO dishes;

    public DishManager(DishesDAO dishes) {
        this.dishes = dishes;
    }

    public List<String> getAllDishes() {
        ArrayList<String> dishesList = new ArrayList<>();
//        for (Dish d : dishes.getAllDishes()) {
//            dishesList.add(d.getDishName());
//        }
        return dishesList;
    }

    public String getDish(int id) {
        //Zwraca konkretne danie
        return null;
    }

    public List<String> findDish(String phrase) {
        //Zwraca dania zawierajace dana fraze
        return null;
    }

    public List<Dish> getAllDishesForMeal(String meal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
