/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.viewhelper;

import pl.ssoch.dietcomposer.data.DishType;

/**
 *
 * @author ssoch
 */
public class DishViewHelper {

    private String dishType;
    private int dishTypeId;
    private int dishId;
    private String dishName;

    public DishViewHelper(int dishId, String dishName, DishType dishType) {
        this.dishType = dishType.getName();
        this.dishId = dishId;
        this.dishName = dishName;
    }

    public String getDishType() {
        return dishType;
    }

    public int getDishId() {
        return dishId;
    }

    public String getDishName() {
        return dishName;
    }
}
