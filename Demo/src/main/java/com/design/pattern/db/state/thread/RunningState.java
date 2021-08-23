package com.design.pattern.db.state.thread;

public class RunningState extends ThreadStateNew {
    private ThreadNew t;

    public RunningState(ThreadNew t) {
        this.t = t;
    }

    @Override
    void move(Action input) {

    }

    @Override
    void run() {

    }
}
