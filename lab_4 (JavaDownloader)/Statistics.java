package com.company;

public class Statistics {
    private double size;
    private long elapsedTime;

    public Statistics() {
        this.elapsedTime = 0;
        this.size = 0;
    }

    public void addSize(double size) {
        this.size += size;
    }

    public void addTimes(long elapsedTime) {
        this.elapsedTime += elapsedTime;
    }

    public long getTimes() {
        return this.elapsedTime;
    }

    public double getSize() {
        return size;
    }
}
