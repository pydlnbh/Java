package com.develop.manual.question06;

public class SubThread implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
