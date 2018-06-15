/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.servlet;

import pl.ssoch.dietcomposer.data.DishType;

/**
 *
 * @author ssoch
 */
public class DishTapeInfo {

    private final DishType dishType;
    private final String name;

    DishTapeInfo(DishType dishType, String name) {
        this.dishType = dishType;
        this.name = name;
        
    }

    public DishType getDishType() {
        return dishType;
    }

    public String getName() {
        return name;
    }
    
}
