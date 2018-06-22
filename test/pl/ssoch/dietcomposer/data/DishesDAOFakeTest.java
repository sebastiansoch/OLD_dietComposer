/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.data;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ssoch
 */
public class DishesDAOFakeTest {

    public DishesDAOFakeTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void pickDisches() {
        DishesDAOFake dishesDAO = new DishesDAOFake();
        List<Dish> dishes = dishesDAO.createDishes(DishType.BREAKFAST, getTestData());

        assertEquals(2, dishes.size());

        for (Dish d : dishes) {
            if (d.getDishName().equals("owsianka")) {
                assertEquals(3, d.getDishItems().size());
            } else if (d.getDishName().equals("jajecznica z bekonem")) {
                assertEquals(4, d.getDishItems().size());
            }
        }

    }

    private String[][] getTestData() {
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
}
