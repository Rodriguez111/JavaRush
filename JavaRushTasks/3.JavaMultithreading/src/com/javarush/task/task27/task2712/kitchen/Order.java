package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    public int getTotalCookingTime(){
        int duration = 0;
        for(Dish eachDish : dishes ){
            duration = duration+eachDish.getDuration();
        }
        return duration;
    }

    public boolean isEmpty(){
        if(dishes.size() > 0)return false;
        else  return true;
    }

    public List<Dish> getDishes() {
        return dishes;
    }


    protected void initDishes() throws IOException {
        dishes = ConsoleHelper.getAllDishesForOrder();
    }


    public Tablet getTablet() {
        return tablet;
    }

    @Override
    public String toString() {
        if(dishes.size() > 0){
            return "Your order: "+dishes.toString()+" of "+tablet.toString();
        }
        return "";
    }
}
