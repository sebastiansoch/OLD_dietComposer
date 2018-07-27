/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.viewhelper;

import pl.ssoch.dietcomposer.data.DishComponentUnit;
import pl.ssoch.dietcomposer.data.DishItems;

/**
 *
 * @author Seba
 */
public class DishComponentViewHelper {

    private int dishAmount;
    private String dishCompName;
    private String dishCompUnit;
    private double calPerUnit;

    private final DishItems dishItem;

    public DishComponentViewHelper(DishItems dishItem) {
        this.dishItem = dishItem;
        prepareInfo();
    }

    private void prepareInfo() {
        dishAmount = dishItem.getAmount();
        dishCompName = dishItem.getDishComponent().getDishComponentName();

        DishComponentUnit unit = dishItem.getDishComponent().getUnit();
        switch (unit) {
            case GRAM:
                dishCompUnit = "gram";
                break;
            case BOWL:
                dishCompUnit = "miska";
                break;
            case GLASS:
                dishCompUnit = "szklanka";
                break;
            case NUMBER:
                dishCompUnit = "sztuk";
                break;
            case SLICE:
                dishCompUnit = "plasterek";
                break;
            case SPOON:
                dishCompUnit = "łyżka";
                break;
        }

//        dishCompUnit = dishItem.getDishComponent().getUnit().toString();
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
