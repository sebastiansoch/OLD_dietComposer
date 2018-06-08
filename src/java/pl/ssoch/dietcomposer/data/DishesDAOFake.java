/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.data;

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
        dishes.add(new Dish(1, "Śniadanie polskie ver.1", (ArrayList<DishComponent>) FactoryDAO.getDishComponentsDAO().getDishComponentsList()));
        dishes.add(new Dish(2, "Obiad polski ver.1", null));
        dishes.add(new Dish(3, "Kolacja vege ver.1", null));
        
        return dishes;
    }
}
