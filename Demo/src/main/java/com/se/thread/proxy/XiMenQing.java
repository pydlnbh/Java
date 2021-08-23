package com.se.thread.proxy;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.proxy
 */
public class XiMenQing {
    public static void main(String[] args) {
        // 使用了无参的代理类构造方法
        WangPo wangPo = new WangPo();
        wangPo.playWithMe();
        wangPo.makeEyesWithMe();

        System.out.println("===========");

        // 使用了有参的代理类构造方法
        WangPo wangPo1 = new WangPo(new JiaShi());
        wangPo1.makeEyesWithMe();
        wangPo1.playWithMe();
    }
}
