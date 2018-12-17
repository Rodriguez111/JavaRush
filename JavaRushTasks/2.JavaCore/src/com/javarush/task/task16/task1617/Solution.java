package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int countSeconds = 5;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();
        //add your code here - добавь код тут


    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {




            while (countSeconds>0 & !isInterrupted()){



                System.out.print(countSeconds-- + " ");
                if(countSeconds==0 & !isInterrupted()){System.out.print("Марш!");}

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Прервано!");


                }

            }


            //add your code here - добавь код тут
        }
    }
}
