package com.company;

public class Main {

    public static void main(String[] args) {
        if (args.length != 2) {
            return;
        }
        Downloader d = new Downloader(args[0], args[1]);
        d.downloadFiles();
        d.getStatisticsInfo();
    }
}
