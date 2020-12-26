package com.java.se.inteface.impl;

import com.java.se.inteface.HardDisk;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/26
 * @Description: com.java.se.inteface.impl
 */
public class HardDiskImpl implements HardDisk {
    @Override
    public int capacity() {
        return 1024 * 4;
    }
}
