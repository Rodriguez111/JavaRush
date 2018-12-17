package com.javarush.task.task25.task2505;

import java.util.logging.Logger;

/*
Без дураков
*/
public class Solution {

    public static void main(String[] args) {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();

    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            setDaemon(false);
        }

        private class MyUncaughtExceptionHandler implements UncaughtExceptionHandler{

            String message="";

            @Override
            public void uncaughtException(Thread t, Throwable e) {



                try {
                    Thread.sleep(500);
                } catch (InterruptedException ee) {
                    ee.printStackTrace();
                }


                message = e.getMessage();
                String s =  String.format("%s, %s, %s", secretKey, t.getName(),message);

                System.out.println(s);

            }

            public MyUncaughtExceptionHandler() {

            }
        }

        @Override
        public void run() {


                throw new NullPointerException("it's an example");


        }
    }

}

