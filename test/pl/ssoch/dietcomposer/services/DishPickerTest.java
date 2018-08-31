/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.services;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pl.ssoch.dietcomposer.data.Dish;
import pl.ssoch.dietcomposer.data.DishComponent;
import pl.ssoch.dietcomposer.data.DishComponentUnit;
import pl.ssoch.dietcomposer.data.DishItems;
import pl.ssoch.dietcomposer.data.DishType;

/**
 *
 * @author ssoch
 */
public class DishPickerTest {

    public DishPickerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void pickDishTest() {
        DishPicker dishPicker = new DishPicker();
        
            assertFalse(dishPicker.pickDishes(getDishes(), 500).size() == 0);
     int a  = 0;   
    }

    private List<Dish> getDishes() {
        List<Dish> dishes = new ArrayList<>();

        Dish owsianka = new Dish(1, "owsianka", DishType.BREAKFAST);
        owsianka.setDishItems(getDishItems("owsianka"));
        dishes.add(owsianka);

        Dish jajecznica = new Dish(10, "jajecznia na boczku", DishType.SUPPER);
        jajecznica.setDishItems(getDishItems("aa"));
        dishes.add(jajecznica);
        
        
        dishes.add(new Dish(11, "sok pomaranczowy", DishType.BREAKFAST, DishType.SECOND_BREAKFAST, DishType.SUPPER));
        dishes.add(new Dish(12, "herbata", DishType.BREAKFAST, DishType.SECOND_BREAKFAST, DishType.TEA, DishType.SUPPER));
        dishes.add(new Dish(13, "kawa", DishType.BREAKFAST, DishType.SECOND_BREAKFAST, DishType.TEA));

        return dishes;
    }
    
    private List<DishItems> getDishItems(String dishName) {
        List<DishItems> dishItems = new ArrayList<>();
        if (dishName.equals("owsianka")) {
            dishItems.add(new DishItems(new DishComponent("platki gorskie", DishComponentUnit.GRAM, 390), 100)); //390
            dishItems.add(new DishItems(new DishComponent("jogurt", DishComponentUnit.GRAM, 60), 100));         //60
            dishItems.add(new DishItems(new DishComponent("rodzynki", DishComponentUnit.GRAM, 298), 20));       //59,6
            // SUMA -- 509,6
        } else if (dishName.equals("jajecznia na boczku")) {
            dishItems.add(new DishItems(new DishComponent("jajka", DishComponentUnit.NUMBER, 109), 2)); //208
            dishItems.add(new DishItems(new DishComponent("bekon", DishComponentUnit.SLICE, 450), 2)); //900
            dishItems.add(new DishItems(new DishComponent("chleb", DishComponentUnit.SLICE,  215), 1)); //215
            dishItems.add(new DishItems(new DishComponent("masło", DishComponentUnit.GRAM, 735), 3)); //22,05
        } //SUMA -- 1345,05
        
        return dishItems;
    }
}
