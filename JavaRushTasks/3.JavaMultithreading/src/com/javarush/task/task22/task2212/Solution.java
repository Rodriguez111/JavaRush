package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {

        if (telNumber == null){return false;}

        char[] symbols = telNumber.toCharArray();
        int numbersCount=0;
        for (int i=0;i<symbols.length;i++){
            if(Character.isDigit(symbols[i])){numbersCount++;}
          }

          //if(numbersCount!=12 && numbersCount!=10){return false;}

          if (numbersCount==12 && !telNumber.matches("\\+\\d+([(]\\d{3}[)]){0,1}\\d+([-]){0,1}\\d+([-]){0,1}\\d+") ) {return false;}

        if (numbersCount==10 && !telNumber.matches("\\d{0,10}([(]\\d{3}[)]){0,1}\\d+([-]){0,1}\\d+([-]){0,1}\\d+") ) {return false;}

        return true;
    }

    public static void main(String[] args) {

        System.out.println(checkTelNumber("(050)1234567"));

    }
}
