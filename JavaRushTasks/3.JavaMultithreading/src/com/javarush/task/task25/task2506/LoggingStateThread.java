package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {

    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        System.out.println(thread.getState());
    }

    @Override
    public void run() {
        State state = thread.getState();


        while (true){
            State newState = thread.getState();

            if(!state.equals(newState)){
                state = newState;
                System.out.println(state.toString());
            }

            if(state.toString().equals("TERMINATED")){
                this.interrupt();
                break;};


        }
    }
}
