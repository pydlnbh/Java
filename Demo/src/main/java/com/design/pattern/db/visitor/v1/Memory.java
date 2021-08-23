package com.design.pattern.db.visitor.v1;

public class Memory extends ComputerPart {
    @Override
    void accept(Visitor v) {
       v.visitMemory(this);
    }

    @Override
    double getPrice() {
        return 500;
    }
}
