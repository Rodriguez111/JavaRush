package com.javarush.task.task14.task1414;
/*
MovieFactory
*/
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        Movie movie = null;
        while(true){
             String key = scan.nextLine();
            movie= MovieFactory.getMovie(key);
            if(!key.equals("thriller") && !key.equals("cartoon")&& !key.equals("soapOpera"))break;
            System.out.println(movie.getClass().getSimpleName());
        }

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }

            if ("cartoon".equals(key)){
                movie=new Cartoon();
            }

            if ("thriller".equals(key)){
                movie=new Thriller();
            }

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie{

    }
    static class Thriller extends Movie{

    }

}
