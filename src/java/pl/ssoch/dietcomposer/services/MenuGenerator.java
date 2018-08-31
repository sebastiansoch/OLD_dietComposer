/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.services;

import java.util.Map;
import pl.ssoch.dietcomposer.data.DishType;

/**
 *
 * @author ssoch
 */
public interface MenuGenerator {
    public Menu createMenu(Map<DishType, Double> caloriesForType);
}
