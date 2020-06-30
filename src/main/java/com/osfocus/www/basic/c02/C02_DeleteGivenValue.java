package com.osfocus.www.basic.c02;

public class C02_DeleteGivenValue {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    // only remove the first occurrence here.
    // If we want to remove all occurrence, just simply remove the break; inside the second if of the while loop.
    public static Node remove(Node head, int num) {
        if (head != null && head.value == num) return head.next;

        Node cur = head;
        while (cur != null) {
            if (cur.next == null) break;

            if (cur.next.value == num) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }

        return head;
    }

    public static Node generateList(int maxNum, int numOfItems) {
        if (numOfItems == 0) return null;

        Node head = new Node((int) ((maxNum + 1) * Math.random()));;
        Node cur = head;
        numOfItems--;
        while (numOfItems > 0) {
            cur.next = new Node((int) ((maxNum + 1) * Math.random()));
            cur = cur.next;
            numOfItems--;
        }

        return head;
    }
}
