package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable {
    private String name;

    public Cook(String name) {
        this.name = name;

    }

    //private boolean busy;

//    public boolean isBusy() {
//        return busy;
//    }

    private LinkedBlockingQueue<Order> queue;

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public void startCookingOrder(Order order){

        //busy = true;

        ConsoleHelper.writeMessage( "Start cooking - " + order.toString()+", cooking time "+order.getTotalCookingTime()+"min");
        setChanged();
        notifyObservers(order); //уведомляем подписчика(официанта) о том, что заказ готов

        Tablet tablet = order.getTablet();
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(tablet.toString(), name, order.getTotalCookingTime()*60, order.getDishes() ));

        try {
            Thread.sleep(order.getTotalCookingTime()*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //busy = false;
    }

    @Override
    public String toString() {
        return name;
    }


    @Override
    public void run() {


        while (true) {
            if (queue.size() > 0) {

                   startCookingOrder(queue.poll());
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }













    }
}
