package com.javarush.task.task31.task3106;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {


        List<String> listOfFiles = new ArrayList<>();
        for(int i = 1; i< args.length; i++){
            listOfFiles.add(args[i]);
        }

        Collections.sort(listOfFiles);

        List<InputStream>  listOfStreams = new ArrayList<>();


        for(int i = 0; i< listOfFiles.size(); i++){
            listOfStreams.add(new FileInputStream(listOfFiles.get(i)));
            }



        Enumeration<InputStream> partsOfArchive = Collections.enumeration(listOfStreams);

        SequenceInputStream sequenceInputStream = new SequenceInputStream(partsOfArchive);

        ZipInputStream zipInputStream = new ZipInputStream(sequenceInputStream);
        OutputStream outputStream = Files.newOutputStream(Paths.get(args[0]));



                ZipEntry zipEntry = null;
                while((zipEntry = zipInputStream.getNextEntry()) != null ){

                    write(zipInputStream, outputStream);
                }

        zipInputStream.close();
        outputStream.close();



    }

    private static void write(InputStream in, OutputStream out) throws IOException {

        byte[] buffer = new byte[8 * 1024];
        int len;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }

    }


}
