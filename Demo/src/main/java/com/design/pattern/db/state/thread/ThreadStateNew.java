package com.design.pattern.db.state.thread;

public abstract class ThreadStateNew {
    abstract void move(Action input);

    abstract void run();
}
