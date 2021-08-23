package com.design.pattern.db.visitor.v1;

public class CorpVisitor implements Visitor {
    double totalPrice = 0;

    @Override
    public void visitCpu(CPU cpu) {
        totalPrice += cpu.getPrice() * 0.6;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice() * 0.75;
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice += board.getPrice() * 0.8;
    }
}
