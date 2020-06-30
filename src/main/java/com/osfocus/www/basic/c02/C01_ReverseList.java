package com.osfocus.www.basic.c02;

public class C01_ReverseList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode pre;
        public DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }

        public DoubleNode(int value, DoubleNode pre, DoubleNode next) {
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }

    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    public static DoubleNode reverseDoublyLinkedList(DoubleNode head) {
        DoubleNode next = null;

        while (head.next != null) {
            next = head.next;
            head.next = head.pre;
            head.pre = next;
            head = next;
        }

        head.next = head.pre;
        head.pre = null;

        return head;
    }

    public static Node generateLinkedList(int maxNum, int numOfItems) {
        Node head = null;
        Node cur = null;
        for (int i = 0; i < numOfItems; i++) {
            if (head == null) {
                head = new Node((int) ((maxNum+1) * Math.random()));
                cur = head;
            } else {
                cur.next = new Node((int) ((maxNum+1) * Math.random()));
                cur = cur.next;
            }
        }

        return head;
    }

    public static DoubleNode generateRandomDoublyLinkedList(int maxNum, int numOfItems) {
        DoubleNode head = null;
        DoubleNode cur = null;

        for (int i = 0; i < numOfItems; i++) {
            if (head == null) {
                head = new DoubleNode((int) ((maxNum+1) * Math.random()), null, null);
                cur = head;
            } else {
                cur.next = new DoubleNode((int) ((maxNum+1) * Math.random()), cur, null);
                cur = cur.next;
            }
        }

        return head;
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.value);
            head = head.next;
            if (head != null) System.out.print("-");
        }
    }

    public static void printDoublyLinkedList(DoubleNode head) {
        while (head != null) {
            System.out.print(head.value);
            head = head.next;
            if (head != null) System.out.print("-");
        }
    }

    public static void main(String[] args) {
        int numOfItems = 20;
        int maxNum = 1000;

        DoubleNode dNode = generateRandomDoublyLinkedList(100, 15);
        System.out.println();
        printDoublyLinkedList(dNode);

        dNode = reverseDoublyLinkedList(dNode);
        System.out.println();
        printDoublyLinkedList(dNode);
    }
}
