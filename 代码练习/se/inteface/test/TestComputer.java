package com.java.se.inteface.test;

import com.java.se.inteface.impl.HardDiskImpl;
import com.java.se.inteface.impl.IntelCompany;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/26
 * @Description: com.java.se.inteface.test
 */
public class TestComputer {

    public static void main(String[] args) {

        Computer computer = new Computer();
        computer.show(new IntelCompany(), new HardDiskImpl());
    }
}
