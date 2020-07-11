package com.osfocus.www.basic.c06;

import java.util.HashMap;
import java.util.Map;

// Node.random will point to null or any node in the chain
public class C04_CopyListWithRandom {
    static class Node {
        int value;
        Node next;
        Node random;

        public Node(int value) {
            this.value = value;
        }
    }

    // deep clone with O(n) extra space
    public static Node deepClone1(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<Node, Node>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }

    // deep clone with O(1) extra space
    public static Node deepClone2(Node head) {
        if (head == null) return null;

        // insert new copied node in between each node and its next node
        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }

        // adjust random node for each node in the new list
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }

            cur = cur.next.next;
        }

        // split the new list from the original list
        Node newHead = head.next;
        next = newHead;
        cur = head;
        while (cur != null) {
            cur.next = cur.next.next;
            if (next.next == null) break;
            next.next = next.next.next;
            cur = cur.next;
            next = next.next;
        }

        return newHead;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value);
            if (head.random != null) {
                System.out.print("r" + head.random.value);
            }
            if (head.next != null) System.out.print("-");
            head = head.next;
        }
        System.out.println();
    }

    public static boolean equals(Node head1, Node head2) {
        while (head1 != null) {
            if (head2 == null) return false;

            if (head1.value != head2.value) {
                return false;
            }

            if (head1.random != null) {
                if (head2.random == null || head1.random.value != head2.random.value) return false;
            } else if (head2.random != null) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return true;
    }

    public static void main(String[] args) {
        // 9-0-3-8-1
        Node head = new Node(9);
        head.next = new Node(0);
        head.next.next = new Node(3);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(1);

        head.next.random = head;
        head.next.next.random = head.next;
        head.next.next.next.random = head;

        printList(head);

        Node newHead = deepClone1(head);
        printList(newHead);

        Node newHead2 = deepClone2(head);
        printList(newHead2);
    }
}
