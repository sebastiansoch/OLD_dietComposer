/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.data;

/**
 *
 * @author ssoch
 */
public class DishItems {
    private DishComponent dishComponent;
    private int amount;

    public DishItems(DishComponent dishComponent, int amount) {
        this.dishComponent = dishComponent;
        this.amount = amount;
    }

    public double getDishComponentCalories() {
        double calories = 500000;
        return calories;
    }
}
