/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.servlet.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Seba
 */
public class DishComponent {
    private int id;
    private String dishComponentName;
    private List<String> dishComponentType;
    private DishComponentUnit unit;
    private int caloriesPerUnit;

    public DishComponent(int id, String dishComponentName, DishComponentUnit unit, int caloriesPerUnit, String... type) {
        this.id = id;
        this.dishComponentName = dishComponentName;
        this.dishComponentType = new ArrayList<>();
        addDishComponentType(type);
        this.unit = unit;
        this.caloriesPerUnit = caloriesPerUnit;
    }

    public int getId() {
        return id;
    }

    public String getDishComponentName() {
        return dishComponentName;
    }

    public void addDishComponentType(String... type) {
        dishComponentType.addAll(Arrays.asList(type));
    }

    public DishComponentUnit getUnit() {
        return unit;
    }

    public int getCaloriesPerUnit() {
        return caloriesPerUnit;
    }

    public boolean haveAllTypes(List<String> type) {
        return dishComponentType.containsAll(type);
    }
}
