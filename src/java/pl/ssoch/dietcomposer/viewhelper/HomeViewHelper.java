/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.viewhelper;

import java.util.List;
import pl.ssoch.dietcomposer.dao.FactoryDAOAbs;

/**
 *
 * @author ssoch
 */
public class HomeViewHelper {

      public List<String> getMeals() {
          return FactoryDAOAbs.getFactoryDAO().getDishesDAO().getDishTypes();
      }
}
