/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.data;

import pl.ssoch.dietcomposer.data.DishesDAO;
import pl.ssoch.dietcomposer.data.DishesDAOFake;

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
