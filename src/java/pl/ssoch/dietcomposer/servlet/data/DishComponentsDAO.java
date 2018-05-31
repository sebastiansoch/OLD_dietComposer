/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.servlet.data;

import java.util.List;

/**
 *
 * @author Seba
 */
public interface DishComponentsDAO {
    public List<DishComponent> getDishComponentsList();
}
