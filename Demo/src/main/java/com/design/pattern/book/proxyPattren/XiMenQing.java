package com.design.pattern.book.proxyPattren;

public class XiMenQing {
    public static void main(String[] args) {
        WangPo wangPo = new WangPo();
        wangPo.MakeEyeWithMan();
        wangPo.HappyWithMan();

        System.out.println();

        WangPo wangPo1 = new WangPo(new JiaShi());
        wangPo1.HappyWithMan();
    }
}
