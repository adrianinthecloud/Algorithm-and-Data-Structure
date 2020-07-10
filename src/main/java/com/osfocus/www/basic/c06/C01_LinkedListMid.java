package com.osfocus.www.basic.c06;

import java.util.ArrayList;
import java.util.List;

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

    public static Node right1(Node head) {
        if (head == null) return null;

        List<Node> arr = new ArrayList<>();

        Node cur = head;
        while (cur != null) {
            arr.add(cur);

            cur = cur.next;
        }

        return arr.get((arr.size() - 1) / 2);
    }

    public static Node right2(Node head) {
        if (head == null) return null;

        List<Node> arr = new ArrayList<>();

        Node cur = head;
        while (cur != null) {
            arr.add(cur);

            cur = cur.next;
        }

        return arr.get(arr.size() / 2);
    }

    public static Node right3(Node head) {
        if (head == null || head.next == null || head.next.next == null) return null;

        List<Node> arr = new ArrayList<>();

        Node cur = head;
        while (cur != null) {
            arr.add(cur);

            cur = cur.next;
        }

        return arr.get((arr.size() - 3) / 2);
    }

    public static Node right4(Node head) {
        if (head == null || head.next == null) return null;

        List<Node> arr = new ArrayList<>();

        Node cur = head;
        while (cur != null) {
            arr.add(cur);

            cur = cur.next;
        }

        return arr.get((arr.size() - 2) / 2);
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
