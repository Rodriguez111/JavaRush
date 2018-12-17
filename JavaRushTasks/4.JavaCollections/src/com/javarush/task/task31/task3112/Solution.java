package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL url = new URL(urlString); //получаем URL из строки

        InputStream inputStream = url.openStream(); //создаем входящий поток из URL
        Path tempFile = Files.createTempFile("temp-",".tmp"); //создаем временный файл

        Files.copy(inputStream, tempFile, REPLACE_EXISTING); //копируем из потока во временный файл


        if(!Files.exists(downloadDirectory)){ //проверяем не существует ли конечная папка
            Files.createDirectory(downloadDirectory); //создаем конечную директорию
        }

        String fileName = url.getFile().substring(url.getFile().lastIndexOf("/")+1); //получаем имя файла

        Path destinationPath = Paths.get(downloadDirectory.toString()+"/"+fileName.toString());

        return  Files.move(tempFile, destinationPath, REPLACE_EXISTING);

    }
}
