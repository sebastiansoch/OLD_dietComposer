/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.ssoch.dietcomposer.data.Dish;
import pl.ssoch.dietcomposer.data.DishComponent;
import pl.ssoch.dietcomposer.data.DishComponentUnit;
import pl.ssoch.dietcomposer.data.DishItems;
import pl.ssoch.dietcomposer.data.DishType;

/**
 *
 * @author ssoch
 */
public class DishesDAOSql implements DishesDAO {

    private final Connection connection;

    public DishesDAOSql(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Dish> getAllDishesForType(DishType dishType) {
        Map<Integer, String> dishes = new HashMap<>();

        String sqlDishes = "SELECT d.dish_id, d.name FROM dishes d"
                + " JOIN dishes_dish_types ddt ON d.dish_id = ddt.dish_id"
                + " JOIN dish_types t ON t.dish_type_id = ddt.dish_type_id"
                + " WHERE t.type = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlDishes);
            statement.setString(1, dishType.toString());
            ResultSet rs = statement.executeQuery(sqlDishes);

            while (rs.next()) {
                dishes.put(Integer.parseInt("dish_id"), "name");
            }

        } catch (SQLException ex) {
            //TODO
            throw new RuntimeException(ex);
        }

        for (Integer id : dishes.keySet()) {
            List<DishItems> dishItems = new ArrayList<>();

            List<DishComponent> dishComponents = new ArrayList<>();
            String dishComponentName;
            DishComponentUnit unit;
            double caloriesPerUnit;

            int amount;

            try {
                String sqlDI = "SELECT c.name, u.name, c.calories_per_unit, i.amount"
                        + "	FROM dish_items i"
                        + " JOIN dishes d ON i.dish_id = d.dish_id"
                        + " JOIN dish_components c ON c.dish_component_id = i.dish_component_id"
                        + " JOIN units u ON u.unit_id = c.unit_id"
                        + " WHERE i.dish_id = ?";

                PreparedStatement statement = connection.prepareStatement(sqlDI);
                statement.setString(1, id.toString());
                ResultSet rs = statement.executeQuery(sqlDI);
                
                while(rs.next()) {
                    dishComponents.add(new DishComponent("c.name", DishComponentUnit.valueOf("u.name"), Double.parseDouble("calories_per_unit")));
                
                }
                
            } catch (SQLException ex) {
                //TODO
                throw new RuntimeException(ex);
            }

        }
    }

    @Override
    public List<String> getDishTypes() {
        List<String> types = new ArrayList<>();

        String sql = "SELECT *  FROM dish_types";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                types.add(rs.getString("type"));
            }

        } catch (SQLException ex) {
            //TODO
            throw new RuntimeException(ex);
        }

        return types;
    }

}
