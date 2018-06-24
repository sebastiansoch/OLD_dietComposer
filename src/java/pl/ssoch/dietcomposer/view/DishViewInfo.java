/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.view;

import java.util.List;
import pl.ssoch.dietcomposer.data.Dish;
import pl.ssoch.dietcomposer.data.DishComponent;
import pl.ssoch.dietcomposer.data.DishItems;

/**
 *
 * @author Seba
 */
public class DishViewInfo {

    private List<String> dishViewInfo;

    public DishViewInfo(Dish dishes) {
        prepareInfo(dishes);
    }

    public List<String> getDishesView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void prepareInfo(Dish dish) {
        String dishName = dish.getDishName();
        for (DishItems dishItem : dish.getDishItems()) {
            int amout = dishItem.getAmount();
            String dishCompName = dishItem.getDishComponent().getDishComponentName();
            String dishCompUnit = dishItem.getDishComponent().getUnit().toString();
            double calPerUnit = dishItem.getDishComponent().getCaloriesPerUnit();
        }
    }
}
