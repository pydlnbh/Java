package com.se.collection;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/26
 * @Description: com.java.se.collection
 */
public class PM extends Employee {
    // 私有属性
    private int workOfYear;

    public PM() {
    }

    public PM(int workOfYear) {
        this.workOfYear = workOfYear;
    }

    public PM(int id, String name, int age, Gender gender, int workOfYear) {
        super(id, name, age, gender);
        this.workOfYear = workOfYear;
    }

    public int getWorkOfYear() {
        return workOfYear;
    }

    public void setWorkOfYear(int workOfYear) {
        this.workOfYear = workOfYear;
    }

    @Override
    public String toString() {
        return "PM{" +
                "workOfYear=" + workOfYear +
                '}';
    }
}
