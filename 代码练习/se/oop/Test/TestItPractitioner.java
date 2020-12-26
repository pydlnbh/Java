package com.java.se.oop.Test;

import com.java.se.oop.entity.ItPractitioner;

public class TestItPractitioner {

    public static void main(String[] args) {
        ItPractitioner itPractitioner = new ItPractitioner("zs", 23, "数据库维护", 10, "腾讯", "数据库维护工程师");
        System.out.println("姓名：" + itPractitioner.getName());
        System.out.println("年龄：" + itPractitioner.getAge());
        System.out.println("技术方向：" + itPractitioner.getTend());
        System.out.println("工作年限：" + itPractitioner.getWordAge());
        System.out.println("职务是：" + itPractitioner.getWorkUnit());
        System.out.println("========================================");
        itPractitioner.printJob("京东", "Java");
    }
}
