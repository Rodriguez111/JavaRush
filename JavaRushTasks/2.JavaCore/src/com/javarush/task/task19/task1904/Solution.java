package com.javarush.task.task19.task1904;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/*
И еще один адаптер
*/
public class Solution {

    public static void main(String[] args) throws IOException {

        PersonScannerAdapter psa = new PersonScannerAdapter(new Scanner(new FileInputStream("D:\\Java\\Files\\1.txt"),"UTF-8")) ;


    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner=fileScanner;

        }

        @Override
        public Person read() throws IOException, ParseException {

            String line;//вся строка
            String firstName;
            String middleName;
            String lastName;
            Date birthDate;
            while (fileScanner.hasNextLine()){//построчное чтение файла
                line=fileScanner.nextLine();
                lastName=line.substring(0,line.indexOf(" "));
                String WithoutLastName = line.substring(line.indexOf(" ")+1);
                firstName=WithoutLastName.substring(0, WithoutLastName.indexOf(" "));
                String WithoutFirstName =WithoutLastName.substring(WithoutLastName.indexOf(" ")+1);
                middleName=WithoutFirstName.substring(0, WithoutFirstName.indexOf(" "));
                String stringBirthDate= WithoutFirstName.substring(WithoutFirstName.indexOf(" ")+1);
                SimpleDateFormat dateInput = new SimpleDateFormat("dd MM yyyy");
                birthDate=dateInput.parse(stringBirthDate);

                return new Person(firstName, middleName, lastName, birthDate);

            }


return null;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();

        }
    }
}
