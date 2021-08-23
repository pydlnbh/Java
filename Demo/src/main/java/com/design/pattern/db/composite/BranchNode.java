package com.design.pattern.db.composite;

import java.util.ArrayList;
import java.util.List;

public class BranchNode extends Node {
    String name;
    List<Node> nodes = new ArrayList<>();

    public BranchNode(String name) {
        this.name = name;
    }

    @Override
    void p() {
        System.out.println(name);
    }

    public void add(Node n) {
        nodes.add(n);
    }
}
