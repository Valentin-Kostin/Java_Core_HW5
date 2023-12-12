package ru.gb.HW5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CopyFile {
    public static void main(String[] args) throws IOException {

        String dir = "./backup";
        Files.createDirectories(Paths.get(dir));
        List<String> list = searchFile(new File("."));
        for (String s : list){
            copyFile(s,dir);
        }
    }


    static List<String> searchFile(File dir) throws IOException {
        List<String> list = new ArrayList<>();
        File[] files = dir.listFiles();
        if (files == null)
            return list;
        for (int i = 0; i < files.length; i++){
            if (files[i].isFile()){
                list.add(String.valueOf(files[i]));
            }
        }
        return list;
    }
    static void copyFile (String fileIn, String dir) throws IOException {
        // На запись

        try (FileOutputStream fileOutputStream = new FileOutputStream(dir+"\\"+fileIn)) {
            int c;
            // На чтение
            try (FileInputStream fileInputStream = new FileInputStream(fileIn)) {
                while ((c = fileInputStream.read()) != -1) {
                    fileOutputStream.write(c);
                }
            }
        }
    }
}
