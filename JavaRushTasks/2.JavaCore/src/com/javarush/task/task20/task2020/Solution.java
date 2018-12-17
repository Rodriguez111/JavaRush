package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.logging.Logger;

/* 
Сериализация человека
*/
public class Solution {

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }


        private void readObject(ObjectInputStream ois)
                throws IOException, ClassNotFoundException {
            ois.defaultReadObject();
            //nameA = (String)ois.readObject();
            //nameB = (String)ois.readObject();
            this.fullName = String.format("%s, %s", lastName, firstName);
            //this.greetingString = "Hello, ";

        }





    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws FileNotFoundException {

        Person p1 = new Person("Иван", "Петров", "США", Sex.MALE);
        System.out.println( p1.firstName+" "+p1.lastName+" "+p1.fullName+" "+p1.greetingString+" "+p1.country+" "+p1.sex);
        System.out.println(p1.outputStream);
        System.out.println(p1.logger);


        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.bin"));
            oos.writeObject(p1);


            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file.bin"));
            Person newPers = (Person)ois.readObject();





            System.out.println( newPers.firstName+" "+newPers.lastName+" "+newPers.fullName+" "+newPers.greetingString+" "+newPers.country+" "+newPers.sex);
            System.out.println(newPers.outputStream);
            System.out.println(newPers.logger);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
