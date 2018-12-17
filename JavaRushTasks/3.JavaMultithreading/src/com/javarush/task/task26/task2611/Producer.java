package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable   {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        int count = 1;
        while (!thread.isInterrupted()){

               map.put(String.valueOf(count), "Some text for " + count++);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.printf("[%s] thread was terminated",thread.getName() );
            }
        }
    }
}
