package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        SimpleDateFormat dateInput = new SimpleDateFormat("dd/MM/yyyy"); //формат ввода даты
        SimpleDateFormat dateOutput = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);//формат вывода даты
        Date convertedInputDate = new Date();


//--------------------------------------------------------------
        if (args[0].equals("-c")){ //обрабатываем аргумент -c

            try {
                convertedInputDate=dateInput.parse(args[3]);//конвертируем переданный строковый аргумент в дату
            } catch (ParseException e) {
                e.printStackTrace();
            }


            if(args[2].equals("м")){
                allPeople.add(Person.createMale(args[1], convertedInputDate));
            }
            else {allPeople.add(Person.createFemale(args[1], convertedInputDate));}

            System.out.println(allPeople.size()-1); //выводим индекс добавленного элемента на экран
        }
//--------------------------------------------------------------
        if (args[0].equals("-u")){//обрабатываем аргумент -u

            try {
                convertedInputDate=dateInput.parse(args[4]);//конвертируем переданный строковый аргумент в дату
            } catch (ParseException e) {
                e.printStackTrace();
            }

            allPeople.remove(Integer.parseInt(args[1]));
            if(args[3].equals("м")){
                allPeople.add(Integer.parseInt(args[1]),Person.createMale(args[2], convertedInputDate));
            }
            else {allPeople.add(Integer.parseInt(args[1]),Person.createFemale(args[2], convertedInputDate));}

      }
//-----------------------------------------------------------------------

        if (args[0].equals("-d")){//обрабатываем аргумент -d

            allPeople.get(Integer.parseInt(args[1])).setName(null);
            allPeople.get(Integer.parseInt(args[1])).setSex(null);
            allPeople.get(Integer.parseInt(args[1])).setBirthDay(null);

        }
//-----------------------------------------------------------------------
        if (args[0].equals("-i")){//обрабатываем аргумент -i
            String sex="";


                if (allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.MALE)){sex="м";}
                if (allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.FEMALE)){sex="ж";}
                System.out.println(allPeople.get(Integer.parseInt(args[1])).getName()+" "+sex+" "+
                        dateOutput.format(allPeople.get(Integer.parseInt(args[1])).getBirthDay()));


        }

        }

}
