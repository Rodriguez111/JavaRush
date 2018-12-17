package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

   //private FileInputStream   fis;

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);

if(!fileName.substring(fileName.lastIndexOf(".")+1).equals("txt")){

    super.close();
    throw new UnsupportedFileNameException();

}



    }

    public static void main(String[] args) throws IOException, UnsupportedFileNameException {
        TxtInputStream t = new TxtInputStream("d:/1.mp4");

    }
}

