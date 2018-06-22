/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Seba
 */
public class DishesDAOFake implements DishesDAO {

    private HashMap<DishType, List< Dish>> dishDB;

    public DishesDAOFake() {
        prepareDishes();
    }

    @Override
    public List<Dish> getAllDishesForType(DishType dishType) {
        return dishDB.get(dishType);
    }

    private HashMap< DishType, List< Dish>> prepareDishes() {
        dishDB = new HashMap<>();
        dishDB.putAll(createDishes(DishType.BREAKFAST, getBreakfastData()));
        dishDB.putAll(createDishes(DishType.SECOND_BREAKFAST, getSecondBreakfastData()));
        dishDB.putAll(createDishes(DishType.SOUP, getSoupData()));
        dishDB.putAll(createDishes(DishType.MAIN_COURSE, getmainCourseData()));
        dishDB.putAll(createDishes(DishType.TEA, getTeaData()));
        dishDB.putAll(createDishes(DishType.SUPPER, getSupperData()));

        return dishDB;
    }

    Map<String, Dish> prepareDishesMap(DishType dishType, String[][] dishData) {
        Map<String, Dish> dishesMap = new HashMap<>();
        for (String[] row : dishData) {

            Dish dish = dishesMap.get(row[0]);
            if (dish == null) {
                dish = new Dish(row[0], dishType);
                dishesMap.put(row[0], dish);
            }
            dish.addDishItem(new DishItems(new DishComponent(row[1], decodeStringToEnum(row[3]), Integer.parseInt(row[2])), Integer.parseInt(row[4])));
        }

        return dishesMap;
    }

    Map<DishType, List<Dish>> createDishes(DishType dishType, String[][] dishData) {
        Map<String, Dish> dishesMap = prepareDishesMap(dishType, dishData);
        List<Dish> dishesList = new ArrayList<>();
        dishesList.addAll(dishesMap.values());
        Map<DishType, List<Dish>> dishes = new HashMap<>();
        dishes.put(dishType, dishesList);
        return dishes;

    }

    private String[][] getBreakfastData() {
        String[][] data = new String[][]{
            //dish     ,  component      ,  kcal ,  unit , amount
            {"owsianka", "platki gorske", "390", "gram", "100"},
            {"owsianka", "jogurt", "60", "gram", "100"},
            {"owsianka", "rodzynki", "298", "gram", "20"},
            {"jajecznica z bekonem", "jajka", "109", "number", "2"},
            {"jajecznica z bekonem", "bekon", "450", "slice", "2"},
            {"jajecznica z bekonem", "chleb", "215", "slice", "1"},
            {"jajecznica z bekonem", "masło", "735", "gram", "3"}
        };
        return data;
    }

    private String[][] getSecondBreakfastData() {
        String[][] data = new String[][]{
            //dish    , component ,  kcal , unit     , amount
            {"kanapka", "bułka", "272", "number", "1"},
            {"kanapka", "maslo", "735", "gram", "3"},
            {"kanapka", "ser zolty", "314", "slice", "1"},
            {"kanapka", "szynka", "389", "slice", "1"},
            {"kanapka", "jajko", "109", "number", "1"}
        };
        return data;
    }

    private String[][] getSoupData() {
        String[][] data = new String[][]{
            //dish       ,  component       ,  kcal ,  unit , amount
            {"pomidorowa", "zupa pomidorowa", "11", "bowl", "1"},
            {"pomidorowa", "makaron", "377", "gram", "50"},
            {"pomidorowa", "śmietana 18%", "186", "spoon", "1"}
        };
        return data;
    }

    private String[][] getmainCourseData() {
        String[][] data = new String[][]{
            //dish       ,  component       ,  kcal ,  unit , amount
            {"schabowy", "kotlet schabowy", "351", "gram", "100"},
            {"schabowy", "ziemniaki", "85", "gram", "200"},
            {"schabowy", "ogorek kiszony", "12", "number", "1"}
        };
        return data;
    }

    private String[][] getTeaData() {
        String[][] data = new String[][]{
            //dish            ,  component , kcal ,  unit , amount
            {"salatka owocowa", "jablko", "46", "number", "1"},
            {"salatka owocowa", "gruszka", "54", "number", "1"},
            {"salatka owocowa", "baban", "95", "number", "1"},
            {"salatka owocowa", "rodzynki", "298", "gram", "20"},};
        return data;
    }

    private String[][] getSupperData() {
        String[][] data = new String[][]{
            //dish            ,  component , kcal ,  unit , amount
            {"naleśniki z dzemem", "nalesnik", "174", "number", "1"},
            {"naleśniki z dzemem", "dzem", "150", "spoon", "1"}
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
            case "bowl":
                return DishComponentUnit.BOWL;
            case "spoon":
                return DishComponentUnit.SPOON;
            default:
                throw new RuntimeException("Nie właściwy typ");
        }
    }

}
