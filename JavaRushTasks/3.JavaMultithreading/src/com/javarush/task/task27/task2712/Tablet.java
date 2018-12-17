package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet  {
    final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());

    private LinkedBlockingQueue<Order> queue;

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() {


        try {
            Order order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());

            videoSelection(order);
            return order;

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
            return null;
        }

    }


    public void createTestOrder(){

        Order order = null;
        try {
            order = new TestOrder(this);
            ConsoleHelper.writeMessage(order.toString());


            videoSelection(order);


        }catch (IOException e){

        }



    }

    private void videoSelection(Order order) {
        if (!order.isEmpty()) {
            //setChanged();
            AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
            try {
                advertisementManager.processVideos();
            } catch (NoVideoAvailableException e) {
                logger.log(Level.INFO, "No video is available for the order " + order);

            }

            queue.offer(order); //добавляем заказ в очередь

            //notifyObservers(order);


        }
    }


    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
