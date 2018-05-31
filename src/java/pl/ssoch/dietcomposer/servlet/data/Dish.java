/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.servlet.data;

import java.util.ArrayList;

/**
 *
 * @author Seba
 */
public class Dish {
    private final int id;
    private final String dishName;
    private ArrayList<DishComponent> dishComponentsList;
    
    public Dish(int id, String dishName, ArrayList<DishComponent> dishComponentsList) {
        this.id = id;
        this.dishName = dishName;
        this.dishComponentsList = dishComponentsList;
    }

    public int getId() {
        return id;
    }

    public String getDishName() {
        return dishName;
    }

    public ArrayList<DishComponent> getDishComponentsList() {
        return dishComponentsList;
    }
    
    
}
