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
        /*
        List<Dish> dishes = new ArrayList<>();

        switch (dishType) {
            case BREAKFAST:
                dishes.add(new Dish("owsianka"));
                dishes.add(new Dish("jajecznia na boczku"));
                dishes.add(new Dish("sok pomaranczowy"));
                dishes.add(new Dish("herbata"));
                dishes.add(new Dish("kawa"));
                break;
            case SECOND_BREAKFAST:
                dishes.add(new Dish("kaszka"));
                dishes.add(new Dish("kaszanka"));
                dishes.add(new Dish("herbata"));
                dishes.add(new Dish("sok pomaranczowy"));
                break;
            case SOUP:
                dishes.add(new Dish("pomidorowa"));
                dishes.add(new Dish("rosol"));
                dishes.add(new Dish("ogorkowa"));
                break;
            case MAIN_COURSE:
                dishes.add(new Dish("szabowy z ziemniakami"));
                dishes.add(new Dish("mielony"));
                dishes.add(new Dish("makaron z serem"));
                break;
            case TEA:
                dishes.add(new Dish("jablko"));
                dishes.add(new Dish("czekolada"));
                dishes.add(new Dish("baton"));
                break;
            case SUPPER:
                dishes.add(new Dish("parowki"));
                dishes.add(new Dish("sok jablkowy"));
                dishes.add(new Dish("herbata czarna"));
                dishes.add(new Dish("woda"));
                break;
            default:
                dishes = null;
                break;
        }

        return dishes;
         */
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
            {"owsianka", "platki gorske", "150", "gram", "100"},
            {"owsianka", "rodzynki", "200", "gram", "20"}
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
