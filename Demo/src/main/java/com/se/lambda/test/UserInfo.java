package com.se.lambda.test;

public class UserInfo {

    private String name;
    private int age;
    private String sex;
    private Integer score;

    public UserInfo(String name, int age, String sex, Integer score) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public Integer getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", score=" + score +
                '}';
    }
}