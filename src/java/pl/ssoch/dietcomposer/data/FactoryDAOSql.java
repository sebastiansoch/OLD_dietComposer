/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.data;

import java.sql.Connection;

/**
 *
 * @author ssoch
 */
public class FactoryDAOSql {

    private static Connection connection;
    private static FactoryDAOSql factoryDAOSql;
    

    private FactoryDAOSql() {
    }

    public DishesDAO getDishesDAO() {
        return new DishesDAOSql(connection);
    }

    public static FactoryDAOSql getInstance() {
        if (factoryDAOSql == null) {
            factoryDAOSql = new FactoryDAOSql();
        }
        return factoryDAOSql;
    }
    
    public static void setConnection(Connection conn) {
        connection = conn;
    }

}
