package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут



        SimpleDateFormat dateInput = new SimpleDateFormat("dd/MM/yyyy"); //формат ввода даты
        SimpleDateFormat dateOutput = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);//формат вывода даты
        Date convertedInputDate = new Date();


//--------------------------------------------------------------
 switch (args[0]) {

      case("-c"): synchronized (allPeople){ //обрабатываем аргумент -c


          for (int i = 1; i < args.length; i += 3) {


              try {
                  convertedInputDate = dateInput.parse(args[i + 2]);//конвертируем переданный строковый аргумент в дату
              } catch (ParseException e) {
                  e.printStackTrace();
              }


              if (args[i + 1].equals("м")) {
                  allPeople.add(Person.createMale(args[i], convertedInputDate));
              } else {
                  allPeople.add(Person.createFemale(args[i], convertedInputDate));
              }

              System.out.println(allPeople.size() - 1); //выводим индекс добавленного элемента на экран
          }
      }
      break;
//--------------------------------------------------------------
      case("-u"): synchronized (allPeople){ //обрабатываем аргумент -u

          for (int i = 1; i < args.length; i += 4) {

              try {
                  convertedInputDate = dateInput.parse(args[i + 3]);//конвертируем переданный строковый аргумент в дату
              } catch (ParseException e) {
                  e.printStackTrace();
              }

              allPeople.remove(Integer.parseInt(args[i]));
              if (args[i + 2].equals("м")) {
                  allPeople.add(Integer.parseInt(args[i]), Person.createMale(args[i + 1], convertedInputDate));
              } else {
                  allPeople.add(Integer.parseInt(args[i]), Person.createFemale(args[i + 1], convertedInputDate));
              }

          }

      }
      break;
      //--------------------------------------------------------------

      case("-d"): synchronized (allPeople){//обрабатываем аргумент -d
          for (int i = 1; i < args.length; i++) {
              allPeople.get(Integer.parseInt(args[i])).setName(null);
              allPeople.get(Integer.parseInt(args[i])).setSex(null);
              allPeople.get(Integer.parseInt(args[i])).setBirthDay(null);
          }
      }
      break;
//-----------------------------------------------------------------------
      case("-i"): synchronized (allPeople){//обрабатываем аргумент -i
          for (int i = 1; i < args.length; i++) {
              String sex = "";

              if (allPeople.get(Integer.parseInt(args[i])).getSex().equals(Sex.MALE)) {
                  sex = "м";
              }
              if (allPeople.get(Integer.parseInt(args[i])).getSex().equals(Sex.FEMALE)) {
                  sex = "ж";
              }
              System.out.println(allPeople.get(Integer.parseInt(args[i])).getName() + " " + sex + " " +
                      dateOutput.format(allPeople.get(Integer.parseInt(args[i])).getBirthDay()));

          }
      }
      break;

  }

    }
}
