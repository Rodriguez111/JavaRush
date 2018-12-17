package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {


        String result = "";

        try {

            if(string.indexOf("\t")==-1){
                throw new TooShortStringException();
            }
            int start = string.indexOf("\t");//индекс первого табулятора



            int end = string.substring(string.indexOf("\t") + 1).indexOf("\t")+string.substring(0,string.indexOf("\t")).length()+1;//индекс второго табулятора


            result = string.substring(start+1, end);

        }
        catch (NullPointerException e){

                throw new TooShortStringException();


        }
        catch (StringIndexOutOfBoundsException e){

                throw new TooShortStringException();

        }


        return result;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("rfth"));

    }
}
