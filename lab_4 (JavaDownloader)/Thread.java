package com.company;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;

public class Thread extends java.lang.Thread {
    private String link;
    private String file;
    private final Statistics statistics;

    public Thread(Statistics statistics) {
        this.statistics = statistics;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public void run() {
        super.run();
        synchronized (Thread.class)
        {
            System.out.println("Загружается файл: " + this.file);
            long elapsedTime = System.currentTimeMillis();
            try (BufferedInputStream bis = new BufferedInputStream(new URL(this.link).openStream()); BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(this.file))) {
                int result = bis.read();
                while(result != -1) {
                    bos.write(result);
                    result = bis.read();
                }
                elapsedTime = System.currentTimeMillis() - elapsedTime;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            this.statistics.addTimes(elapsedTime);
            try {
                DecimalFormat df = new DecimalFormat("###.###");
                double mBytes = (double) Files.size(Paths.get(this.file)) / 1048576;
                this.statistics.addSize(mBytes);
                System.out.println("Файл " + this.file + " загружен: " + df.format(mBytes) + " MB за " + elapsedTime + " миллисек.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
