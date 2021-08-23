package com.design.pattern.db.observer.v6;

/* 事件类 Fire Event */
public class WakeUpEvent {
    long timeStamp;
    String location;

    public WakeUpEvent(long timeStamp, String location) {
        this.timeStamp = timeStamp;
        this.location = location;
    }
}
