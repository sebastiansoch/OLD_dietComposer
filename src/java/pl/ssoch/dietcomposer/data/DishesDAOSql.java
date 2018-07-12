/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

        } catch (SQLException e) {
            //TODO
            throw new RuntimeException(e);
        }

        return types;
    }

}
