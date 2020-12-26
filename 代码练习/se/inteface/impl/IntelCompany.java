package com.java.se.inteface.impl;

import com.java.se.inteface.CPU;
import com.java.se.inteface.HardDisk;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/26
 * @Description: com.java.se.inteface.impl
 */
public class IntelCompany implements CPU, HardDisk {
    @Override
    public String brand() {
        return "intel";
    }

    @Override
    public String hz() {
        return "220hz";
    }

    @Override
    public int capacity() {
        return 1024;
    }
}
