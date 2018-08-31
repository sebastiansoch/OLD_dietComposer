/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.viewhelper;

import java.util.ArrayList;
import java.util.List;
import pl.ssoch.dietcomposer.dao.FactoryDAOAbs;
import pl.ssoch.dietcomposer.data.Dish;
import pl.ssoch.dietcomposer.data.DishItems;
import pl.ssoch.dietcomposer.services.DishManager;

/**
 *
 * @author ssoch
 */
public class DishDetailsViewHelper {
    private String dishName = null;    
    private List<DishComponentViewHelper> dishesComponents;
    
    public DishDetailsViewHelper(int dishId) {
        dishesComponents = new ArrayList<>();
        prepareDishDetails(dishId);
    }

    public String getDishName() {
        return dishName;
    }

    public List<DishComponentViewHelper> getDishesComponents() {
        return dishesComponents;
    }

    private void prepareDishDetails(int dishId) {
        DishManager dishManager = FactoryDAOAbs.getFactoryDAO().getDishManager();
        Dish dish = dishManager.getDishById(dishId);
        dishName = dish.getDishName();
                
        for (DishItems di : dish.getDishItems()) {
            dishesComponents.add(new DishComponentViewHelper(di));
        }
    }
  
}
