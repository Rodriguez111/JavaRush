package com.javarush.task.task24.task2412;

import java.text.*;
import java.util.*;

/* 
Знания - сила!
*/
public class Solution {
    public static void main(String[] args) {
        List<Stock> stocks = getStocks();
        sort(stocks);
        Date actualDate = new Date();
        printStocks(stocks, actualDate);
    }

    public static void printStocks(List<Stock> stocks, Date actualDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        double[] filelimits = {0d, actualDate.getTime()};
        String[] filepart = {"closed {4}", "open {2} and last {3}"};

        ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
        Format[] testFormats = {null,null, dateFormat, fileform};
        MessageFormat pattform = new MessageFormat("{0}   {1} | {5} {6}");
        pattform.setFormats(testFormats);

        for (Stock stock : stocks) {
            String name = ((String) stock.get("name"));
            String symbol = (String) stock.get("symbol");
            double open = !stock.containsKey("open") ? 0 : ((double) stock.get("open"));
            double last = !stock.containsKey("last") ? 0 : ((double) stock.get("last"));
            double change = !stock.containsKey("change") ? 0 : ((double) stock.get("change"));
            Date date = (Date) stock.get("date");
            Object[] testArgs = {name, symbol, open, last, change, date, date.getTime()};
            System.out.println(
                    pattform.format(testArgs));
        }
    }

    public static void sort(List<Stock> list) {
        Collections.sort(list, new Comparator<Stock>() {
            public int compare(Stock stock1, Stock stock2) {
                int result;
                String name1 = (String)stock1.get("name");
                String name2 = (String)stock2.get("name");

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Date data1 = null;
                Date data2 = null;
                long time1 = 0;
                long time2 = 0;
                try {
                    data1 = dateFormat.parse(dateFormat.format((Date)stock1.get("date")));
                    data2 = dateFormat.parse(dateFormat.format((Date)stock2.get("date")));

                   time1 =  data1.getTime()/86_400_000L; //получаем целое количество суток(то есть дату без учета времени)
                   time2 =  data2.getTime()/86_400_000L;



                } catch (ParseException e) {
                    System.out.println("Неверный формат даты");;
                }
                double profit1 =0;
                double profit2 =0;

                if(stock1.containsKey("last")) {
                  profit1 = (double)stock1.get("last")-(double)stock1.get("open");
                }
                else{profit1 =(double)stock1.get("change");}

                if(stock2.containsKey("last")) {
                    profit2 = (double)stock2.get("last")-(double)stock2.get("open");
                }
                else{profit2 =(double)stock2.get("change");}


//Сортировка сначала по имени, потом по дате, потом по прибыли
                //сначала сравниваем по имени
                result = name1.compareTo(name2);
                if(result == 0){ //если имена равны, сравниваем по дате
                    result =  new Long(time2).compareTo(new Long(time1)) ;
                }
                if(result == 0){//если и даты равны, сравниваем по прибыли
                    result = new Double(profit2).compareTo(new Double(profit1));
                }

                return  result;

            }
        });
    }

    public static class Stock extends HashMap {
        public Stock(String name, String symbol, double open, double last) {
            put("name", name);
            put("symbol", symbol);
            put("open", open);
            put("last", last);
            put("date", getRandomDate(2020));
        }

        public Stock(String name, String symbol, double change, Date date) {
            put("name", name);
            put("symbol", symbol);
            put("date", date);
            put("change", change);
        }
    }

    public static List<Stock> getStocks() {
        List<Stock> stocks = new ArrayList();

        stocks.add(new Stock("Fake Apple Inc.", "AAPL", 125.64, 123.43));
        stocks.add(new Stock("Fake Cisco Systems, Inc.", "CSCO", 25.84, 26.3));
        stocks.add(new Stock("Fake Google Inc.", "GOOG", 516.2, 512.6));
        stocks.add(new Stock("Fake Intel Corporation", "INTC", 21.36, 21.53));
        stocks.add(new Stock("Fake Level 3 Communications, Inc.", "LVLT", 5.55, 5.54));
        stocks.add(new Stock("Fake Microsoft Corporation", "MSFT", 29.56, 29.72));

        stocks.add(new Stock("Fake Nokia Corporation (ADR)", "NOK", .1, getRandomDate()));
        stocks.add(new Stock("Fake Oracle Corporation", "ORCL", .15, getRandomDate()));
        stocks.add(new Stock("Fake Starbucks Corporation", "SBUX", .03, getRandomDate()));
        stocks.add(new Stock("Fake Yahoo! Inc.", "YHOO", .32, getRandomDate()));
        stocks.add(new Stock("Fake Applied Materials, Inc.", "AMAT", .26, getRandomDate()));
        stocks.add(new Stock("Fake Comcast Corporation", "CMCSA", .5, getRandomDate()));
        stocks.add(new Stock("Fake Sirius Satellite", "SIRI", -.03, getRandomDate()));


        return stocks;
    }

    public static Date getRandomDate() {
        return getRandomDate(1970);
    }

    public static Date getRandomDate(int startYear) {
        int year =startYear + (int) (Math.random() * 30);
        int month = (int) (Math.random() * 12);
        int day =(int) (Math.random() * 28);
        GregorianCalendar calendar = new GregorianCalendar(year, month, day);
        return calendar.getTime();
    }
}

