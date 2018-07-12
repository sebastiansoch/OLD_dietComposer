/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.viewhelper;

import com.mysql.cj.api.mysqla.result.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pl.ssoch.dietcomposer.data.DishType;
import pl.ssoch.dietcomposer.data.FactoryDAOFake;
import pl.ssoch.dietcomposer.data.FactoryDAOSql;
import pl.ssoch.dietcomposer.servlet.DishTapeInfo;

/**
 *
 * @author ssoch
 */
public class HomeViewHelper {

      public List<String> getMeals() {
          return FactoryDAOSql.getInstance().getDishesDAO().getDishTypes();
      }
      
      
//    public List<DishTapeInfo> getMeals() {
//        List<DishTapeInfo> meals = new ArrayList<>();
//        meals.add(new DishTapeInfo(DishType.BREAKFAST, "Sniadanie"));
//        meals.add(new DishTapeInfo(DishType.SECOND_BREAKFAST, "Drugie Sniadanie"));
//        meals.add(new DishTapeInfo(DishType.SOUP, "Zupa"));
//        meals.add(new DishTapeInfo(DishType.MAIN_COURSE, "Drugie danie"));
//        meals.add(new DishTapeInfo(DishType.TEA, "Podwieczorek"));
//        meals.add(new DishTapeInfo(DishType.SUPPER, "Kolacja"));
//
//        return meals;
//    }

//    public List<String> getTypes(Connection connection) {
//        List<String> types = new ArrayList<>();
//        
//        String sql = "SELECT type FROM dish_types";
//        
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            ResultSet rs = preparedStatement.executeQuery(sql);
//            while (rs.next()) {
//                types.add(rs.getString("type"));
//            }
//        } catch (SQLException e) {
//            
//        }
//        
//        return types;
//    }

}