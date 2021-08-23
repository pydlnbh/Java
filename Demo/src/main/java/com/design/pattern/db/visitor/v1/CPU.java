package com.design.pattern.db.visitor.v1;

public class CPU extends ComputerPart{
    @Override
    void accept(Visitor v) {
        v.visitCpu(this);
    }

    @Override
    double getPrice() {
        return 500;
    }
}
