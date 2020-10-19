package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static List<String> search(String directory, Function<File, Boolean> function){
        List<String> list = new ArrayList<>();
        File dir = new File(directory);
        File[] files = dir.listFiles();
        if (files != null){
            for (File f: files){
                if (!f.isDirectory() && function.apply(f))
                    list.add(f.getName());
            }
        }
        return list;
    }

    public static List<String> searchFilesByContent(String directory, String content){
        List<String> list = new ArrayList<>();
        File dir = new File(directory);
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory())
                    return false;
                boolean contains = false;
                try {
                    FileReader fileReader = new FileReader(pathname);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    while(bufferedReader.ready()){
                        String line = bufferedReader.readLine();
                        contains = line.contains(content);
                        if (contains)
                            break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return contains;
            }
        };
        File[] files = dir.listFiles(fileFilter);
        if (files != null) {
            for (File f : files) {
                list.add(f.getName());
            }
        }
        return list;
    }

    public static List<String> searchFilesByName(String directory, String substring){
        List<String> list = new ArrayList<>();
        File dir = new File(directory);
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return !pathname.isDirectory() && pathname.getName().contains(substring);
            }
        };
        File[] files = dir.listFiles(fileFilter);
        if (files != null) {
            for (File f : files) {
                list.add(f.getName());
            }
        }
        return list;
    }

    public static boolean copyFile(String source, String destination){
        try {
            FileInputStream input = new FileInputStream(source);
            FileOutputStream output = new FileOutputStream(destination);
            while(input.available() > 0){
                output.write(input.read());
            }
            input.close();
            output.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public static boolean combineText(String firstFile, String secondFile, String resultFile){
        List<String> text1 = readAll(firstFile);
        List<String> text2 = readAll(secondFile);
        if (text1 == null || text2 == null)
            return false;
        text1.addAll(text2);
        for (int i = 0; i < text1.size(); i++){
            if (!writeAll(resultFile, text1.get(i) + (i != text1.size()-1 ? "\n" : ""), i != 0)){
                return false;
            }
        }
        return true;
    }

    public static boolean writeAll(String filePath, String text, boolean append){
        try {
            FileWriter writer = new FileWriter(filePath, append);
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public static List<String> readAll(String filePath){
        List<String> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while(bufferedReader.ready())
                list.add(bufferedReader.readLine());
            bufferedReader.close();
            fileReader.close();
        } catch(IOException ex){
            return null;
        }
        return list;
    }

    public static void main(String[] args){
        List<String> text = readAll("text.txt"); //1
        if (text != null) {
            System.out.println(text.size());
            System.out.println(text);
        }
        System.out.println(writeAll("text_2.txt", "Hello", false)); //2
        System.out.println(writeAll("text_2.txt", "|World", true));
        System.out.println(combineText("text.txt", "text_2.txt", "mix.txt")); //3
        System.out.println(copyFile("mix.txt", "mix_copy.txt")); //4
        System.out.println(searchFilesByName(".", "text")); //5
        System.out.println(searchFilesByContent(".", "World")); //6
        Function<File, Boolean> function = file -> file.length() < 1024; //7
        System.out.println(search(".", function));
    }
}
