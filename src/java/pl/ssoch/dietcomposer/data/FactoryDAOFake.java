/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.data;

import pl.ssoch.dietcomposer.services.MenuGenerator;
import pl.ssoch.dietcomposer.services.MenuGeneratorImpl;

/**
 *
 * @author Seba
 */
public class FactoryDAOFake {

    public static DishesDAO getDishesDAO() {
        return new DishesDAOFake();
    }
    
    public static DishComponentsDAO getDishComponentsDAO() {
        return new DishComponentsDAOFake();
    }
    
    public static MenuGenerator getMenuGenerator() {
        return new MenuGeneratorImpl(getDishesDAO());
    }
}
