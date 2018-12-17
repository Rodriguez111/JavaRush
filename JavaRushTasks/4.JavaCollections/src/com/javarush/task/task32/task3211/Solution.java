package com.javarush.task.task32.task3211;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {



        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

      byte[] array1 =  messageDigest.digest(byteArrayOutputStream.toByteArray());

    String result = "";

        for(int i = 0; i<array1.length; i++){
            result = result+String.format("%02x",array1[i] ); //преобразуем в 16-ричный формаи

        }

        if(result.equals(md5)){return true;}

        return false;
    }
}
