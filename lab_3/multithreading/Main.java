package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void firstTask() {
        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            Thread thread = new MyFirstThreads(Integer.toString(i + 1));
            threads.add(thread);
            thread.start();
        }
        while(!threads.isEmpty()){
            for(Thread thread : threads) {
                if(!thread.isAlive()) {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Поток-" + thread.getName() + ". Состояние:" + thread.getState());
                    threads.remove(thread);
                    break;
                }
            }
        }
    }

    public static void secondTask() {
        Counter counter = new Counter();
        List<Thread> threads = new ArrayList<>();

        for(int i = 0; i < 100; i++) {
            Thread thread = new MySecondThreads(counter);
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

        System.out.println("Количество: " + counter.getCount());
    }

    public static void thirdTask() {
        Object sync = new Object();
        Thread[] threads = new MyThirdThreads[2];
        for(int i = 0; i < 2; i++) {
            threads[i] = new MyThirdThreads(Integer.toString(i), sync);
        }
        threads[0].start();
        threads[1].start();
    }

    public static void main(String[] args) {
        firstTask();
        secondTask();
        thirdTask();
    }
}
