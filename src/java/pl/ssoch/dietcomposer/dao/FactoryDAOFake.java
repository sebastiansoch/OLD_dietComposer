/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.dao;

import pl.ssoch.dietcomposer.services.DishManager;
import pl.ssoch.dietcomposer.services.MenuGenerator;
import pl.ssoch.dietcomposer.services.MenuGeneratorImpl;

/**
 *
 * @author Seba
 */
public class FactoryDAOFake implements FactoryDAO {

    @Override
    public DishesDAO getDishesDAO() {
        return new DishesDAOFake();
    }
    
    @Override
    public DishComponentsDAO getDishComponentsDAO() {
        return new DishComponentsDAOFake();
    }
    
    @Override
    public MenuGenerator getMenuGenerator() {
        return new MenuGeneratorImpl(getDishesDAO());
    }

    @Override
    public DishManager getDishManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
