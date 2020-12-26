package com.java.se.oop.entity;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.enetity
 * @Version: 1.0
 */
public class Student {
    private int sNO;
    private String sName;
    private char sSex;
    private int sAge;
    private int sJava;

    public Student() {

    }

    public Student(int sNO, String sName, char sSex, int sAge, int sJava) {
        this.sNO  = sNO;
        this.sName  = sName;
        this.sSex  = sSex;
        this.sAge  = sAge;
        this.sJava  = sJava;
    }

    public int getsNo() {
        return sNO;
    }

    public void setNo(int sNo) {
        this.sNO = sNo;
    }

    public String getName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getsAge() {
        return sAge;
    }

    public void setsAge(int sAge) {
        this.sAge = sAge;
    }
}
