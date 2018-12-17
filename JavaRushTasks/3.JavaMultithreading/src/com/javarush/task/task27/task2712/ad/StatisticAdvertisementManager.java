package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();

    public static StatisticAdvertisementManager getInstance() {



        return ourInstance;
    }

    private StatisticAdvertisementManager() {
    }


    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();


    public List<Advertisement> getActiveVideo(){
       List<Advertisement> allVideo =  advertisementStorage.list();
        List<Advertisement> activeVideo = new ArrayList<>();

       for(Advertisement eachVideo : allVideo){
           if(eachVideo.getHits()>0){
               activeVideo.add(eachVideo);
           }
       }
       return  activeVideo;
    }


    public List<Advertisement> getArchivedVideo(){
        List<Advertisement> allVideo =  advertisementStorage.list();
        List<Advertisement> archivedVideo = new ArrayList<>();

        for(Advertisement eachVideo : allVideo){
            if(eachVideo.getHits()==0){
                archivedVideo.add(eachVideo);
            }
        }
        return  archivedVideo;
    }


}
