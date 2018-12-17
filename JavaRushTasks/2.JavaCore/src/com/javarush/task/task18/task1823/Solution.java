package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            String fileName = br.readLine();
            if(fileName.equals("exit")){
                br.close();
                break;
            }
            new ReadThread(fileName).start();
        }

    }

    public static class ReadThread extends Thread {
        private FileInputStream fis;
        private String fileName;
        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            this.fis = new FileInputStream(fileName);
            this.fileName=fileName;
            run();

        }
        // implement file reading here - реализуйте чтение из файла тут


        @Override
        public void run() {

            List bytes = new ArrayList();
            Map map = new HashMap();
            try {
                while (fis.available()>0){
                bytes.add(fis.read())  ;
                 }
                fis.close();
            } catch (IOException e) {
                /*NOP*/
            }
            int howManyTimes=1;
            for(int i=0;i<bytes.size();i++){

                for(int j=i+1;j<bytes.size();j++){
                    if(bytes.get(i).equals(bytes.get(j))){
                        howManyTimes++;
                        bytes.remove(j);
                        j--;
                    }

                }

                map.put(bytes.get(i), howManyTimes);
                howManyTimes=1;

            }

            //----------
            Iterator entries = map.entrySet().iterator();
            int max=0;

            while (entries.hasNext()) {

                Map.Entry entry = (Map.Entry) entries.next();
                if((int)entry.getValue()>max){max=(int)entry.getValue();};
            }
            entries=null;
            entries = map.entrySet().iterator();

            while (entries.hasNext()) {
                Map.Entry entry = (Map.Entry) entries.next();
                if((int)entry.getValue()==max){

                   synchronized (resultMap) {
                       resultMap.put(fileName, (int) entry.getKey());
                   }
                }
            }

            //------------



        }
    }
}
