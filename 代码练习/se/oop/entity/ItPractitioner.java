package com.java.se.oop.entity;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.entity
 * @Version: 1.0
 */
public class ItPractitioner {

    private String name;
    private int age;
    private String tend;
    private int wordAge;
    private String workUnit;
    private String job;

    public void printJob(String workUnit, String job) {
        System.out.println("目前就职于：" + (this.workUnit = workUnit));
        System.out.print("职务是：" + (this.job = job));
    }

    public ItPractitioner() {
        this.age = 15;
    }

    public ItPractitioner(String name, int age, String tend, int wordAge, String workUnit, String job) {
        this.name = name;
        this.age = age;
        this.tend = tend;
        this.wordAge = wordAge;
        this.workUnit = workUnit;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 15) {
            System.out.print("Invalid information");
        }
        this.age = age;
    }

    public String getTend() {
        return tend;
    }

    public int getWordAge() {
        return wordAge;
    }

    public void setWordAge(int wordAge) {
        this.wordAge = wordAge;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
