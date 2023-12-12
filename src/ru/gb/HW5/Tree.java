package ru.gb.HW5;

import java.io.File;

/**
 * TODO: Доработать метод print, необходимо распечатывать директории и файлы
 */
public class Tree {

    public static void main(String[] args) {
        print(new File("."), "", true);
    }

    static void print(File file, String indent, boolean isLast){
        System.out.print(indent);
        if (isLast){
            System.out.print("└─");
            indent += "  ";
        }
        else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());


        File[] files = file.listFiles(File::isDirectory);
        File[] filesF = file.listFiles(File::isFile);
        if (files == null)
            return;

        int subDirTotal = 0;
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory())
                subDirTotal++;
        }

        int subFileTotal = 0;
        for (int i = 0; i < filesF.length; i++){
            if (filesF[i].isFile())
                subFileTotal++;

        }

        int subDirCounter = 0;
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory()){
                print(files[i], indent, subDirTotal == ++subDirCounter);

            }
        }
        int subFileCounter = 0;
        for (int i = 0; i < filesF.length; i++) {
            if (filesF[i].isFile()) {
                print(filesF[i], indent, subFileTotal == ++subFileCounter);
            }
        }
    }

}