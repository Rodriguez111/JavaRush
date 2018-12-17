package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {

    private List<Tablet> tablets;
    private List<Cook> cooks;
    private int ORDER_CREATING_INTERVAL;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;

//        List<Cook> cooks = new ArrayList<>();
//        cooks.add(new Cook("Tom") );
//        cooks.add(new Cook("John") );

       // this.cooks = cooks;
        this.ORDER_CREATING_INTERVAL = interval;
    }

    @Override
    public void run() {

        Waiter waiter = new Waiter(); //создаем официанта


        while (!Thread.currentThread().isInterrupted()){

            int selectTablet = (int)(Math.random()*(tablets.size()));
//            int selectCook = (int)(Math.random()*(cooks.size()));
//
//            //System.out.println((tablets.size()-1)+" - "+(cooks.size()-1));
//
            Tablet tablet = tablets.get(selectTablet);
//            Cook cook = cooks.get(selectCook);
//            tablet.addObserver(cook); //добавляем планшету наблюдателя (повар будет получать уведомления о новом заказе)
//            cook.addObserver(waiter); //добавляем повару наблюдателя (официант будет получать уведомления о приготовленном заказе)



            tablet.createTestOrder();
            try {
                Thread.sleep(ORDER_CREATING_INTERVAL);
            } catch (InterruptedException e) {
                break;
                /*NOP*/
            }

        }









    }
}
