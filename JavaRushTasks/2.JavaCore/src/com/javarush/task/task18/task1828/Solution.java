package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length!=0 && args[0].equals("-u")) {
            ArrayList<String> lines = new ArrayList<>();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String fileName = br.readLine();
            br.close();

            FileInputStream fis = new FileInputStream(fileName);
            br=new BufferedReader(new InputStreamReader(fis,"UTF-8"));
            String line;
            while ((line=br.readLine())!=null) { //записываем файл в массив
                lines.add(line);
            }
            fis.close();
            br.close();

            for(int i=0;i<lines.size();i++){
                line=lines.get(i);
                if(line.substring(0,8).indexOf(" ")!=-1) {//если код дополнен до 8 символов пробелами
                    line = line.substring(0,line.indexOf(" "));
                }
                else{ //иначе берем с первого по 8 символ
                    line = line.substring(0, 8);
                }

                int code = Integer.parseInt(line); //перобразуем в int
                if (code==Integer.parseInt(args[1])){
                    lines.remove(i); //удаляем строку


                    String newCode = args[1];
                    while (newCode.length()<8){ //добавляем пробелы, если длина менее 8 символов
                        newCode=newCode+" ";
                    }
                    if (newCode.length()>8){newCode=newCode.substring(0,8);}//обрезаем если длиннее 8 символов

                    String name=args[2];
                    while (name.length()<30){ //добавляем пробелы, если длина менее 30 символов
                        name=name+" ";
                    }
                    if (name.length()>30){name=name.substring(0,30);}//обрезаем если длиннее 30 символов

                    String price=args[3];
                    while (price.length()<8){ //добавляем пробелы, если длина менее 8 символов
                        price=price+" ";
                    }
                    if (price.length()>8){price=price.substring(0,8);}//обрезаем если длиннее 8 символов

                    String quantity=args[4];
                    while (quantity.length()<4){ //добавляем пробелы, если длина менее 4 символов
                        quantity=quantity+" ";
                    }

                    String newLine=newCode+name+price+quantity;
                    lines.add(i, newLine);

                    writeFile(fileName, lines);
                }


            }
        }


        if (args.length!=0 && args[0].equals("-d")) {

            ArrayList<String> lines = new ArrayList<>();


            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String fileName = br.readLine();
            br.close();

            FileInputStream fis = new FileInputStream(fileName);
            br=new BufferedReader(new InputStreamReader(fis,"UTF-8"));
            String line;
            while ((line=br.readLine())!=null) { //записываем файл в массив
               lines.add(line);
              }
              fis.close();
            br.close();

            for(int i=0;i<lines.size();i++){
                line=lines.get(i);
                if(line.substring(0,8).indexOf(" ")!=-1) {//если код дополнен до 8 символов пробелами
                    line = line.substring(0,line.indexOf(" "));
                }
                else{ //иначе берем с первого по 8 символ
                    line = line.substring(0, 8);
                }

                int code = Integer.parseInt(line); //перобразуем в int
                if (code==Integer.parseInt(args[1])){
                    lines.remove(i); //удаляем строку
                    writeFile(fileName, lines);
                }

            }

            }

        }



        static void writeFile(String fileName, ArrayList<String> array){
            try {
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName),"UTF8"));
                String ls = System.getProperty("line.separator");
                for(int i=0;i<array.size();i++){
                    bw.write(array.get(i)+ls);

                }
                bw.close();


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }



}
