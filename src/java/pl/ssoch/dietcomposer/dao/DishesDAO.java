/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.dao;

import java.util.List;
import pl.ssoch.dietcomposer.data.Dish;
import pl.ssoch.dietcomposer.data.DishType;

/**
 *
 * @author Seba
 */
public interface DishesDAO {
    List<Dish> getAllDishesForType(DishType dishType);
    List<String> getDishTypes();
    Dish getDishDetails(int id);
}
