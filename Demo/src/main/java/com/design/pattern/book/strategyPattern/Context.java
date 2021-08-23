package com.design.pattern.book.strategyPattern;

public class Context {

    private IsStrategy isStrategy;

    public Context(IsStrategy isStrategy) {
        this.isStrategy = isStrategy;
    }

    public void operate() {
        this.isStrategy.operate();
    }
}
