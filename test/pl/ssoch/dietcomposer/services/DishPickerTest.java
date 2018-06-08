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
        
            assertFalse(!dishPicker.pickDishes(getDishes(), 20).isEmpty());
        
    }

    private List<Dish> getDishes() {
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("owsianka"));
        dishes.add(new Dish("jajecznia na boczku"));
        dishes.add(new Dish("sok pomaranczowy"));
        dishes.add(new Dish("herbata"));
        dishes.add(new Dish("kawa"));

        return dishes;
    }
}
