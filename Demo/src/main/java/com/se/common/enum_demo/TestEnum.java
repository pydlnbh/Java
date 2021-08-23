package com.se.common.enum_demo;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/26
 * @Description: com.java.se.common.Enum
 */
public enum TestEnum {
    LANUCH("lauch"), PAGEVIEW("pageview"), EVENT("event");

    private final String name;

    TestEnum(String name) {
        this.name = name;
    }

    void show() {
        System.out.println(this.name);
    }

    public static void main(String[] args) {
        TestEnum anEnum = TestEnum.LANUCH;
        anEnum.show();
    }
}
