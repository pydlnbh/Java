package com.design.pattern.db.bridge.v2;

public class WarmGift extends Gift {
    public WarmGift(GiftImpl impl) {
        this.impl = impl;
    }
}
