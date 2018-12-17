package com.javarush.task.task30.task3004;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class BinaryRepresentationTask extends RecursiveTask<String> {
    private int x;

    public BinaryRepresentationTask(int x) {
        this.x = x;
    }

    @Override
    protected String compute() {

       List<BinaryRepresentationTask> listOgTasks = new ArrayList<>();
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b > 0) {

            BinaryRepresentationTask task = new BinaryRepresentationTask(b);
            task.fork();
            listOgTasks.add(task);

        }


        for(BinaryRepresentationTask eachTask : listOgTasks){
            result = eachTask.join()+result;
        }

        return result;







    }
}
