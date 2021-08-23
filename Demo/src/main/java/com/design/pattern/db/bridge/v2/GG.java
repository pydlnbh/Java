package com.design.pattern.db.bridge.v2;

public class GG {
    public void chase(MM mm) {
        Gift g = new WarmGift(new Flower());
        give(mm, g);
    }

    public void give(MM mm, Gift gift) {
        System.out.println(gift + "gived!");
    }
}
