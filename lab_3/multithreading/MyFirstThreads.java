package com.company;

public class MyFirstThreads extends Thread {
    public MyFirstThreads(String name) {
        super(name);
    }

    public void getCustomInfo() {
        System.out.println("Поток-" + this.getName() + ". Состояние:" + this.getState());
    }

    @Override
    public void start() {
        this.getCustomInfo();
        super.start();
    }

    @Override
    public void run() {
        super.run();
        this.getCustomInfo();
        for(int i = 0; i <= 100; i++) {
            System.out.println(this.getName() + ":" + i);
        }
    }
}
