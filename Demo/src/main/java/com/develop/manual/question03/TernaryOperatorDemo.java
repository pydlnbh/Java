package com.develop.manual.question03;

import cn.hutool.core.collection.CollUtil;

import java.util.HashMap;
import java.util.Map;

public class TernaryOperatorDemo {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = null;
        Boolean flag = false;
        Integer reuslt = flag ? (Integer) (a * b) : c;
        System.out.println(reuslt);

        Map<String, Boolean> hashMap = new HashMap<>();
        Boolean boo = (CollUtil.isEmpty(hashMap) ? hashMap.get("test") : Boolean.FALSE);
        System.out.println(boo);
    }
}
