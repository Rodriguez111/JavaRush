package com.javarush.task.task25.task2514;

/* 
Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
*/
public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public void run() {

            System.out.println("begin-" + index);
            Thread.yield();// решение
            System.out.println("end-" + index);
        }
    }

    public static void main(String[] args) {
        YieldRunnable yieldRunnable = new YieldRunnable(1);


        Thread thread1 = new Thread(yieldRunnable);
        Thread thread2 = new Thread(yieldRunnable);
        thread1.start();
        thread2.start();



    }
}
