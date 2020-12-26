package com.java.se.inteface.test;

import com.java.se.inteface.CPU;
import com.java.se.inteface.HardDisk;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/26
 * @Description: com.java.se.inteface.test
 */
public class Computer {

    public void show(CPU cpu, HardDisk hardDisk) {
        System.out.println("计算机的组成如下: ");
        System.out.println("cpu: " + cpu.brand() + ", 主频是: " + cpu.hz());
        System.out.println("hardDisk: " + hardDisk.capacity());
    }
}
