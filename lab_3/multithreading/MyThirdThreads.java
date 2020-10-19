package com.company;

public class MyThirdThreads extends Thread {
    private final Object sync;

    public MyThirdThreads(String name, Object sync) {
        super(name);
        this.sync = sync;
    }

    @Override
    public void run() {
        super.run();
        while(true) {
            synchronized (sync) {
                try {
                    System.out.println(this.getName());
                    sync.notify();
                    sync.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
