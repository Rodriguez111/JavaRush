package com.javarush.task.task13.task1322;

/* 
Интерфейс SimpleObject
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        SimpleObject<String, Integer> stringObject = new StringObject<Object, Object>();
    }

    interface SimpleObject<T, T2> {
        SimpleObject<T, T2> getInstance();
    }

    public static class StringObject<String, Integer> implements SimpleObject {


        @Override
        public SimpleObject<String, Integer> getInstance() {
            return null;
        }
    }


}
