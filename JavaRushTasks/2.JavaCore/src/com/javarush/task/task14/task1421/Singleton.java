package com.javarush.task.task14.task1421;

public class Singleton {
    /*Переменная с типом Singletone куда будем помещать экземплярр класса*/
    private static Singleton instance;

    /*Запрет созждания экземпляра извне путем приватности конструктора*/
    private  Singleton(){};

    static public Singleton getInstance(){
        if (instance==null){
            instance=new Singleton();
        }
        return instance;
    }
}
