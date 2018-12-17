package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {

        int count=0;
        //находим верхний левый угол, не соприкасающийсяЮ у которого с трех сторон либо края либо нули
//i = столбцы; j - строки
        for(int j=0; j<a.length;j++){
            for(int i=0; i<a[j].length;i++){
                if(i==0 && j==0&& a[j][i]==1){//если в левом верхнем углу 1
                    count++;
                    continue;
                }
                    //если возле левого края или верхнего края
                if((i==0 && a[j-1][i]==0 && a[j][i]==1) || (j==0 && a[j][i-1]==0 && a[j][i]==1)){count++;}

                //в остальных случаях
                else if(i>0 && j>0 && a[j-1][i-1]==0 && a[j][i-1]==0 && a[j-1][i]==0 && a[j][i]==1 ){count++;}

                }




        }




        return count;
    }
}
