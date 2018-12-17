package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


/* 
Добавление файла в архив
*/
public class Solution {


    public static void main(String[] args) throws IOException {

        Path source =  Paths.get(args[0]); //файл, который надо добавить в архив

        Path destination = Paths.get(args[1]); //файл архива

        String fileName = args[0].substring(args[0].lastIndexOf("\\")+1); //получаем имя файла из пути
        String pathOfNewFileInArchive = "new/"+fileName; //составл\яем относительный путь файла в архиве(должен быть помещен в папку new)


        List<String> names = new ArrayList<>(); //список имен файлов из архива
        List<ByteArrayOutputStream> streams = new ArrayList<>(); //список потоков для каждого файла

//По условию нужно не использовать файловую систему, поэтому читаем архив и помещаем файлы архива не во временную папку на диске,
// а каждый файл помещаем в какой-то выходной поток ByteArrayOutputStream

        ByteArrayOutputStream byteArrayOutputStream;


        ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(destination)); //читаем исходный архив

        ZipEntry zipEntry = null;
        while ((zipEntry = zipInputStream.getNextEntry()) != null){

            String filename = zipEntry.getName();  //получаем относительный путь файлов в архиве
            if(filename.equals(pathOfNewFileInArchive)){continue;} //если файл с таким именем и по такому пути уже есть в архиве - пропускаем его, чтобы потом записать новый
            byteArrayOutputStream = new ByteArrayOutputStream(); //создаем выходной поток

            write(zipInputStream, byteArrayOutputStream); //записываем прочитанный файл из архива в выходной поток
            names.add(filename); //добавляем имя файла в список имен
            streams.add(byteArrayOutputStream);  //добавляем выходной поток список потоков

        }


//создаем выходной поток для записи в конечный файл архива:
        ZipOutputStream zipOutputStreamForNewFile = new ZipOutputStream(new FileOutputStream(args[1]));


        ZipEntry zipEntryForNewFile = new ZipEntry(pathOfNewFileInArchive); //создаем ZipEntry, который описывает вновь добавляемый файл
        zipOutputStreamForNewFile.putNextEntry(zipEntryForNewFile); //отправляем ZipEntry в выходной поток архива

        Files.copy(source, zipOutputStreamForNewFile); //копируем сам файл (source) в выходной поток (вместо побайтного копирования методом write)



       for (int i = 0; i<names.size(); i++){

           ZipEntry entry = new ZipEntry(names.get(i));
           zipOutputStreamForNewFile.putNextEntry(entry);

           zipOutputStreamForNewFile.write(streams.get(i).toByteArray()); //копируем в этот же поток файлы из исходного архива

       }

        zipInputStream.close(); //закрываем поток
        zipOutputStreamForNewFile.close(); //закрываем поток

    }


    private static void write(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) >= 0)
            out.write(buffer, 0, len);
    }
}


