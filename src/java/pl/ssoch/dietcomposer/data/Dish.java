/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.ssoch.dietcomposer.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Seba
 */
public class Dish {
    private final String dishName;
    private final Set<DishType> dishType;
    private List<DishItems> dishItems;
    
    public Dish(String dishName, DishType... dishType) {
        this.dishName = dishName;
        this.dishType = new HashSet<>();
        this.dishType.addAll(Arrays.asList(dishType));
        this.dishItems = new ArrayList<>();
    }

    public void setDishItems(List<DishItems> dishItems) {
        this.dishItems = dishItems;
    }

    public void addDishItem(DishItems dishItem) {
        this.dishItems.add(dishItem);
    }
    
    public String getDishName() {
        return dishName;
    }

    public List<DishItems> getDishItems() {
        return dishItems;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.dishName);
        hash = 13 * hash + Objects.hashCode(this.dishType);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dish other = (Dish) obj;
        if (!Objects.equals(this.dishName, other.dishName)) {
            return false;
        }
        if (!Objects.equals(this.dishType, other.dishType)) {
            return false;
        }
        return true;
    }
    
    
    
}
