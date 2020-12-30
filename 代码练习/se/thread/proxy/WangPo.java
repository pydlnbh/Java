package com.java.se.thread.proxy;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.proxy
 */
public class WangPo implements KindWomen{
    // 实例化一个接口
    private KindWomen kindWomen;

    // 无参的构造方法, 默认为潘金莲代理
    public WangPo() {
        this.kindWomen = new PanJinLian();
    }

    // 定义有参的构造方法, 可以为其他女人代理
    public WangPo(KindWomen kindWomen) {
        this.kindWomen = kindWomen;
    }


    @Override
    public void makeEyesWithMe() {
        this.kindWomen.makeEyesWithMe();
    }

    @Override
    public void playWithMe() {
        this.kindWomen.playWithMe();
    }
}
