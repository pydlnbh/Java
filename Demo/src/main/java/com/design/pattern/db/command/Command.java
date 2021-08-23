package com.design.pattern.db.command;

public abstract class Command {
    public abstract void doit();

    public abstract void undo();
}
