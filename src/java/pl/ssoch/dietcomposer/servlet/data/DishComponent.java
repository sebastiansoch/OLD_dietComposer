/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.servlet.data;

/**
 *
 * @author Seba
 */
public class DishComponent {
    private int id;
    private String dishComponentName;
    private DishComponentType dishComponentType;
    private DishComponentUnit unit;
    private int caloriesPerUnit;

    public DishComponent(int id, String dishComponentName, DishComponentType dishComponentType, DishComponentUnit unit, int caloriesPerUnit) {
        this.id = id;
        this.dishComponentName = dishComponentName;
        this.dishComponentType = dishComponentType;
        this.unit = unit;
        this.caloriesPerUnit = caloriesPerUnit;
    }

    public int getId() {
        return id;
    }

    public String getDishComponentName() {
        return dishComponentName;
    }

    public DishComponentType getDishComponentType() {
        return dishComponentType;
    }

    public DishComponentUnit getUnit() {
        return unit;
    }

    public int getCaloriesPerUnit() {
        return caloriesPerUnit;
    }

}
