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
public enum DishComponentUnit {
    GRAM("gram"),
    NUMBER("sztuk"),
    GLASS("szklanka"),
    SLICE("plasterek"),
    BOWL("miska"),
    SPOON("łyżka");
    
    private String name;
    
    private DishComponentUnit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
