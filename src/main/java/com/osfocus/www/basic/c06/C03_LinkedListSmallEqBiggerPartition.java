package com.osfocus.www.basic.c06;

public class C03_LinkedListSmallEqBiggerPartition {
    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node listPartition1(Node head, int pivot) {
        if (head == null) return null;

        int size = size(head);
        Node[] nodeArr = new Node[size];
        Node cur = head;
        int i = 0;
        for (i = 0; cur != null && i < nodeArr.length; i++, cur = cur.next) {
            nodeArr[i] = cur;
        }

        arrPartition(nodeArr, pivot);
        for (i = 1; i < nodeArr.length; i++) {
            nodeArr[i-1].next = nodeArr[i];
        }
        nodeArr[i-1].next = null;

        return nodeArr[0];
    }

    // with O(1) extra space
    public static Node listPartition2(Node head, int pivot) {
        if (head == null) return null;

        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        Node next = head.next;

        while (head != null) {
            if (head.value < pivot) {
                if (sH == null) {
                    sH = sT = head;
                } else {
                    sT.next = head;
                    sT = sT.next;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = eT = head;
                } else {
                    eT.next = head;
                    eT = eT.next;
                }
            } else {
                if (bH == null) {
                    bH = bT = head;
                } else {
                    bT.next = head;
                    bT = bT.next;
                }
            }

            head = next;
            next = (next != null) ? next.next : null;
        }

        sT.next = eH;
        eT.next = bH;

        return sH;
    }

    public static void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int bigger = nodeArr.length;
        int i = 0;

        while (i < bigger) {
            if (nodeArr[i].value < pivot) {
                swap(nodeArr, ++small, i++);
            } else if (nodeArr[i].value > pivot) {
                swap(nodeArr, i, --bigger);
            } else {
                i++;
            }
        }
    }

    public static void swap(Node[] nodeArr, int i, int j) {
        Node tmpNode = nodeArr[i];
        nodeArr[i] = nodeArr[j];
        nodeArr[j] = tmpNode;
    }

    public static void printList(Node[] nodeArr) {
        for (int i = 0; i < nodeArr.length; i++) {
            System.out.print(nodeArr[i].value);
            if (i != nodeArr.length - 1) System.out.print("-");
        }
        System.out.println();
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value);
            if (head.next != null) System.out.print("-");
            head = head.next;
        }
        System.out.println();
    }

    public static int size(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }

        return count;
    }

    public static void main(String[] args) {
        // 9-2-3-7-1-2-3-8
        Node head = new Node(9);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(3);
        head.next.next.next.next.next.next.next = new Node(8);

        printList(head);

        head = listPartition2(head, 3);

        printList(head);
    }
}
