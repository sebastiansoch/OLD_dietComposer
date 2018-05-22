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
public class Dish {

    private final int id;

    private final String dishName;

    public Dish(int id, String dishName) {
        this.id = id;
        this.dishName = dishName;
    }

    public int getId() {
        return id;
    }

    public String getDishName() {
        return dishName;
    }
    
    
}
