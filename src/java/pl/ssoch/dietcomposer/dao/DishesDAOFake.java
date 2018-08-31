/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pl.ssoch.dietcomposer.data.Dish;
import pl.ssoch.dietcomposer.data.DishComponent;
import pl.ssoch.dietcomposer.data.DishComponentUnit;
import pl.ssoch.dietcomposer.data.DishItems;
import pl.ssoch.dietcomposer.data.DishType;

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

    @Override
    public List<String> getDishTypes() {
        List<String> types = new ArrayList<>();
        types.add("Sniadanie");
        types.add("Drugie Sniadanie");
        types.add("Zupa");
        types.add("Drugie danie");
        types.add("Podwieczorek");
        types.add("Kolacja");

        return types;
    }

    @Override
    public Dish getDishById(int dishId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

            Dish dish = dishesMap.get(row[1]);
            if (dish == null) {
                dish = new Dish(Integer.parseInt(row[0]), row[1], dishType);
                dishesMap.put(row[1], dish);
            }
            dish.addDishItem(new DishItems(new DishComponent(row[2], decodeStringToEnum(row[4]), Double.parseDouble(row[3])), Integer.parseInt(row[5])));
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
            //id,   dish     ,  component      ,      kcal/unit ,  unit , amount
            {"1",   "owsianka", "platki gorske", "3.90", "gram", "100"},
            {"1",   "owsianka", "jogurt", "0.60", "gram", "100"},
            {"1",   "owsianka", "rodzynki", "2.98", "gram", "20"},
            {"2",   "jajecznica z bekonem", "jajka", "70.78", "number", "3"},
            {"2",   "jajecznica z bekonem", "bekon", "67.50", "slice", "2"},
            {"2",   "jajecznica z bekonem", "chleb", "53.75", "slice", "1"},
            {"2",   "jajecznica z bekonem", "masło", "22.05", "gram", "3"}
        };
        return data;
    }

    private String[][] getSecondBreakfastData() {
        String[][] data = new String[][]{
            //id,   dish    ,                  component ,     kcal ,    unit     , amount
            {"3",   "kanapka", "bułka", "163.20", "number", "1"},
            {"3",   "kanapka", "maslo", "22.05", "gram", "3"},
            {"3",   "kanapka", "ser zolty", "47.10", "slice", "1"},
            {"3",   "kanapka", "szynka", "77.80", "slice", "1"},
            {"3",   "kanapka", "jajko", "70.78", "number", "1"},
            {"4",   "jajecznica z pieczarkami", "jajka", "70.78", "number", "2"},
            {"4",   "jajecznica z pieczarkami", "pieczarki", "0.24", "gram", "15"},
            {"4",   "jajecznica z pieczarkami", "bekon", "67.50", "slice", "2"},
            {"4",   "jajecznica z pieczarkami", "chleb", "53.75", "slice", "1"},
            {"4",   "jajecznica z pieczarkami", "masło", "22.05", "gram", "3"}
        };
        return data;
    }

    private String[][] getSoupData() {
        String[][] data = new String[][]{
            //id,   dish       ,  component       ,  kcal ,  unit , amount
            {"5",   "pomidorowa", "zupa pomidorowa", "11.00", "bowl", "1"},
            {"5",   "pomidorowa", "makaron", "3.77", "gram", "50"},
            {"5",   "pomidorowa", "śmietana 18%", "46.50", "spoon", "1"}
        };
        return data;
    }

    private String[][] getmainCourseData() {
        String[][] data = new String[][]{
            //id,   dish       ,  component       ,  kcal ,  unit , amount
            {"6",   "schabowy", "kotlet schabowy", "3.51", "gram", "100"},
            {"6",   "schabowy", "ziemniaki", "0.85", "gram", "200"},
            {"6",   "schabowy", "ogorek kiszony", "7.20", "number", "1"}
        };
        return data;
    }

    private String[][] getTeaData() {
        String[][] data = new String[][]{
            //id,   dish            ,  component , kcal ,  unit , amount
            {"7",   "salatka owocowa", "jablko", "90.00", "number", "1"},
            {"7",   "salatka owocowa", "gruszka", "75.00", "number", "1"},
            {"7",   "salatka owocowa", "baban", "116.00", "number", "1"},
            {"7",   "salatka owocowa", "rodzynki", "2.98", "gram", "20"}
        };
        return data;
    }

    private String[][] getSupperData() {
        String[][] data = new String[][]{
            //id,   dish               ,  component , kcal ,  unit , amount
            {"8",   "naleśniki z dzemem", "nalesnik", "170.00", "number", "1"},
            {"8",   "naleśniki z dzemem", "dzem", "38.00", "spoon", "1"},
            {"3",   "kanapka", "bułka", "163.20", "number", "1"},
            {"3",   "kanapka", "maslo", "22.05", "gram", "3"},
            {"3",   "kanapka", "ser zolty", "47.10", "slice", "1"},
            {"3",   "kanapka", "szynka", "77.80", "slice", "1"},
            {"3",   "kanapka", "jajko", "70.78", "number", "1"}
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
