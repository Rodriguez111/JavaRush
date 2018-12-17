package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {

    private static StatisticManager instance;
    private StatisticStorage statisticStorage = new StatisticStorage();
    //private Set<Cook> cooks = new HashSet();

    private StatisticManager(){

    }

    public static StatisticManager getInstance() {
        if (instance == null){
            instance = new StatisticManager();
        }

        return instance;
    }

   public void register(EventDataRow data){
       statisticStorage.put(data);
   }

//    public void register(Cook cook){
//        cooks.add(cook);
//    }


    public TreeMap getAmountPerDay(){
        TreeMap<Date, Long> map = new TreeMap<>();
        Map<EventType, List<EventDataRow>> storage = statisticStorage.getStorage(); //получаем список списков событий в локальную переменную
        List<EventDataRow> listOfEvents = storage.get(EventType.SELECTED_VIDEOS); //извлекаем список выбранных видеороликов

        for (EventDataRow eachEvent : listOfEvents){
                VideoSelectedEventDataRow videoSelectedEventDataRow = (VideoSelectedEventDataRow)eachEvent; //даункастим события к событию виделроликов

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH); //задаем вормат даты без времени
            Date dateWithoutTime = null;
            try {
                dateWithoutTime = sdf.parse(sdf.format(eachEvent.getDate())); // форматируем дату без времени
            } catch (ParseException e) {
                e.printStackTrace();
            }

                   long amount = videoSelectedEventDataRow.getAmount();
                   map.computeIfPresent(dateWithoutTime, (a,b) -> b+amount); //если в списке есть такая дата - суммируем ее
                   map.computeIfAbsent(dateWithoutTime, (b) -> amount); //если в списке нет такой даты - вставляем новую запись

        }
       // map.put(new Date(118,9,01), new Long(385));
        return map;
    }

    public TreeMap getCooksInfo(){
        TreeMap<Date, TreeMap<String, Integer>> map = new TreeMap<>();
        Map<EventType, List<EventDataRow>> storage = statisticStorage.getStorage(); //получаем список списков событий в локальную переменную
        List<EventDataRow> listOfEvents = storage.get(EventType.COOKED_ORDER); //извлекаем список заказов

        for (EventDataRow eachEvent : listOfEvents){
            CookedOrderEventDataRow cookedOrderEventDataRow = (CookedOrderEventDataRow)eachEvent; //даункастим события к событию заказов

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH); //задаем вормат даты без времени
            Date dateWithoutTime = null;
            try {
                dateWithoutTime = sdf.parse(sdf.format(eachEvent.getDate())); // форматируем дату без времени
            } catch (ParseException e) {
                e.printStackTrace();
            }


            //TreeMap<String, Integer> tempMap = new TreeMap<>();


            if(map.containsKey(dateWithoutTime)){
                map.get(dateWithoutTime).computeIfPresent(cookedOrderEventDataRow.getCookName(), (a,b) -> b+cookedOrderEventDataRow.getTime());
                map.get(dateWithoutTime).computeIfAbsent(cookedOrderEventDataRow.getCookName(), (b) -> cookedOrderEventDataRow.getTime());
            }
            else{
                TreeMap<String, Integer> tempMap = new TreeMap<>();
                tempMap.put(cookedOrderEventDataRow.getCookName(), cookedOrderEventDataRow.getTime());
                map.put(dateWithoutTime, tempMap);
            }


        }
        //TreeMap<String, Integer> tempMap = new TreeMap<>();
        //tempMap.put("Vasya", 1820);
        //map.put(new Date(118,9,01), tempMap);
        return map;


    }




   //-----------------------------


   private class StatisticStorage{

       private Map<EventType, List<EventDataRow>> storage = new HashMap();



       private StatisticStorage() { //модификатор private позволит огнаничить доступ за пределами класса StatisticManager
           for(EventType eachEvent: EventType.values()){
               storage.put(eachEvent, new ArrayList<EventDataRow>());

           }

       }

       private void put(EventDataRow data){

           storage.get(data.getType()).add(data);

       }

       public Map<EventType, List<EventDataRow>> getStorage() {
           return storage;
       }
   }

//    public Set<Cook> getCooks() {
//        return cooks;
//    }
}
