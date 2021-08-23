package com.design.pattern.book.AdapterPattern;

import java.util.Map;

public class OuterUserInfo extends OuterUser implements IUserInfo{

    private Map baseInfo = super.getUserBaseInfo();
    private Map OfficeInfo = super.getUserOfficeInfo();
    private Map HomeInfo = super.getUserHomeInfo();

    @Override
    public String getUserName() {
        String userName = (String) this.baseInfo.get("userName");
        System.out.println(userName);
        return userName;
    }

    @Override
    public String getHomeAddress() {
        String homeAddress = (String) this.HomeInfo.get("homeAddress");
        System.out.println(homeAddress);
        return homeAddress;
    }

    @Override
    public String getMobileNumber() {
        String mobileNumber = (String) this.baseInfo.get("MobileNumber");
        System.out.println(mobileNumber);
        return mobileNumber;
    }

    @Override
    public String getOfficeTellNumber() {
        String officeNumber = (String) this.OfficeInfo.get("officeNumber");
        System.out.println(officeNumber);
        return officeNumber;
    }

    @Override
    public String getJobPosition() {
        String jobPosition = (String) this.OfficeInfo.get("jobPosition");
        System.out.println(jobPosition);
        return jobPosition;
    }

    @Override
    public String getHomeTellNumber() {
        String homeTellNumber = (String) this.HomeInfo.get("homeTellNumber");
        System.out.println(homeTellNumber);
        return homeTellNumber;
    }
}
