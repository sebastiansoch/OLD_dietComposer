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
public enum DishType {
    BREAKFAST("Śniadanie"),
    SECOND_BREAKFAST("Drugie śniadanie"),
    SOUP("Zupa"),
    MAIN_COURSE("Danie główne"),
    TEA("Podwieczorek"),
    SUPPER("Obiad / Kolacja"),
    NOTDEFINED("Nie znany posiłek");
    
    private String name;
    
    private DishType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}