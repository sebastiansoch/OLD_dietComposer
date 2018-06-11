/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Seba
 */
public class DishesDAOFake implements DishesDAO {

    private HashMap< DishType, List< Dish>> dishDB;

    public DishesDAOFake() {
        prepateDishes();
    }

    @Override
    public List<Dish> getAllDishesForType(DishType dishType) {
        return dishDB.get(dishType);
    }

    private HashMap< DishType, List< Dish>> prepateDishes() {
        dishDB = new HashMap<>();
        dishDB.put(DishType.BREAKFAST, createDishList(getBreakfastData()));
        dishDB.put(DishType.SECOND_BREAKFAST, createDishList(getSecondBreakfastData()));
        return dishDB;
    }

    private List<Dish> createDishList(String[][] breakfastData) {
        List<Dish> dishes;
        
        
        for( String[] row : breakfastData) {
            DishComponent dishComponent = new DishComponent(row[1], decodeStringToEnum(row[3]), Integer.parseInt(row[2]));
        }
        
        return dishes;
    }

    private String[][] getBreakfastData() {
        String[][] data = new String[][]{
            //dish     ,  component      ,  kcal ,  unit , amount
            {"owsianka",  "platki gorske",  "150", "gram", "100"},
            {"owsianka",  "rodzynki",       "200", "gram", "20"}
        };
        return data;
    }

    private String[][] getSecondBreakfastData() {
        String[][] data = new String[][]{
            {"owsianka", "", "", "",""},
            {"owsianka", "", "", "",""}
        };
        return data;
    }
    
    private DishComponentUnit decodeStringToEnum(String name) {
        switch (name) {
            case "gram":
                return DishComponentUnit.GRAM;
            case "glass":
                return DishComponentUnit.GLASS;
            case "slice":
                return DishComponentUnit.SLICE;
            case "number":
                return DishComponentUnit.NUMBER;
            default:
                throw new RuntimeException("Nie właściwy typ");
        }
    }

}
