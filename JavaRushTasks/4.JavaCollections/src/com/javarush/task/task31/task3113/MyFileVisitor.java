package com.javarush.task.task31.task3113;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class MyFileVisitor extends SimpleFileVisitor<Path> {

   private int countOfDirs = -1;
   private int countOfFiles = 0;
   private long totalSize = 0;

    public int getCountOfDirs() {
        return countOfDirs;
    }

    public int getCountOfFiles() {
        return countOfFiles;
    }

    public long getTotalSize() {
        return totalSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

                if(Files.isRegularFile(file)){
                  countOfFiles++;
                    totalSize = totalSize+Files.size(file);
                }
        return super.visitFile(file, attrs);
    }


    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        if(Files.isDirectory(dir)){
            countOfDirs++;
        }
        return super.preVisitDirectory(dir, attrs);
    }
}
