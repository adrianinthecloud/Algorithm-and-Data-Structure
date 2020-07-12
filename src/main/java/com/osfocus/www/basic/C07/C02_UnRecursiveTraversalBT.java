package com.osfocus.www.basic.C07;

import java.util.Stack;

public class C02_UnRecursiveTraversalBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void pre(Node head) {
        System.out.print("pre-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);

            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + " ");

                if (head.right != null) {
                    stack.push(head.right);
                }

                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    public static void in(Node head) {
        System.out.print("in-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();

            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    public static void pos1(Node head) {
        System.out.print("pos-order1: ");
        if (head == null) return;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(head);
        while (!s1.empty()) {
            head = s1.pop();
            s2.push(head);

            if (head.left != null) {
                s1.push(head.left);
            }

            if (head.right != null) {
                s1.push(head.right);
            }
        }

        while (!s2.isEmpty()) {
            System.out.print(s2.pop().value + " ");
        }

        System.out.println();
    }

    public static void pos2(Node h) {
        System.out.print("pos-order2: ");
        if (h != null) {
            Stack<Node> stack = new Stack<>();
            Node cur = null;
            stack.push(h);
            while (!stack.isEmpty()) {
                cur = stack.peek();
                if (cur.left != null && h != cur.left && h != cur.right) {
                    stack.push(cur.left);
                } else if (cur.right != null && h != cur.right) {
                    stack.push(cur.right);
                } else {
                    h = stack.pop();
                    System.out.print(h.value + " ");
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        pre(head);
        System.out.println("========");
        in(head);
        System.out.println("========");
        pos1(head);
        System.out.println("========");
        pos2(head);
        System.out.println("========");
    }
}
