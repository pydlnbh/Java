package com.design.pattern.book.AdapterPattern;

public class App {
    public static void main(String[] args) {
        IUserInfo userInfo = new UserInfo();
        for (int i = 0; i < 101; i++) {
            userInfo.getMobileNumber();
        }

        System.out.println("-----------------");

        OuterUserInfo outerUserInfo = new OuterUserInfo();
        for (int i = 0; i < 101; i++) {
            outerUserInfo.getHomeAddress();
        }
    }
}
