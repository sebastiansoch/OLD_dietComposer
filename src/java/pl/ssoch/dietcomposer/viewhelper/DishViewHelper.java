/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.viewhelper;

import java.util.ArrayList;
import java.util.List;
import pl.ssoch.dietcomposer.data.Dish;
import pl.ssoch.dietcomposer.data.DishItems;

/**
 *
 * @author Seba
 */
public class DishViewHelper {

    private String dishName;
    private List<DishComponentViewHelper> dishComponentInfo;

    public DishViewHelper(Dish dish) {
        dishName = dish.getDishName();
        dishComponentInfo = new ArrayList<>();
        prepareInfo(dish);
    }

    private void prepareInfo(Dish dish) {
        for (DishItems dishItem : dish.getDishItems()) {
            dishComponentInfo.add(new DishComponentViewHelper(dishItem));
        }
    }

    public String getDishName() {
        return dishName;
    }

    public List<DishComponentViewHelper> getDishComponentInfo() {
        return dishComponentInfo;
    }

}
