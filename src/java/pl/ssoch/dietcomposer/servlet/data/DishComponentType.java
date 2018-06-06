/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.servlet.data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Seba
 */
public class DishComponentType {
    private List<String> dishComponentType;

    public DishComponentType() {
        dishComponentType = new ArrayList<>();
        dishComponentType.add("FOOD");
        dishComponentType.add("NON_ALCOHOLIC_DRINK");
        dishComponentType.add("ALCOHOLIC_DRINK");
        dishComponentType.add("SNACK");
    }
    
    
}
