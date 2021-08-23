package com.design.pattern.book.proxyPattren;

public class WangPo implements KindWomen {

    private KindWomen kindWomen;

    public WangPo() {
        this.kindWomen = new PanJinLian();
    }

    public WangPo(KindWomen kindWomen) {
        this.kindWomen = kindWomen;
    }

    @Override
    public void MakeEyeWithMan() {
        this.kindWomen.MakeEyeWithMan();
    }

    @Override
    public void HappyWithMan() {
        this.kindWomen.HappyWithMan();
    }
}
