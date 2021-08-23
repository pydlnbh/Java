package com.design.pattern.book.AdapterPattern;

public class UserInfo implements IUserInfo{
    @Override
    public String getUserName() {
        System.out.println("userName...");
        return null;
    }

    @Override
    public String getHomeAddress() {
        System.out.println("homeAddress...");
        return null;
    }

    @Override
    public String getMobileNumber() {
        System.out.println("mobileNumber...");
        return null;
    }

    @Override
    public String getOfficeTellNumber() {
        System.out.println("officeTelNumber...");
        return null;
    }

    @Override
    public String getJobPosition() {
        System.out.println("jobPosition...");
        return null;
    }

    @Override
    public String getHomeTellNumber() {
        System.out.println("homeTelNumber...");
        return null;
    }
}
