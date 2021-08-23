package com.design.pattern.db.prototype.v3;

public class Main {
    public static void main(String[] args) throws Exception {
        Person po = new Person();
        Person pt = (Person) po.clone();
        System.out.println("(po.loc == pt.loc) ==> " + (po.loc == pt.loc));

        po.loc.street.reverse();
        System.out.println(pt.loc.street);
    }
}
