package com.javarush.task.task27.task2712.ad;


public class Advertisement {
    private Object content; //ролик
    private String name;
    private long initialAmount; //начальная сумма, стоимость рекламы в копейках
    private int hits; //количество оплаченных показов
    private int duration; //длительность ролика в секундах
    private long amountPerOneDisplaying; //стоимость показа одного ролика, в копейках


    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        if(hits>0) {
            amountPerOneDisplaying = initialAmount / hits;
        }
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public double getAmountPerSecond() {
        return (double)amountPerOneDisplaying / duration;
    }

    public long getOneSecondCostInThousandsParts(){
        return (long) (amountPerOneDisplaying*(1000/(double)duration));
    }

    public int getHits() {
        return hits;
    }

    public void revalidate(){
        if(hits ==0){
            throw new UnsupportedOperationException();
        }
       hits--;
    }
}
