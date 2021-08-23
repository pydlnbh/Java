package com.design.pattern.db.composite;

public class Main {
    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");

        BranchNode chapterOne = new BranchNode("chapterOne");
        BranchNode chapterTwo = new BranchNode("chapterTwo");

        Node leafOne = new LeafNode("LeafOne");

        Node leafNodeOne = new LeafNode("Chapter1-1");
        Node leafNodeTwo = new LeafNode("Chapter1-2");

        BranchNode section = new BranchNode("section");

        Node ln_One = new LeafNode("c1-1-1");
        Node ln_Two = new LeafNode("c1-1-2");

        root.add(chapterOne);
        root.add(chapterTwo);
        root.add(leafOne);

        chapterOne.add(leafNodeOne);
        chapterOne.add(leafNodeTwo);
        chapterTwo.add(section);

        section.add(ln_One);
        section.add(ln_Two);

        tree(root, 0);
    }

    private static void tree(Node root, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("--");
        }

        root.p();

        if (root instanceof BranchNode) {
            for (Node n : ((BranchNode) root).nodes) {
                tree(n, depth + 1);
            }
        }
    }
}
