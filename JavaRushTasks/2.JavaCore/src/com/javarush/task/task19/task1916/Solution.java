package com.javarush.task.task19.task1916;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        br.close();

        ArrayList<String> f1 = new ArrayList<>();
        ArrayList<String> f2 = new ArrayList<>();

        FileReader fr1 = new FileReader(file1);
        FileReader fr2 = new FileReader(file2);
        br=new BufferedReader(fr1);
        String line;

        while ((line=br.readLine())!=null){
            f1.add(line);
        }
        fr1.close();

        br=new BufferedReader(fr2);
        while ((line=br.readLine())!=null){
            f2.add(line);
        }
        fr2.close();



        int countF1=0;
        int countF2=0;

//--------------------------------------------------------------
          while (countF1<f1.size() && countF2<f2.size()) {

              if (f1.get(countF1).equals(f2.get(countF2))) { //если строки совпадают
                  lines.add(new LineItem(Type.SAME, f1.get(countF1)));
              } else {
                  //если счетчик строк второго файла меньше или равен количеству строк второго файла минус одна строка (чтобы не выйти за пределы второго файла)
                  //и если текущая строка первого файла равна следующей строке второго файла
                  if (countF2+1<=f2.size()-1 && f1.get(countF1).equals(f2.get(countF2 + 1))) {
                      lines.add(new LineItem(Type.ADDED, f2.get(countF2))); //тогда текущая строка второго файла - добавленная
                      countF1--; // отматываем счетчик первого файла на единицу назад
                  } else {
                      lines.add(new LineItem(Type.REMOVED, f1.get(countF1))); //иначе текущая строка первого файла удалена во втором файле
                      countF2--; // отматываем счетчик второго файла на единицу назад
                  }
              }
              countF1++;
              countF2++;
          }
//-----------------------------------------------------

        if(f2.size()>countF2 && lines.get(lines.size()-1).type.equals(Type.SAME)){
          lines.add(new LineItem(Type.ADDED, f2.get(countF2)));
        }

        if(f1.size()>countF1 && lines.get(lines.size()-1).type.equals(Type.SAME)){
            lines.add(new LineItem(Type.REMOVED, f1.get(countF1)));
        }



        for (int i=0;i<lines.size();i++){
            System.out.println(lines.get(i).type+" "+lines.get(i).line);
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
