package com.design.pattern.db.state.thread;

public class NewState extends ThreadStateNew {
    private ThreadNew t;

    public NewState(ThreadNew t) {
        this.t = t;
    }

    @Override
    void move(Action input) {
        if (input.msg == "start") {
            t.state = new RunningState(t);
        }
    }

    @Override
    void run() {

    }
}
