package com.javarush.task.task28.task2805;


import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {

    private static AtomicInteger count = new AtomicInteger(0);


    public MyThread() {
        if(count.get()==10){
            count.set(1);

        this.setPriority(count.get());
        }
        else{count.incrementAndGet();
        this.setPriority(count.get());
        }

    }

    public MyThread(Runnable target) {
        super(target);
        if(count.get()==10){
            count.set(1);

            this.setPriority(count.get());
        }
        else{count.incrementAndGet();
            this.setPriority(count.get());
        }

    }

    public MyThread(ThreadGroup group, Runnable target) {

        super(group, target);

        if(count.get()==10){
            count.set(1);

            this.setPriority(count.get());
        }
        else if(count.get()>=group.getMaxPriority()){
            count.incrementAndGet();
            this.setPriority(group.getMaxPriority());
        }
        else{count.incrementAndGet();
            this.setPriority(count.get());
        }


    }

    public MyThread(String name) {
        super(name);
        if(count.get()==10){
            count.set(1);

            this.setPriority(count.get());
        }
        else{count.incrementAndGet();
            this.setPriority(count.get());
        }
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        if(count.get()==10){
            count.set(1);

            this.setPriority(count.get());
        }
        else if(count.get()>=group.getMaxPriority()){
            count.incrementAndGet();
            this.setPriority(group.getMaxPriority());
        }
        else{count.incrementAndGet();
            this.setPriority(count.get());
        }
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        if(count.get()==10){
            count.set(1);

            this.setPriority(count.get());
        }
        else{count.incrementAndGet();
            this.setPriority(count.get());
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        if(count.get()==10){
            count.set(1);

            this.setPriority(count.get());
        }
        else if(count.get()>=group.getMaxPriority()){
            count.incrementAndGet();
            this.setPriority(group.getMaxPriority());
        }
        else{count.incrementAndGet();
            this.setPriority(count.get());
        }

    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        if(count.get()==10){
            count.set(1);

            this.setPriority(count.get());
        }
        else if(count.get()>=group.getMaxPriority()){
            count.incrementAndGet();
            this.setPriority(group.getMaxPriority());
        }
        else{count.incrementAndGet();
            this.setPriority(count.get());
        }
    }
}
