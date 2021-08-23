package com.design.pattern.db.observer.v8;

public class WakeUpEvent extends Event<Child>{
    long timeStamp;
    String location;
    Child source;

    public WakeUpEvent(long timeStamp, String location, Child source) {
        this.timeStamp = timeStamp;
        this.location = location;
        this.source = source;
    }

    @Override
    Child getSource() {
        return source;
    }
}
