package com.java.se.collection;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/26
 * @Description: com.java.se.collection
 */
public class GenericMethod<E> {
    private E e;

    public GenericMethod() {
    }

    public GenericMethod(E e) {
        this.e = e;
    }

    public <M> void test(M m) {
        System.out.println(m);
        System.out.println(e);
    }
}
