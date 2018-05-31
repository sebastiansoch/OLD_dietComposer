/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.servlet.data;

import pl.ssoch.dietcomposer.servlet.data.DishesDAO;
import pl.ssoch.dietcomposer.servlet.data.DishesDAOFake;

/**
 *
 * @author Seba
 */
public class FactoryDAO {

    public static DishesDAO getDishesDAO() {
        return new DishesDAOFake();
    }
    
    public static DishComponentsDAO getDishComponentsDAO() {
        return new DishComponentsDAOFake();
    }
}
