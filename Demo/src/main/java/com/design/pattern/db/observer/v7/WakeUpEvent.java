package com.design.pattern.db.observer.v7;

public class WakeUpEvent {
    long timeStamp;
    String location;
    Child source;

    public WakeUpEvent(long timeStamp, String location, Child source) {
        this.timeStamp = timeStamp;
        this.location = location;
        this.source = source;
    }
}
