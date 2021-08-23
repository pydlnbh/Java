package com.design.pattern.db.state.thread;

public class TerminatedState extends ThreadStateNew {
    private ThreadNew t;

    public TerminatedState(ThreadNew t) {
        this.t = t;
    }

    @Override
    void move(Action input) {

    }

    @Override
    void run() {

    }
}
