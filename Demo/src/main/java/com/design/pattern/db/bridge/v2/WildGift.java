package com.design.pattern.db.bridge.v2;

public class WildGift extends Gift{
    public WildGift(GiftImpl impl) {
        this.impl = impl;
    }
}
