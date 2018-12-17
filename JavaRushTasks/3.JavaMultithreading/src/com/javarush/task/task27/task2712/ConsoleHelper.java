package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
  static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException {

            return bufferedReader.readLine();

    }

    public static List<Dish> getAllDishesForOrder() throws IOException {


        List<Dish> dishes = new ArrayList<>();
        writeMessage("Выберите блюдо:");
        while (true) {
            writeMessage(Dish.allDishesToString());
            writeMessage("Введите название блюда или введите exit для выхода :");
            String choice = readString();
            if (choice.equals("exit")){break;}
            else if(!isDishPresent(choice)){
                writeMessage("Такого блюда нет в меню.");
                continue;
            }
            else {dishes.add(Dish.valueOf(choice));
            }
        }
//        for(Dish e: dishes){
//            System.out.println(e.toString());
//        }


        return dishes;

    }

    private static boolean isDishPresent(String choice){
        try {
            for (Dish eachDish : Dish.values()) {
                if (eachDish == Dish.valueOf(choice)) {
                    return true;
                }
            }
        }catch (IllegalArgumentException e){
            return false;
        }
            return false;
    }


}
