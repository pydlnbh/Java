package com.se.collection;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/26
 * @Description: com.java.se.collection
 */
public class SE extends Employee {
    // 私有属性
    private int popularity;

    public SE() {
    }

    public SE(int popularity) {
        this.popularity = popularity;
    }

    public SE(int id, String name, int age, Gender gender, int popularity) {
        super(id, name, age, gender);
        this.popularity = popularity;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    @Override
    public String toString() {
        return "SE{" +
                "popularity=" + popularity +
                '}';
    }
}
