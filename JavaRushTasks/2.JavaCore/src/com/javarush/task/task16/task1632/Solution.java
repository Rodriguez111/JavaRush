package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static{
        Thread t1 = new Thread( new T1());
        threads.add(t1) ;
        Thread t2 = new Thread( new T2());
        threads.add(t2) ;
        Thread t3 = new Thread( new T3());
        threads.add(t3) ;
        threads.add(new T4()) ;
        Thread t5 = new Thread( new T5());
        threads.add(t5) ;
    }


    public static void main(String[] args) throws InterruptedException {


    }

    public static class T1 implements Runnable{
      public   void run(){
          while (true){}
      };

    }

    public static class T2 implements Runnable{
        public   void run() {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }

    }
    public static class T3 implements Runnable{
        public   void run(){
            while (true){

                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }

            }

        }
    }
    public static class T4 extends Thread implements Message{
        private boolean isChanceled = false;
        public   void run(){
while (!isChanceled){}
       }

        @Override
        public void showWarning() {
            this.isChanceled=true;
        }



    }
    public static class T5 implements Runnable{
        private int summa;
        public   void run(){

            Scanner scan = new Scanner(System.in);
            String line;
            while (true) {
                line=scan.nextLine();
               if (line.equals("N")) {break;}
                summa = summa + Integer.parseInt(line);

            }

            System.out.println(summa);

        };
    }

}