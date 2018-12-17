package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут

   static {
       Scanner scan = new Scanner(System.in);
       firstFileName = scan.nextLine();
       secondFileName = scan.nextLine();
   }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();

        System.out.println(f.getFileContent());

    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут

    public static class ReadFileThread extends Thread implements ReadFileInterface  {
       private String fileName;
       private String fileContent="";



        @Override
        public void setFileName(String fullFileName) {
            this.fileName=fullFileName;
        }

        @Override
        public void start() {
            run();

        }

        @Override
        public void run() {


            String line="";



            FileInputStream inStream = null;
            try {
                inStream = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(inStream));

            try {
                while ((line =br.readLine())!=null){
                    fileContent=fileContent+line+" ";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            try {
                inStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }



        }

        @Override
        public String getFileContent() {

            return  fileContent;
        }


    }
}
