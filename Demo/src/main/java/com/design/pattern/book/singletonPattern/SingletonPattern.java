package com.design.pattern.book.singletonPattern;

/**
 * 单例模式模板
 * */
public class SingletonPattern {

    private static final SingletonPattern singletonPattern = new SingletonPattern();

    private SingletonPattern() {

    }

    public synchronized static SingletonPattern getInstance() {
        return singletonPattern;
    }
}
