package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Downloader {
    private String dir;
    private String file;
    private Map<String, String> links;
    private List<Thread> threads;
    private Statistics statistics;


    public Downloader(String dir, String file) {
        this.dir = dir;
        this.file = file;
        this.links = new HashMap<>();
        this.threads = new ArrayList<>();
        this.statistics = new Statistics();

        isDirExists();
        putValuesToLinks();
    }

    private void isDirExists() {
        File dir = new File(this.dir);
        dir.mkdirs();
    }

    private void putValuesToLinks() {
        try(BufferedReader file = Files.newBufferedReader(Paths.get(this.file))) {
            String str;
            while((str = file.readLine()) != null) {
                String[] values = str.split(" "); // values[0] - ссылка; values[1] - файл
                links.put(values[0], values[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getStatisticsInfo() {
        DecimalFormat df = new DecimalFormat("###.###");
        Duration d = Duration.ofMillis(statistics.getTimes());
        double speed = (this.statistics.getSize() * 1000) / (double)(this.statistics.getTimes() / 1000);

        System.out.println("Загружено: " + links.size() + " файлов, " + df.format(this.statistics.getSize()) + " MB");
        System.out.println("Время: " + d.toMinutesPart() + " мин. " + d.toSecondsPart() +" сек.");
        System.out.printf("Средняя скорость: %.1f kB/s", speed);
    }

    public void downloadFiles() {
        for(Map.Entry<String, String> entry : links.entrySet()) {
            Thread thread = new Thread(statistics);
            thread.setLink(entry.getKey());
            thread.setFile(this.dir + "/" + entry.getValue());
            threads.add(thread);
            thread.start();
        }

        while(!threads.isEmpty()){
            for(Thread thread : threads) {
                if(!thread.isAlive()) {
                    threads.remove(thread);
                    break;
                }
            }
        }
    }
}
