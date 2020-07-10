package com.osfocus.www.basic.c06;

import java.util.Objects;
import java.util.Stack;

public class C02_IsPalindromeList {
    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return value == node.value;
        }
    }

    // check isPalindrome with n extra space
    public static boolean isPalindrome1(Node head) {
        if (head == null) return true;

        Stack<Node> stack = new Stack<>();

        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        cur = head;
        while (cur != null && !stack.isEmpty()) {
            if (cur.value != stack.pop().value) return false;
            cur = cur.next;
        }

        return true;
    }

    // check isPalindrome with n/2 extra space
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) return true;

        Stack<Node> stack = new Stack<>();

        Node slow = head;
        Node fast = head.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node cur = slow.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (!stack.isEmpty()) {
            if (!head.equals(stack.pop())) return false;
            head = head.next;
        }

        return true;
    }

    // checking isPalindrome with O(1) extra space
    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        if (head.next.next == null) {
            return head.equals(head.next);
        }

        Node slow = head.next;
        Node fast = head.next.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node last = (fast.next != null) ? fast.next : fast;

        Node next = slow.next;
        Node nextNext = (next != null) ? next.next : null;

        while (slow != null) {
            if (next != null) {
                next.next = slow;
            }

            slow = next;
            next = nextNext;
            nextNext = (next != null) ? next.next : null;
        }

        Node cur = last;

        while (head != cur) {
            if (!head.equals(cur)) {
                resetList(last);
                return false;
            }

            head = head.next;
            cur = cur.next;
        }

        resetList(last);

        return true;
    }

    // assume that the list has been modified, whose next node in between the mid node and last node won't be null
    public static void resetList(Node last) {
        if (last == null) throw new IllegalArgumentException();

        Node next = last.next;
        Node nextNext = next.next;
        last.next = null;

        while (nextNext != last) {
            next.next = last;
            last = next;
            next = nextNext;
        }
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
}
