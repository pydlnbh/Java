package com.design.pattern.db.observer.v9;

public class ActionEvent {
    long timeStamp;
    Object source;

    public ActionEvent(long timeStamp, Object source) {
       super();
       this.timeStamp = timeStamp;
       this.source = source;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public Object getSource() {
        return source;
    }
}
