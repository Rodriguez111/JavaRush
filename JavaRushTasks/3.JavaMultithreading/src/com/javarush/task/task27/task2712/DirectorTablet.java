package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;


import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {

    private StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();




    public void printAdvertisementProfit(){
        Map <Date, Long> map = new TreeMap<>(new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return o2.compareTo(o1);
            }
        });

        map  = StatisticManager.getInstance().getAmountPerDay().descendingMap();


        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        double totalAmount = 0;

        for (Map.Entry<Date, Long> each : map.entrySet()){
            totalAmount = totalAmount+each.getValue();
            String date = dateFormat.format(each.getKey());
             ConsoleHelper.writeMessage(date+ " - "+ String.format("%.2f", (double)each.getValue()/100.00));

         }

        ConsoleHelper.writeMessage("Total - "+String.format("%.2f", (double)totalAmount/100.00));


    }
    public void printCookWorkloading(){
        Map <Date, TreeMap<String, Integer>> map = new TreeMap<>(new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return o2.compareTo(o1);
            }
        });
        map  = StatisticManager.getInstance().getCooksInfo().descendingMap();

        for (Map.Entry<Date, TreeMap<String, Integer>> each : map.entrySet()){
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String date = dateFormat.format(each.getKey());

            ConsoleHelper.writeMessage(date); //выводим дату


            for (Map.Entry<String, Integer> eachCook : each.getValue().entrySet()){
                int time = eachCook.getValue();

                double timeInMinutes = (double)time/60;
                int resultRoundedTime = (int)Math.ceil(timeInMinutes);




                ConsoleHelper.writeMessage(eachCook.getKey()+" - "+resultRoundedTime + " min" ); //имя повара и время
            }
            ConsoleHelper.writeMessage("");

        }



    }
    public void  printActiveVideoSet(){
        List<Advertisement> activeVideo = statisticAdvertisementManager.getActiveVideo();
        Collections.sort(activeVideo, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });

        for(Advertisement eachVideo : activeVideo){
            ConsoleHelper.writeMessage(eachVideo.getName()+" - "+eachVideo.getHits());
        }



    }
    public void printArchivedVideoSet(){
        List<Advertisement> archivedVideo = statisticAdvertisementManager.getArchivedVideo();
        Collections.sort(archivedVideo, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });

        for(Advertisement eachVideo : archivedVideo){
            ConsoleHelper.writeMessage(eachVideo.getName());
        }



    };
}
