package com.design.pattern.book.TemplateMehodPattern;

public class HummerH1Model extends HummerModel{
    private boolean alarmFlag = true;

    @Override
    protected void start() {
        System.out.println("H1 Start!");
    }

    @Override
    protected void stop() {
        System.out.println("H1 Stop!");
    }

    @Override
    protected void alarm() {
        System.out.println("H1 Alarm");
    }

    @Override
    protected void engineBoom() {
        System.out.println("H1 EngineBoom!");
    }

    @Override
    protected boolean isAlarm() {
        return this.alarmFlag;
    }

    public void setAlarmFlag(boolean isAlarm) {
        this.alarmFlag = isAlarm;
    }
}
