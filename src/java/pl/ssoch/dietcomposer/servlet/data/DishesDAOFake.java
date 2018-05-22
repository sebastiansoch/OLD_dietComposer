/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.servlet.data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Seba
 */
public class DishesDAOFake implements DishesDAO {
    
    @Override
    public List<Dish> getAllDishes() {
        ArrayList<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish(1, "Danie 1"));
        dishes.add(new Dish(2, "Danie 2"));
        dishes.add(new Dish(3, "Danie 3"));
        
        return dishes;
    }
}
