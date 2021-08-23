package com.design.pattern.db.command;

public class InsertCommand extends Command {
    Content c;
    String srtToInsert = "http://www.baidu.com";

    public InsertCommand(Content c) {
        this.c = c;
    }

    @Override
    public void doit() {
        c.msg = c.msg + srtToInsert;
    }

    @Override
    public void undo() {
        c.msg = c.msg.substring(0, c.msg.length() - srtToInsert.length());
    }
}
