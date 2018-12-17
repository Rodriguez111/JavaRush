package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(System.in);//инициируев сканер для чтения имени файла
        String fileName = scan.nextLine(); // имя файла в переменную

      try {
          FileInputStream fstream = new FileInputStream(fileName); //инициируем поток чтения из файла
          BufferedReader br = new BufferedReader(new InputStreamReader(fstream));//Класс BufferedReader считывает текст из символьного потока ввода, буферизируя прочитанные символы.
          String line;
          int count=0;
          while ((line = br.readLine()) != null) {
             int number = Integer.parseInt(line);//преобразуем строку в число
             if (number%2==0) count++; // если четное - прибавляем счетчик
          }
            br.close(); //закрываем поток чтения из файла
          FileInputStream fstream2 = new FileInputStream(fileName); //новый поток
          BufferedReader br2 = new BufferedReader(new InputStreamReader(fstream2));

          int[] arr = new int[count]; //задаем размер массива (сколько насчитали четных чисел)
          int count2=0;//счетчик для записи в массив
          while ((line = br2.readLine()) != null) {
              int number = Integer.parseInt(line);

              if (number%2==0) {arr[count2]=number;count2++;}//если четное - записываем в массив и приблявляем счетчик
          }
          br2.close();//закрываем поток чтения из файла

            int temp;
          for (int i=0;i<arr.length;i++){//упорядочиваем смассив по возрастанию путем сраенения массива самого с собой через вложенный цикл
              for (int j=0;j<arr.length-1;j++){
                  if (arr[i]<arr[j]){
                      temp=arr[i];
                      arr[i]=arr[j];
                      arr[j]=temp;
                  }
              }
          }

          for (int i=0;i<arr.length;i++){
              System.out.println(arr[i]);
          }
      }
      catch (IOException e){
          System.out.println("Ошибка чтения файла");
      }
    }
}
