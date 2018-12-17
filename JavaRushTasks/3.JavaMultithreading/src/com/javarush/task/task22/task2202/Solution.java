package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));

       System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
        System.out.println(getPartOfString(null));
    }

    public static String getPartOfString(String string) {

        String origString = string;
        String result = "";

        int indexStart=0;//индекс первого искомого символа
        int indexEnd=0;//индекс последнего искомого символа
        int currentIndex=0; //индекс первого искомого символа в текущей подстроке
        int commonIndex=0; //индекс искомого символа в общей строке (накопительное суммирование)


        try {
            for (int i = 0; i < 5; i++) {
                currentIndex = origString.indexOf(" ");
                if (currentIndex == -1) {
                    commonIndex = commonIndex + origString.length();
                }//если больше нет пробелов - добавляем длину оставшейся строки
                else {
                    commonIndex = commonIndex + currentIndex;
                }

                if (i == 0) {
                    indexStart = commonIndex+1;
                }
                if (i == 4) {
                    indexEnd = commonIndex + i;
                }
                //отрезаем до первого пробела включительно
                origString = origString.substring(currentIndex + 1 );

            }
            result = (string.substring(indexStart, indexEnd));
        }
        catch (StringIndexOutOfBoundsException e){
            throw new TooShortStringException();
        }
        catch (NullPointerException e){
            throw new TooShortStringException();
        }

        return result = (string.substring(indexStart, indexEnd));
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
