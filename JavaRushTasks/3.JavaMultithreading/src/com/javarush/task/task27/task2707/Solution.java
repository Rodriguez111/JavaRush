package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/

/*
* В первой нити лочимся на объект 1 и ждем 500 мс. В это время запускаем вторую нить, и  в методе лочимся на объект 1.
* Если это разные объекты. то бкудет deadlock, то есть false. Если одинаковые - будет true
*
* */
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj2) {



            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (obj1) {

                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {
Thread t1 = new Thread(new Runnable() {
    @Override
    public void run() {

        synchronized (o1) {




            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (o2) {

            }

        }


    }
});

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {


                solution.someMethodWithSynchronizedBlocks(o1, o2);

            }
        });

        t1.start();
        t2.start();

        Thread.sleep(1000);



       return t1.getState().toString()!="BLOCKED" && t2.getState().toString()!="BLOCKED";





        //do something here
        //return false;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isNormalLockOrder(solution, o1, o2));
    }
}
