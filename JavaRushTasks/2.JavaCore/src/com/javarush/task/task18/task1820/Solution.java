package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String file1 = br.readLine();
        String file2 = br.readLine();
        br.close();


        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);

        BufferedReader br2 = new BufferedReader(new InputStreamReader(fis));

        String line;
        while ((line = br2.readLine()) != null){

while(line.length()>0) {
    Double number;
    if(line.indexOf(" ")==-1){ //если в строке нет пробелов (последний элемент)
        number=Double.parseDouble(line);
        fos.write(rounding(number).getBytes());//получаем байты и записываем в файл
        break;
    }
    else {
        number = Double.parseDouble(line.substring(0, line.indexOf(" ")));
    }
    fos.write(rounding(number).getBytes());//получаем байты и записываем в файл
    fos.write(32);//записываем пробел
    if (line.indexOf(" ")!=-1){line = line.substring(line.indexOf(" ") + 1);}

   }

}
        fis.close();
        fos.close();


}

static private String rounding(double number){
    double resultDouble =new Double(Math.round(number));//округляем double до целых
    String result=new Integer((int)resultDouble).toString(); //преобразуем double
    // в int(чтобы не было 0 после запятой и преобразуем int в строку)
    return result;


}


}
