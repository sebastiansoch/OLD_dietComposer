/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.viewhelper;

import pl.ssoch.dietcomposer.data.DishItems;

/**
 *
 * @author Seba
 */
public class DishComponentViewHelper {

    private final DishItems dishItem;
    private int dishAmount;
    private String dishCompName;
    private String dishCompUnit;
    private double calPerUnit;

    public DishComponentViewHelper(DishItems dishItem) {
        this.dishItem = dishItem;
        prepareInfo();
    }

    private void prepareInfo() {
        dishAmount = dishItem.getAmount();
        dishCompName = dishItem.getDishComponent().getDishComponentName();
        dishCompUnit = dishItem.getDishComponent().getUnit().toString();
        calPerUnit = dishItem.getDishComponent().getCaloriesPerUnit();
    }

    public int getDishAmount() {
        return dishAmount;
    }

    public String getDishCompName() {
        return dishCompName;
    }

    public String getDishCompUnit() {
        return dishCompUnit;
    }

    public double getCalPerUnit() {
        return calPerUnit;
    }
}
