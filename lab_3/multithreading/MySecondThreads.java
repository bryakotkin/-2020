package com.company;

public class MySecondThreads extends Thread {
    private final Counter counter;

    public MySecondThreads(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        synchronized (MySecondThreads.class)
        {
            for(int i = 0; i < 1000; i++) {
                counter.increment();
            }
        }
    }
}
