/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.services;

import java.util.ArrayList;
import java.util.List;
import pl.ssoch.dietcomposer.data.DishComponent;
import pl.ssoch.dietcomposer.dao.DishComponentsDAO;

/**
 *
 * @author Seba
 */
public class DishComponentsManager {

    private DishComponentsDAO dish;

    public DishComponentsManager(DishComponentsDAO dish) {
        this.dish = dish;
    }

    public List<String> getAllComponents() {
        ArrayList<String> dishComponents = new ArrayList<>();
        for (DishComponent dc : dish.getDishComponentsList()) {
            dishComponents.add("Nazwa: " + dc.getDishComponentName() + ", jednostka: " + dc.getUnit()
                    + ", ilość kalorii/jednostkę: " + dc.getCaloriesPerUnit());
        }

        return dishComponents;
    }
}
