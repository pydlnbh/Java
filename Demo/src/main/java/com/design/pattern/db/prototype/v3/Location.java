package com.design.pattern.db.prototype.v3;

public class Location implements Cloneable {
    StringBuffer street;
    int roomNo;

    public Location(StringBuffer street, int roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }

    @Override
    public String toString() {
        return "Location{" +
                "street=" + street +
                ", roomNo=" + roomNo +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
