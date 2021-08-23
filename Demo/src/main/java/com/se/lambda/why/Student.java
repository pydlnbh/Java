package com.se.lambda.why;

/**
 * @Author: PeiYiDing
 * @Date: 2021/1/1
 * @Description: com.java.se.lambda.why
 */
public class Student {
    // 成员变量
    private String name;
    private Integer age;
    private Integer score;

    // Constructor
    public Student() {}

    public Student(String name, Integer age, Integer score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    // Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    // toString

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
