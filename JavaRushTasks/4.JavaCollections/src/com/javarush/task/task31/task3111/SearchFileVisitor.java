package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }


    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        String contentText = new String(content); //переводим байты в текст

        boolean containsName = true;
        boolean containsPart = true;
        boolean minSizeFit = true;
        boolean maxSizeFit = true;


        if(partOfName != null && !file.getFileName().toString().contains(partOfName)){ //если задан поиск по имени и это имя НЕ содержится в имени файла
            containsName = false;
        }
        if(minSize >0 && content.length < minSize){ //если задан поиск по минимальному размеру и размер файла меньше
            minSizeFit = false;
        }
        if(maxSize >0 && content.length > maxSize){ //если задан поиск по макс. размеру и размер файла больше
            maxSizeFit = false;
        }

        if(partOfContent != null && !contentText.contains(partOfContent)){ //если задан поиск по содержимому, и его нет в теле файла
            containsPart = false;
        }

        if(containsName && containsPart && minSizeFit && maxSizeFit){
            foundFiles.add(file);
        }


        return super.visitFile(file, attrs);
    }
}
