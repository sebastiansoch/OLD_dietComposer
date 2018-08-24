/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.viewhelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import pl.ssoch.dietcomposer.dao.FactoryDAOAbs;
import pl.ssoch.dietcomposer.data.Dish;
import pl.ssoch.dietcomposer.data.DishItems;
import pl.ssoch.dietcomposer.data.DishType;
import pl.ssoch.dietcomposer.services.DishManager;
import pl.ssoch.dietcomposer.services.Menu;
import pl.ssoch.dietcomposer.services.MenuGenerator;

/**
 *
 * @author ssoch
 */
public class DishDetailsViewHelper {
    //DishName, List<DishComponents>
    private Map<String, List<DishComponentViewHelper>> dishesComponents;

    public Map<String, List<DishComponentViewHelper>> getDishesComponents() {
        return dishesComponents;
    }

    DishManager dishManager = FactoryDAOAbs.getFactoryDAO().getDishManager();
    String aa = dishManager.getDish(2);


    private void prepareView(List<DishType> dishTypeList, int calories) {
        MenuGenerator menuGen = FactoryDAOAbs.getFactoryDAO().getMenuGenerator();
        Menu menu = menuGen.createMenu(calories);

        for (DishType dishType : dishTypeList) {

            for (Dish dish : menu.getMetConditionDishes(dishType)) {

                getDishComponents(dish);
            }

            for (Dish dish : menu.getNotMetConditionDishes(dishType)) {
                getDishComponents(dish);
            }
        }
    }

    private void getDishComponents(Dish dish) {
        List<DishComponentViewHelper> dishComponents = new ArrayList<>();
        for (DishItems dishItem : dish.getDishItems()) {
            dishComponents.add(new DishComponentViewHelper(dishItem));
        }
        dishesComponents.put(dish.getDishName(), dishComponents);
    }

    
}
