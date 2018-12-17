package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    private static AdvertisementStorage instance = new AdvertisementStorage();
    private final List<Advertisement> videos = new ArrayList<>();

    public static AdvertisementStorage getInstance() {
        return instance;
    }

    private AdvertisementStorage() {
        Advertisement firstVideo = new Advertisement(new Object(), "First Video", 5000, 100, 3 * 60); // 3 min
        Advertisement secondVideo = new Advertisement(new Object(), "Second Video",  100, 0, 15 * 60); //15 min
        Advertisement thirdVideo = new Advertisement(new Object(), "Third Video", 400, 0, 10 * 60); //10 min
        Advertisement fourthVideo = new Advertisement(new Object(), "Fourth Video", 500, 2, 2 * 60); //2 min
        Advertisement fifthVideo = new Advertisement(new Object(), "Пятое Video", 410, 0, 2 * 60); //2 min
//        Advertisement sixthVideo = new Advertisement(new Object(), "Sixth Video", 410, 2, 3 * 60); //3 min
        add(firstVideo);
        add(secondVideo);
        add(thirdVideo);
        add(fourthVideo);
        add(fifthVideo);
//        add(sixthVideo);

//        Advertisement video01 = new Advertisement(new Object(), "Video01", 1000000, 100, 3 * 60); // 2 min

//        Advertisement video02 = new Advertisement(new Object(), "Video02", 5000, 100, 1 * 60); // 2 min
//        Advertisement video03 = new Advertisement(new Object(), "Video03", 4000, 100, 2 * 60); // 2 min
//        Advertisement video04 = new Advertisement(new Object(), "Video04", 8900, 100, 3 * 60); // 2 min
//        Advertisement video05 = new Advertisement(new Object(), "Video05", 5000, 100, 4 * 60); // 2 min
//        Advertisement video06 = new Advertisement(new Object(), "Video06", 5000, 100, 5 * 60); // 2 min
//        Advertisement video07 = new Advertisement(new Object(), "Video07", 5000, 100, 6 * 60); // 2 min
//        Advertisement video08 = new Advertisement(new Object(), "Video08", 5000, 100, 7 * 60); // 2 min
//        Advertisement video09 = new Advertisement(new Object(), "Video09", 5000, 100, 8 * 60); // 2 min
//        Advertisement video10 = new Advertisement(new Object(), "Video10", 5000, 100, 9 * 60); // 2 min
//        Advertisement video11 = new Advertisement(new Object(), "Video11", 5000, 100, 10 * 60); // 2 min

//        Advertisement video21 = new Advertisement(new Object(), "Video21", 4000, 100, 1 * 60); // 1 min
//        Advertisement video22 = new Advertisement(new Object(), "Video22", 4000, 100, 1 * 60); // 1 min
//        Advertisement video23 = new Advertisement(new Object(), "Video23", 4000, 100, 1 * 60); // 1 min
//        Advertisement video24 = new Advertisement(new Object(), "Video24", 4000, 100, 1 * 60); // 1 min
//        Advertisement video25 = new Advertisement(new Object(), "Video25", 4000, 100, 1 * 60); // 1 min

//        add(video01);
//        add(video02);
//        add(video03);
//        add(video04);
//        add(video05);
//        add(video06);
//        add(video07);
//        add(video08);
//        add(video09);
//        add(video10);
//        add(video11);
//        add(video21);
//        add(video22);
//        add(video23);
//        add(video24);
//        add(video25);




    }


    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement){
        videos.add(advertisement);
    }




}
