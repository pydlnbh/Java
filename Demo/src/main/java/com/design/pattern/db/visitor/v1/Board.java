package com.design.pattern.db.visitor.v1;

public class Board extends ComputerPart {
    @Override
    void accept(Visitor v) {
        v.visitBoard(this);
    }

    @Override
    double getPrice() {
        return 500;
    }
}
