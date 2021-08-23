package com.design.pattern.db.prototype.v1;

public class Location {
    String street;
    String roomNo;

    public Location(String street, String roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", roomNo='" + roomNo + '\'' +
                '}';
    }
}
