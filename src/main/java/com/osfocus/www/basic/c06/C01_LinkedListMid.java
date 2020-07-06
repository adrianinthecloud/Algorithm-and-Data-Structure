package com.osfocus.www.basic.c06;

public class C01_LinkedListMid {
    public static class Node {
        public int value;
        public Node next;

        public Node(int v) {
            value = v;
        }
    }

    public static Node midOrUpMidNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        Node slow = head.next;
        Node fast = head.next.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node midOrDownMidNode(Node head) {
        if (head == null || head.next == null) return head;

        Node slow = head.next;
        Node fast = head.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node midOrUpMidPreNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) return head;

        Node slow = head;
        Node fast = head.next.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node midOrDownMidPreNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        if (head.next.next == null) return head;

        Node slow = head;
        Node fast = head.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        // 3-9-7-1-2
        Node root = new Node(3);
        root.next = new Node(9);
        root.next.next = new Node(7);
        root.next.next.next = new Node(1);
        root.next.next.next.next = new Node(2);

        System.out.println(midOrUpMidNode(root).value);
        // 3-9-7-1-2-8
        root.next.next.next.next.next = new Node(8);
        System.out.println(midOrUpMidNode(root).value);
    }
}
