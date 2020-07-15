package com.osfocus.www.basic.c08;

public class C01_PrintTree {
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void print(Node node, int height, String direction, int len) {
        if (node == null) return;
        print(node.right, height + 1, "˅", len);
        int val = node.value;
        String printVal = direction + val + direction;
        int prePadding = 8 * height + (len - printVal.length()) >> 1;
        for (int i = 0; i < prePadding; i++) {
            System.out.print(" ");
        }
        System.out.println(printVal);

        print(node.left, height + 1, "^", len);
    }

    public static void main(String[] args) {
        C01_PrintTree.Node head = new C01_PrintTree.Node(1);
        head.left = new C01_PrintTree.Node(2);
        head.right = new C01_PrintTree.Node(3);
        head.left.left = new C01_PrintTree.Node(4);
        head.left.right = new C01_PrintTree.Node(5);
        head.right.left = new C01_PrintTree.Node(6);
        head.right.right = new C01_PrintTree.Node(7);

        print(head, 0, "H", 18);
    }
}
