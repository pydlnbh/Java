package com.java.se.collection;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/26
 * @Description: com.java.se.collection
 */
public class GenericClass<A> {
    private int id;
    private A a;

    public GenericClass() {
    }

    public GenericClass(int id, A a) {
        this.id = id;
        this.a = a;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public void show() {
        System.out.println("id = " + id + ", A = " + a);
    }
}
