package com.osfocus.www.basic.C07;

public class C01_RecursiveTraversalBT {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void f(Node node) {
        if (node == null) return;
        // pre
        f(node);
        // in
        f(node);
        // pos
    }

    public static void pre(Node node) {
        if (node == null) return;

        System.out.print(node.value + " ");
        pre(node.left);
        pre(node.right);
    }

    public static void in(Node node) {
        if (node == null) return;

        in(node.left);
        System.out.print(node.value + " ");
        in(node.right);
    }

    public static void pos(Node node) {
        if (node == null) return;

        pos(node.left);
        pos(node.right);
        System.out.print(node.value + " ");
    }

    public static void main(String[] args) {
        //       8
        //     5   10
        //   3  6 9  13
        Node head = new Node(8);
        head.left = new Node(5);
        head.right = new Node(10);
        head.left.left = new Node(3);
        head.left.right = new Node(6);
        head.right.left = new Node(9);
        head.right.right = new Node(13);
        pre(head);
        System.out.println();
        in(head);
        System.out.println();
        pos(head);
    }
}
