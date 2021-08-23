package com.se.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/31
 * @Description: com.java.se.net
 */
public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            // 网络协议地址类的返回本机地址的方法
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);

            // 给定主机名, 确定主机的IP地址
            InetAddress byName = InetAddress.getByName("www.bilibili.com");
            System.out.println(byName);

            // 以文本形式返回IP地址字符串
            System.out.println(byName.getHostAddress());


            // 返回地址的主机名
            System.out.println(byName.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
