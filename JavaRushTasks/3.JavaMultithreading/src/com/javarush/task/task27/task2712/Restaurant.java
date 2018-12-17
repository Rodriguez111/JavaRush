package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {


        private static final int ORDER_CREATING_INTERVAL = 100;
    private final static LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();


    public static void main(String[] args) {


            List<Tablet> tablets = new ArrayList<>();



            for(int i = 0; i< 5; i++){
                Tablet tablet = new Tablet(i);
                tablet.setQueue(orderQueue);
             tablets.add(tablet) ;
            }






Cook cook1 = new Cook("Tom"); //создаем повара
        cook1.setQueue(orderQueue);
Cook cook2 = new Cook("John"); //создаем повара
        cook2.setQueue(orderQueue);





            for(int i = 0; i< 5; i++){
                    tablets.get(i);

            }







Waiter waiter = new Waiter(); //создаем официанта

        cook1.addObserver(waiter); //добавляем повару наблюдателя (официант будет получать уведомления о приготовленном заказе)
        cook2.addObserver(waiter); //добавляем повару наблюдателя (официант будет получать уведомления о приготовленном заказе)



        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        thread.start();


        Thread cook1Thread = new Thread(cook1);
        cook1Thread.start();

        Thread cook2Thread = new Thread(cook2);
        cook2Thread.start();





        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();


        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();






    }
}
