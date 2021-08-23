package com.design.pattern.db.visitor.v1;

public interface Visitor {
    void visitCpu(CPU cpu);

    void visitMemory(Memory memory);

    void visitBoard(Board board);
}
