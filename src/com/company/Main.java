package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {


        String maindir = "D://JavaGames";
        String[] dirs = {"src", "res", "savegames", "temp"};      //1. В папке JavaGames создайте несколько директорий: src, res, savegames, temp.
        for (String dir : dirs) makeDir(maindir, dir);

        String[] src = {"main", "test"};                            //2. В каталоге src создайте две директории: main, test.
        for (String dir : src) makeDir(maindir + "/src", dir);

        String[] main = {"Main.java", "Utils.java"};              //3.В подкаталоге main создайте два файла: Main.java, Utils.java.
        for (String filename : main) makeFile(maindir + "/src/main", filename);

        String[] res = {"drawables", "vectors", "icons"};         //4. В каталог res создайте три директории: drawables, vectors, icons.
        for (String dir : res) makeDir(maindir + "/res", dir);

        String[] temp = {"temp.txt"};                           //5.В директории temp создайте файл temp.txt.
        for (String filename : temp) makeFile(maindir + "/temp", filename);

        writeToFile(sb, maindir + "/temp/temp.txt");

    }


    private static void makeDir(String maindir, String dir) {
        File dir2 = new File(maindir, dir);
        if (dir2.mkdir()) {

            sb.append("В папке " + maindir + " был создан каталог " + dir);

        } else {
            sb.append("В папке " + maindir + " не был создан каталог " + dir);
        }
    }

    private static void makeFile(String dir, String filename) {
        File myFile = new File(dir, filename);

        try {
            if (myFile.createNewFile())

                sb.append("В директории " + dir + " был создан Файл " + filename);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            sb.append("В директории " + dir + " не был создан Файл " + filename + " : exception " + ex.getMessage());
        }
    }


    private static void writeToFile(StringBuilder sb, String filename) {
        String text = sb.toString();
        try (FileWriter writer = new FileWriter(filename, false)) {
            writer.write(text);
            writer.append('\n');
            writer.append('!');
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
