package com.design.pattern.book.TemplateMehodPattern;

public class Client {
    public static void main(String[] args) {
        HummerH1Model hummerH1Model = new HummerH1Model();
        hummerH1Model.setAlarmFlag(false);
        hummerH1Model.run();
    }
}
