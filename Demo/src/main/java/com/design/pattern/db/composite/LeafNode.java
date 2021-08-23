package com.design.pattern.db.composite;

public class LeafNode extends Node {
    String content;

    public LeafNode(String content) {
        this.content = content;
    }

    @Override
    void p() {
        System.out.println(content);
    }
}
