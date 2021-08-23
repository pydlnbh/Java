package com.design.pattern.db.prototype.v1;

public class Main {
    public static void main(String[] args) throws Exception {
        Person po = new Person();
        Person pt = (Person) po.clone();

        System.out.println(pt.age + " " + pt.score);
        System.out.println(pt.loc);

        System.out.println(po.loc == pt.loc);

        po.loc.street = "sh";
        System.out.println(pt.loc);
    }
}
