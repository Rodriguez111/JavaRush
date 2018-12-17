package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String strToParse = scan.nextLine();
        String strToPrint;
        String strToCheck;
        strToParse = strToParse.substring(strToParse.indexOf("?")+1); //начало первого параметра
        ArrayList<String> arr = new ArrayList<>();

        while(strToParse.indexOf("=")!=-1){ //Пока в строке присутствует знак "="

if(strToParse.indexOf("&")==-1){strToCheck=strToParse; //если в строке нет значка "&" (имеем остаток строки)

    if(strToCheck.indexOf("obj")!=-1){ //проверяем есть ли "obj"

        String objValue = strToCheck.substring(strToCheck.indexOf("=")+1);
        arr.add(objValue); //добавляем в массив значений обджектов
        strToPrint=strToCheck.substring(0, strToParse.indexOf("=")-1);
        System.out.println(strToPrint);
    }

    else{
        if (strToCheck.indexOf("=")!=-1){
            strToPrint=strToCheck.substring(0, strToCheck.indexOf("="));
        }
        else {strToPrint=strToCheck;}

        System.out.println(strToPrint);

    }

        break;
        }


                strToCheck = strToParse.substring(0, strToParse.indexOf("&")); //берем остаток строки до первого символа &
                strToParse=strToParse.substring(strToParse.indexOf("&")+1); //теперь остаток строки уже от символа & и до конца строки

               if(strToCheck.indexOf("obj")!=-1){

                   String objValue = strToCheck.substring(strToCheck.indexOf("=")+1);
                   arr.add(objValue);
                   strToPrint=strToCheck.substring(0, strToCheck.indexOf("="));
                   System.out.print(strToPrint+" ");
               }

               else{
                   if (strToCheck.indexOf("=")!=-1){
                       strToPrint=strToCheck.substring(0, strToCheck.indexOf("="));
                   }
                   else {strToPrint=strToCheck;}

                   System.out.print(strToPrint+" ");
               }

        }

for(int i=0;i<arr.size();i++){
            if (arr.get(i).matches("^[-+]?[0-9]*[.,]?[0-9]+(?:[eE][-+]?[0-9]+)?$")){//проверяем через орегулярное выражение, что строка является числом с плавающей точкой
                alert(Double.valueOf(arr.get(i))); //если да, преобразуем в Double и вызываем метод Double
            }

            else{alert(arr.get(i));} //если нет - вызываем метод для строки
}


    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
