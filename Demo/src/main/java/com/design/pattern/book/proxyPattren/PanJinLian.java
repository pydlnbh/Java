package com.design.pattern.book.proxyPattren;

public class PanJinLian implements KindWomen{
    @Override
    public void MakeEyeWithMan() {
        System.out.println("pjl抛媚眼");
    }

    @Override
    public void HappyWithMan() {
        System.out.println("pjl在ppp");
    }
}
