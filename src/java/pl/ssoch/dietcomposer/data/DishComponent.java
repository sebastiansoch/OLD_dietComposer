/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.data;

/**
 *
 * @author Seba
 */
public class DishComponent {
    private String dishComponentName;
    private DishComponentUnit unit;
    private double caloriesPerUnit;

    public DishComponent(String dishComponentName, DishComponentUnit unit, double caloriesPerUnit) {
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

    public double getCaloriesPerUnit() {
        return caloriesPerUnit;
    }
}
