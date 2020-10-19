package com.company;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void firstTask() {
        List<String> strings = new ArrayList<>();
        strings.add("Apple — американская корпорация, производитель персональных и планшетных компьютеров, аудиоплееров, смартфонов, программного обеспечения. Один из пионеров в области персональных компьютеров и современных многозадачных операционных систем с графическим интерфейсом.");
        strings.add("Штаб-квартира — в Купертино, штат Калифорния. Благодаря инновационным технологиям и эстетичному дизайну, корпорация Apple создала в индустрии потребительской электроники уникальную репутацию, сравнимую с культом. Является первой американской компанией, чья капитализация превысила 1,044 трлн долларов США. Это произошло во время торгов акциями компании 10 сентября 2018 года.");
        strings.add("В тот же день компания стала самой дорогой публичной компанией за всю историю, превысив капитализацию предыдущего рекордсмена — компании PetroChina.");
        int max = strings.get(0).length();
        int result = 0;
        for(int i = 0; i < strings.size(); i++){
            if(max < strings.get(i).length()){
                max = strings.get(i).length();
                result = i;
            }
        }
        System.out.println(strings.get(result));
    }

    public static void secondTask() {
        System.out.println(isPalindrom("олени^^,,,,синело"));
    }

    public static boolean isPalindrom(String words){
        String[] s = words.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        if (s == null) {
            return false;
        }

        int i = 0, j = s.length - 1;
        while(i < j) {
            if(s[i++] != s[j--]) {
                return false;
            }
        }
        return true;
    }

    public static void thirdTask() {
        String source = "Если получилась бяка, то это твоя бяка.";
        source = source.replaceAll("бяка", "[вырезано цензурой]");
        System.out.println(source);
    }

    public static int getCount(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }

    public static void fourthTask() {
        String str1 = "Привет, как дела, что делаешь, пойдем погуляем?";
        String str2 = ",";
        System.out.println(getCount(str1, str2));
    }

    public static void fifthTask() {
        String string = "This is a test string";
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = string.split(" ");

        for (int j = words.length-1; j >= 0; j--) {
            stringBuilder.append(words[j]).append(' ');
        }
        String reverse = new StringBuffer(stringBuilder).reverse().toString();
        System.out.println(reverse);
    }

    public static void printFrequencyDictionary(String fileName) {
        try {
            String text = Files.readString(Paths.get(fileName)).toLowerCase();
            HashMap<Character, Integer> rateMap = new HashMap<>();
            for (int i = 0; i < text.length(); i++) {
                char ch = text.charAt(i);
                if (ch > 'а' && ch < 'я') {
                    Integer rate = rateMap.get(ch);
                    if (rate == null)
                        rate = 0;
                    rate++;
                    rateMap.put(ch, rate);
                }
            }
            rateMap.entrySet().stream()
                    .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                    .forEach(System.out::println);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void sixthTask() {
        printFrequencyDictionary("text.txt");
    }

    public static void main(String[] args) {
        firstTask();
        secondTask();
        thirdTask();
        fourthTask();
        fifthTask();
        sixthTask();
    }
}
