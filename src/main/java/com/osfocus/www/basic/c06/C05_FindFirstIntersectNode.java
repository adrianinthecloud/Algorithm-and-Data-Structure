package com.osfocus.www.basic.c06;

public class C05_FindFirstIntersectNode {
    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    public static Node getFirstNodeInLoop(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            // won't have loop if number of node is <= 2
            return null;
        }

        Node slow = head.next;
        Node fast = head.next.next;

        while (fast.next != null && fast.next.next != null && fast != slow) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if ((fast.next == null || fast.next.next == null) && fast != slow) return null;

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null && head2 == null) return null;

        Node loopNode1 = getFirstNodeInLoop(head1);
        Node loopNode2 = getFirstNodeInLoop(head2);

        // no loop for both
        if (loopNode1 == null && loopNode2 == null) {
            return noLoop(head1, head2);
        }

        // both has loop
        if (loopNode1 != null && loopNode2 != null) {
            return bothLoop(head1, head2, loopNode1, loopNode2);
        }

        return null;
    }

    private static Node bothLoop(Node head1, Node head2, Node loopNode1, Node loopNode2) {
        Node cur1 = null;
        Node cur2 = null;

        if (loopNode1 == loopNode2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loopNode1) {
                cur1 = cur1.next;
                n++;
            }

            cur2 = head2;
            while (cur2 != loopNode2) {
                cur2 = cur2.next;
                n--;
            }

            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loopNode1.next;
            while (cur1 != loopNode1) {
                if (cur1 == loopNode2) return loopNode1;
                cur1 = cur1.next;
            }

            return null;
        }
    }

    private static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;
        
        Node cur1;
        Node cur2;
        int n = 0;
        cur1 = head1;
        while (cur1.next != null) {
            cur1 = cur1.next;
            n++;
        }

        cur2 = head2;
        while (cur2.next != null) {
            cur2 = cur2.next;
            n--;
        }

        if (cur1 != cur2) return null;

        cur1 = (n > 0) ? head1 : head2;
        cur2 = (cur1 == head1) ? head2 : head1;
        n = Math.abs(n);

        while (n > 0) {
            cur1 = cur1.next;
            n--;
        }

        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }
}
