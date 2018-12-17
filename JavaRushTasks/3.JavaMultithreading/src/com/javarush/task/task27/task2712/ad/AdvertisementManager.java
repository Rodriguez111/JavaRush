package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;


    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos(){
        if(storage.list().isEmpty()){
            throw new NoVideoAvailableException();
        }
        else{

                List<Advertisement> videos = storage.list();
            Comparator<Advertisement> comparator=new Comparator<Advertisement>(){

                @Override
                public int compare(Advertisement o1, Advertisement o2) {
                    int result;
                    result = new Long(o2.getAmountPerOneDisplaying()).compareTo(new Long(o1.getAmountPerOneDisplaying()));
                    if(result == 0){
                        result = new Integer(o2.getDuration()).compareTo(new Integer(o1.getDuration()));
                    }

                    return result;

                }
            };

            Collections.sort(videos, comparator);

            List<Advertisement> resultVideos = new ArrayList<>();
            getMaximumProceedsVideos(resultVideos, 0);


            Comparator<Advertisement> comparator2=new Comparator<Advertisement>(){

                @Override
                public int compare(Advertisement o1, Advertisement o2) {
                    int result;
                    result = new Long(o2.getAmountPerOneDisplaying()).compareTo(new Long(o1.getAmountPerOneDisplaying()));
                    if(result == 0){
                        result = new Long(o1.getOneSecondCostInThousandsParts()).compareTo(new Long(o2.getOneSecondCostInThousandsParts()));
                    }
                    return result;
                }
            };
            Collections.sort(resultVideos, comparator2);
                    long amount = 0; //сумма денег в копейках
            int totalDuration = 0; //общая длительность роликов

            for (Advertisement advertisement:resultVideos){
                amount = amount + advertisement.getAmountPerOneDisplaying();
                totalDuration = totalDuration + advertisement.getDuration();
            }

            StatisticManager.getInstance().register(new VideoSelectedEventDataRow(resultVideos, amount, totalDuration ));

            for (Advertisement advertisement:resultVideos){
                ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d",advertisement.getName(),advertisement.getAmountPerOneDisplaying(),advertisement.getOneSecondCostInThousandsParts()));
                advertisement.revalidate();
            }






        }






    }


    public void getMaximumProceedsVideos(List<Advertisement> list,int index) {
        if ((storage.list().size() > index)) {
            int totalDuration = 0;
            for (Advertisement advertisement : list) {
                totalDuration += advertisement.getDuration();
            }
           // System.out.println("Total duration "+totalDuration+" dlina rolika v spiske "+storage.list().get(index).getDuration()+" index="+index);
            if ((timeSeconds - totalDuration) >= storage.list().get(index).getDuration() && storage.list().get(index).getHits()>0) {
                list.add(storage.list().get(index));
            }
            getMaximumProceedsVideos(list, ++index);
        }
    }


}
