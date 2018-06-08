/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Seba
 */
public class DishComponentsDAOFake implements DishComponentsDAO {
    private ArrayList<DishComponent> dishComponents = new ArrayList<>();

    public DishComponentsDAOFake() {
        dishComponents.add(new DishComponent(0, "kawa", DishComponentUnit.GLASS, 50));
        dishComponents.add(new DishComponent(1, "chleb", DishComponentUnit.SLICE, 70));
        dishComponents.add(new DishComponent(2, "szynka", DishComponentUnit.SLICE, 10));
        dishComponents.add(new DishComponent(4, "maslo", DishComponentUnit.GRAM, 10));
    }

    
    @Override
    public List<DishComponent> getDishComponentsList() {
        
        return dishComponents;
    }

    @Override
    public List<DishComponent> getDishComponentsList(List<String> types) {
        List<DishComponent> components = new ArrayList<>();
        for (DishComponent dc : dishComponents) {
            if (dc.haveAllTypes(types)) {
                components.add(dc);
            }
        }
        return components;
    }
}
