/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.dao;

import pl.ssoch.dietcomposer.services.MenuGenerator;

/**
 *
 * @author ssoch
 */
public interface FactoryDAO {

    DishComponentsDAO getDishComponentsDAO();

    DishesDAO getDishesDAO();

    MenuGenerator getMenuGenerator();
    
}
