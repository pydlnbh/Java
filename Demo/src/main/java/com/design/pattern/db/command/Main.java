package com.design.pattern.db.command;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Content c = new Content();

        Command ic = new InsertCommand(c);
        ic.doit();
        ic.undo();

        Command cc = new CopyCommand(c);
        cc.doit();
        cc.undo();

        Command dc = new DeleteCommand(c);
        dc.doit();
        dc.undo();

        List<Command> list = new ArrayList<>();
        list.add(new InsertCommand(c));
        list.add(new CopyCommand(c));
        list.add(new DeleteCommand(c));

        for (Command com : list) {
            com.doit();
        }

        System.out.println(c.msg);

        for (int i = list.size() - 1; i >= 0; i--) {
            list.get(i).undo();
        }

        System.out.println(c.msg);
    }
}
