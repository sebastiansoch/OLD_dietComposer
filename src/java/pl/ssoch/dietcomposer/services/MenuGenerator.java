/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.services;

import java.util.List;
import pl.ssoch.dietcomposer.data.Dish;

/**
 *
 * @author ssoch
 */
public interface MenuGenerator {
    
    public Menu createMenu(int calories);
}