package com.design.pattern.db.visitor.v1;

public class Main {
    public static void main(String[] args) {
        PersonalVisitor personalVisitor = new PersonalVisitor();
        new Computer().accept(personalVisitor);
        System.out.println(personalVisitor.totalPrice);
    }
}
