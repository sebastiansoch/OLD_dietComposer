/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Seba
 */
public class Dish {

    private final int dishID;
    private final String dishName;
    private final Set<DishType> dishTypes;
    private List<DishItems> dishItems;

    public Dish(int dishID, String dishName, DishType... dishType) {
        this.dishID = dishID;
        this.dishName = dishName;
        this.dishTypes = new HashSet<>();
        this.dishTypes.addAll(Arrays.asList(dishType));
        this.dishItems = new ArrayList<>();
    }

    public void setDishItems(List<DishItems> dishItems) {
        this.dishItems = dishItems;
    }

    public void addDishItem(DishItems dishItem) {
        this.dishItems.add(dishItem);
    }

    public int getDishId() {
        return dishID;
    }

    public String getDishName() {
        return dishName;
    }

    public List<DishItems> getDishItems() {
        return dishItems;
    }

}
