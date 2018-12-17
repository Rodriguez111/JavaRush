package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        //detectAllWords(crossword, "home", "same");

        System.out.println(detectAllWords(crossword, "home", "same"));


        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> resultList = new ArrayList<>();

       int countOfWords = words.length;//определяем количество переданных слов
        for(int i=0;i<countOfWords;i++){
         String currentWord = words[i] ;
         char word[]=currentWord.toCharArray();//раскладываем слово на буквы

              for(int y=0;y<crossword.length;y++){
                  for(int x=0;x<crossword[y].length;x++) {
                    if(word[0]==(char)crossword[y][x]){//если найдена первая буква
                        boolean[] vector =vector(word.length,crossword,y,x); //ищем направление слова
                        for(int i2=0;i2<vector.length;i2++){

                            if(vector[i2]==true){

                                int lettersToAdd = word.length-1;//сколько осталось букв
                                boolean wordIsFound=true;//флаг,показывающий,что найдено все слово
                                switch (i2){
                                    case 0:
                                      for(int i3=1;i3<=lettersToAdd;i3++){//если вторая буква совпадает,прибавляем следующую, и так до конца. Если нет - выходим
                                          if(word[0+i3]!=(char)crossword[y-i3][x]){wordIsFound=false;break;}
                                      }
                                      if(wordIsFound){
                                          Word w = new Word(currentWord);
                                          w.startY=y;
                                          w.startX=x;
                                          w.endY=y-lettersToAdd;
                                          w.endX=x;
                                          resultList.add(w);
                                      } break;
                                    case 1:
                                        for(int i3=1;i3<=lettersToAdd;i3++){
                                            if(word[0+i3]!=(char)crossword[y-i3][x+i3]){wordIsFound=false;break;}
                                        }
                                        if(wordIsFound){
                                            Word w = new Word(currentWord);
                                            w.startY=y;
                                            w.startX=x;
                                            w.endY=y-lettersToAdd;
                                            w.endX=x+lettersToAdd;
                                            resultList.add(w);
                                        } break;
                                    case 2:
                                        for(int i3=1;i3<=lettersToAdd;i3++){
                                            if(word[0+i3]!=(char)crossword[y][x+i3]){wordIsFound=false;break;}
                                        }
                                        if(wordIsFound){
                                            Word w = new Word(currentWord);
                                            w.startY=y;
                                            w.startX=x;
                                            w.endY=y;
                                            w.endX=x+lettersToAdd;
                                            resultList.add(w);
                                        } break;
                                    case 3:
                                        for(int i3=1;i3<=lettersToAdd;i3++){
                                            if(word[0+i3]!=(char)crossword[y+i3][x+i3]){wordIsFound=false;break;}
                                        }
                                        if(wordIsFound){
                                            Word w = new Word(currentWord);
                                            w.startY=y;
                                            w.startX=x;
                                            w.endY=y+lettersToAdd;
                                            w.endX=x+lettersToAdd;
                                            resultList.add(w);
                                        } break;
                                    case 4:
                                        for(int i3=1;i3<=lettersToAdd;i3++){
                                            if(word[0+i3]!=(char)crossword[y+i3][x]){wordIsFound=false;break;}
                                        }
                                        if(wordIsFound){
                                            Word w = new Word(currentWord);
                                            w.startY=y;
                                            w.startX=x;
                                            w.endY=y+lettersToAdd;
                                            w.endX=x;
                                            resultList.add(w);
                                        } break;
                                    case 5:
                                        for(int i3=1;i3<=lettersToAdd;i3++){
                                            if(word[0+i3]!=(char)crossword[y+i3][x-i3]){wordIsFound=false;break;}
                                        }
                                        if(wordIsFound){
                                            Word w = new Word(currentWord);
                                            w.startY=y;
                                            w.startX=x;
                                            w.endY=y+lettersToAdd;
                                            w.endX=x-lettersToAdd;
                                            resultList.add(w);
                                        } break;
                                    case 6:
                                        for(int i3=1;i3<=lettersToAdd;i3++){
                                            if(word[0+i3]!=(char)crossword[y][x-i3]){wordIsFound=false;break;}
                                        }
                                        if(wordIsFound){
                                            Word w = new Word(currentWord);
                                            w.startY=y;
                                            w.startX=x;
                                            w.endY=y;
                                            w.endX=x-lettersToAdd;
                                            resultList.add(w);
                                        } break;
                                    case 7:
                                        for(int i3=1;i3<=lettersToAdd;i3++){
                                            if(word[0+i3]!=(char)crossword[y-i3][x-i3]){wordIsFound=false;break;}
                                        }
                                        if(wordIsFound){
                                            Word w = new Word(currentWord);
                                            w.startY=y;
                                            w.startX=x;
                                            w.endY=y-lettersToAdd;
                                            w.endX=x-lettersToAdd;
                                            resultList.add(w);
                                        } break;
                                }
                            }
                        }
                    }
                  }
              }
        }

        return resultList;
    }

    private static boolean[] vector (int wordLength, int[][] crossword, int x, int y){
        /*Метод возвращает массив флагов - возможные направления поиска слова,
        если оно вмещается в это направление по длине.
        * нулевой флаг - вектор на север
        * первый флаг - северо-восток
        * и т. д. по часовой стрелке
        * */
        //vector[0]- north;
        //vector[1]- northEast;
        //vector[2]- east;
        //vector[3]- southEast;
        //vector[4]- south;
        //vector[5]- southWest;
        //vector[6]- west;
        //vector[7]- northWest;
        boolean[] vector = new boolean[8];

        try{//поиск вмещается ли слово на север
            int c= crossword[x-(wordLength-1)][y];
            vector[0]=true;

        }catch (ArrayIndexOutOfBoundsException e){
            vector[0]=false;
        }

        try{ //поиск вмещается ли слово на северо-восток
            int c= crossword[x-(wordLength-1)][y+(wordLength-1)];
            vector[1]=true;

        }catch (ArrayIndexOutOfBoundsException e){
            vector[1]=false;
        }

        try{ //поиск вмещается ли слово на восток
            int c= crossword[x][y+(wordLength-1)];
            vector[2]=true;

        }catch (ArrayIndexOutOfBoundsException e){
            vector[2]=false;
        }

        try{ //поиск вмещается ли слово на юго-восток
            int c= crossword[x+(wordLength-1)][y+(wordLength-1)];
            vector[3]=true;

        }catch (ArrayIndexOutOfBoundsException e){
            vector[3]=false;
        }
        try{ //поиск вмещается ли слово на юг
            int c= crossword[x+(wordLength-1)][y];
            vector[4]=true;

        }catch (ArrayIndexOutOfBoundsException e){
            vector[4]=false;
        }

        try{ //поиск вмещается ли слово на юго-запад
            int c= crossword[x+(wordLength-1)][y-(wordLength-1)];
            vector[5]=true;

        }catch (ArrayIndexOutOfBoundsException e){
            vector[5]=false;
        }

        try{ //поиск вмещается ли слово на запад
            int c= crossword[x][y-(wordLength-1)];
            vector[6]=true;

        }catch (ArrayIndexOutOfBoundsException e){
            vector[6]=false;
        }

        try{ //поиск вмещается ли слово на северо-запад
            int c= crossword[x-(wordLength-1)][y-(wordLength-1)];
            vector[7]=true;

        }catch (ArrayIndexOutOfBoundsException e){
            vector[7]=false;
        }
        return vector;
    }



    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}