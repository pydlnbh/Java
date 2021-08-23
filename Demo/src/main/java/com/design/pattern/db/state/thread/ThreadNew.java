package com.design.pattern.db.state.thread;

public class ThreadNew {
    ThreadStateNew state;

    void move(Action input) {
        state.move(input);
    }

    void run() {
        state.run();
    }
}
