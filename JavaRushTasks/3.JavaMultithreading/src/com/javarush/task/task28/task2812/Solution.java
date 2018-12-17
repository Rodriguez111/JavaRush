package com.javarush.task.task28.task2812;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* 
ShutdownNow!
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            final int localId = i;
            executor.submit(new Runnable() {
                public void run() {
                    doExpensiveOperation(localId);

                }
            });
        }

      List<Runnable> lst = executor.shutdownNow(); //метод shutdownNow() возвращает список незавершенных задач

        for (int i = 0; i < lst.size(); i++) {
            System.out.println(lst.get(i)+" was not completed");
        }

    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId="+localId);
    }
}
