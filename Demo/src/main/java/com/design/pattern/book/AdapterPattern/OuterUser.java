package com.design.pattern.book.AdapterPattern;

import java.util.HashMap;
import java.util.Map;

public class OuterUser implements IOuterUser{
    @Override
    public Map getUserBaseInfo() {
        HashMap hashMap = new HashMap();

        hashMap.put("userName", "James");
        hashMap.put("MobileNumber", "0371");

        return hashMap;
    }

    @Override
    public Map getUserOfficeInfo() {
        HashMap hashMap = new HashMap();

        hashMap.put("jobPosition", "boss");
        hashMap.put("officeNumber", "0010");

        return hashMap;
    }

    @Override
    public Map getUserHomeInfo() {
        HashMap hashMap = new HashMap();

        hashMap.put("homeAddress", "China");
        hashMap.put("homeTellNumber", "0391");

        return hashMap;
    }
}
