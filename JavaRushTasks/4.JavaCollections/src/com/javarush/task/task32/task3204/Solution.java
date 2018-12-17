package com.javarush.task.task32.task3204;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {

        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits =  "0123456789";
        String characterSet = upper+upper.toLowerCase()+digits;

        char[] characterSetArray = characterSet.toCharArray();


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String pass = "";

       for(int i = 0; i<8; i++){
          int randomNumber = (int)(Math.random()*characterSetArray.length);

           pass = pass+characterSetArray[randomNumber];
       }



       if(pass.matches("^\\D*$")){ //если содержит НЕ ЦИФРЫ

           pass = pass.replace((pass.charAt(7)), '9');
       }

        if(!pass.matches(".*[a-z].*")){ //если не содержит ни одногй буквы нижнего регистра

            pass = pass.replace((pass.charAt(6)), 'u');
        }

       ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(pass.getBytes());

        while (byteArrayInputStream.available() >0){
            byteArrayOutputStream.write(byteArrayInputStream.read());

       }



        return byteArrayOutputStream;
    }
}