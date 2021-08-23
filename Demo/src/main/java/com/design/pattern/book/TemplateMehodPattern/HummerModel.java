package com.design.pattern.book.TemplateMehodPattern;

public abstract class HummerModel {
    protected abstract void start();

    protected abstract void stop();

    protected abstract void alarm();

    protected abstract void engineBoom();

    protected boolean isAlarm() {
        return false;
    }

    final public void run() {
        this.start();
        this.engineBoom();
        if (isAlarm()) {
            this.alarm();
        }
        this.stop();
    }


}
