package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1=br.readLine();
        String fileName2=br.readLine();
        String fileName3=br.readLine();

        br.close();

        FileInputStream finp2 = new FileInputStream(fileName2);
        FileInputStream finp3 = new FileInputStream(fileName3);
        FileOutputStream fout1 = new FileOutputStream(fileName1,true);//аргумент true позволяет добавлять в конец (append), а не перезаписывать содержимое

while (finp2.available()>0){
    fout1.write(finp2.read());
}
while (finp3.available()>0){
    fout1.write(finp3.read());
}
        fout1.close();
        finp2.close();
        finp3.close();

    }
}
