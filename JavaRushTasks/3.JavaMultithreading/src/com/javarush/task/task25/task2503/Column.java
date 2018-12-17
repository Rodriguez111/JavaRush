package com.javarush.task.task25.task2503;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum Column implements Columnable {
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();

        /*
        упорядочиваем массив по возрастанию.
        Key - становится либо -1(не отображать), либо индекс колонки по порядку
        Value - индекс нашего enum-а, то есть какое значение отображать в колонке.

        */
        TreeMap<Integer, Integer> m = new TreeMap<>();

        for(int i = 0; i<realOrder.length; i++){
            m.put(realOrder[i],i);
        }

        for(Map.Entry<Integer, Integer> iter: m.entrySet() ){

            if(iter.getKey() != -1){
                result.add(Column.values()[iter.getValue()]);
            }

        }

        return result;
    }


    @Override
    public String getColumnName() {
        return this.columnName;
    }

    @Override
    public boolean isShown() {
        if(realOrder[Column.this.ordinal()]==-1){return false;}
        return true;
    }

    @Override
    public void hide() {
        //присваиваем текущему enum-у индекс -1, тем самым скрываем его
        realOrder[Column.this.ordinal()]=-1;

    }








}
