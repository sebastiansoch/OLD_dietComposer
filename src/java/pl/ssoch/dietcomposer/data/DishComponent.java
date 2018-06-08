/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Seba
 */
public class DishComponent {
    private String dishComponentName;
    private DishComponentUnit unit;
    private int caloriesPerUnit;

    public DishComponent(String dishComponentName, DishComponentUnit unit, int caloriesPerUnit) {
        this.dishComponentName = dishComponentName;
        this.unit = unit;
        this.caloriesPerUnit = caloriesPerUnit;
    }

    public String getDishComponentName() {
        return dishComponentName;
    }

    public DishComponentUnit getUnit() {
        return unit;
    }

    public int getCaloriesPerUnit() {
        return caloriesPerUnit;
    }
}
