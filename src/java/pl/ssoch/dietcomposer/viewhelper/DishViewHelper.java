/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.viewhelper;

import pl.ssoch.dietcomposer.data.DishType;

/**
 *
 * @author ssoch
 */
public class DishViewHelper {

    private String dishType;
    private int dishId;
    private String dishName;

    public DishViewHelper(DishType dishType, int dishId, String dishName) {
        this.dishType = convertDishTypeToString(dishType);
        this.dishId = dishId;
        this.dishName = dishName;
    }

    public String getDishType() {
        return dishType;
    }

    public int getDishId() {
        return dishId;
    }

    public String getDishName() {
        return dishName;
    }

    private String convertDishTypeToString(DishType dishType) {
        switch (dishType) {
            case BREAKFAST:
                return "Śniadanie";
            case SECOND_BREAKFAST:
                return "Drugie śniadanie";
            case SOUP:
                return "Zupa";
            case MAIN_COURSE:
                return "Danie główne";
            case TEA:
                return "Podwieczorek";
            case SUPPER:
                return "Obiad";
            default:
                return "Nie znany posiłek";
        }
    }

}
