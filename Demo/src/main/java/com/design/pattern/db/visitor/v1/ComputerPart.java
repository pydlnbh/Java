package com.design.pattern.db.visitor.v1;

public abstract class ComputerPart {
    abstract void accept(Visitor v);

    abstract double getPrice();
}
