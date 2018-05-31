/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.servlet.data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Seba
 */
public class DishComponentsDAOFake implements DishComponentsDAO {

    @Override
    public List<DishComponent> getDishComponentsList() {
        ArrayList<DishComponent> dishComponents = new ArrayList<>();
        dishComponents.add(new DishComponent(0, "kawa", DishComponentType.NON_ALCOHOLIC_DRINK, DishComponentUnit.GLASS, 50));
        dishComponents.add(new DishComponent(1, "chleb", DishComponentType.FOOD, DishComponentUnit.SLICE, 70));
        dishComponents.add(new DishComponent(2, "szynka", DishComponentType.FOOD, DishComponentUnit.SLICE, 10));
        dishComponents.add(new DishComponent(4, "maslo", DishComponentType.FOOD, DishComponentUnit.GRAM, 10));
        return dishComponents;
    }
}
