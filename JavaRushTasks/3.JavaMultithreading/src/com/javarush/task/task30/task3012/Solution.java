package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {

        int range[] = new int[] {1, 3, 9, 27, 81, 243, 729, 2187};

        int sum = 0;
        int maxElement = 0;
        int indexOfMaxElement = 0;

        for(int i = 0; i< range.length; i++){

            sum = sum+range[i];
            if(sum>=number){
                maxElement =  range[i];
                indexOfMaxElement = i;
                break;
            }
        }

        System.out.println(maxElement);






        //напишите тут ваш код
    }
}