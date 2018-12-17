package com.javarush.task.task25.task2512;

import java.io.IOException;

/*
Живем своим умом
*/
public class Solution extends Thread implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        //прерываем поток:
        t.interrupt();

//вызываем метод, выводящий информацию в обратном порядке через рекурсию:
        printException(e);
    }

    void printException(Throwable e){

String str = e.getClass().getName()+": "+e.getMessage();
        if(e.getCause()!=null){
            e = e.getCause();
            printException(e);        }
        System.out.println(str);
    }


    @Override
    public void run() {
//проверочный код:

        try {
            throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
        } catch (Exception e) {
            uncaughtException(Thread.currentThread(), e);
        }

    }

    public static void main(String[] args) {

        Solution solution = new Solution();


        Thread thread = new Thread(solution);
        thread.setUncaughtExceptionHandler(new Solution());
        thread.start();


    }

}
