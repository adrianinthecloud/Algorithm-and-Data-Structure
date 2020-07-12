package com.osfocus.www.basic.c06;

import org.junit.Test;

import static org.junit.Assert.*;

public class C06_BasicTest {
    @Test
    public void LinkedListMidTest() {
        // 3-9-7-1-2
        C01_LinkedListMid.Node root = new C01_LinkedListMid.Node(3);
        root.next = new C01_LinkedListMid.Node(9);
        root.next.next = new C01_LinkedListMid.Node(7);
        root.next.next.next = new C01_LinkedListMid.Node(1);
        root.next.next.next.next = new C01_LinkedListMid.Node(2);

        assertEquals(7, C01_LinkedListMid.midOrUpMidNode(root).value);
        assertEquals(7, C01_LinkedListMid.midOrDownMidNode(root).value);
        assertEquals(9, C01_LinkedListMid.midOrUpMidPreNode(root).value);
        assertEquals(9, C01_LinkedListMid.midOrDownMidPreNode(root).value);
        assertEquals(7, C01_LinkedListMid.right1(root).value);
        assertEquals(7, C01_LinkedListMid.right2(root).value);
        assertEquals(9, C01_LinkedListMid.right3(root).value);
        assertEquals(9, C01_LinkedListMid.right4(root).value);

        // 3-9-7-1-2-8
        root.next.next.next.next.next = new C01_LinkedListMid.Node(8);
        assertEquals(7, C01_LinkedListMid.right1(root).value);
        assertEquals(1, C01_LinkedListMid.right2(root).value);
        assertEquals(9, C01_LinkedListMid.right3(root).value);
        assertEquals(7, C01_LinkedListMid.right4(root).value);
    }

    @Test
    public void IsPalindromeListTest() {
        // 1-5
        C02_IsPalindromeList.Node head = new C02_IsPalindromeList.Node(1);
        head.next = new C02_IsPalindromeList.Node(5);
        assertFalse(C02_IsPalindromeList.isPalindrome1(head));
        assertFalse(C02_IsPalindromeList.isPalindrome2(head));
        assertFalse(C02_IsPalindromeList.isPalindrome3(head));

        // 2-2
        C02_IsPalindromeList.Node head2 = new C02_IsPalindromeList.Node(2);
        head2.next = new C02_IsPalindromeList.Node(2);
        assertTrue(C02_IsPalindromeList.isPalindrome1(head2));
        assertTrue(C02_IsPalindromeList.isPalindrome2(head2));
        assertTrue(C02_IsPalindromeList.isPalindrome3(head2));

        // 1-5-1
        head.next.next = new C02_IsPalindromeList.Node(1);
        C02_IsPalindromeList.printLinkedList(head);
        assertTrue(C02_IsPalindromeList.isPalindrome1(head));
        assertTrue(C02_IsPalindromeList.isPalindrome2(head));
        assertTrue(C02_IsPalindromeList.isPalindrome3(head));

        // 1-5-1-9-1-5-1
        head.next.next.next = new C02_IsPalindromeList.Node(9);
        head.next.next.next.next = new C02_IsPalindromeList.Node(1);
        head.next.next.next.next.next = new C02_IsPalindromeList.Node(5);
        head.next.next.next.next.next.next = new C02_IsPalindromeList.Node(1);
        C02_IsPalindromeList.printLinkedList(head);
        assertTrue(C02_IsPalindromeList.isPalindrome1(head));
        assertTrue(C02_IsPalindromeList.isPalindrome2(head));
        assertTrue(C02_IsPalindromeList.isPalindrome3(head));
    }

    @Test
    public void CopyListWithRandomTest() {
        // 9-0-3-8-1
        C04_CopyListWithRandom.Node head = new C04_CopyListWithRandom.Node(9);
        head.next = new C04_CopyListWithRandom.Node(0);
        head.next.next = new C04_CopyListWithRandom.Node(3);
        head.next.next.next = new C04_CopyListWithRandom.Node(8);
        head.next.next.next.next = new C04_CopyListWithRandom.Node(1);

        head.next.random = head;
        head.next.next.random = head.next;
        head.next.next.next.random = head;


        C04_CopyListWithRandom.Node newHead = C04_CopyListWithRandom.deepClone1(head);

        C04_CopyListWithRandom.Node newHead2 = C04_CopyListWithRandom.deepClone2(head);

        assertTrue(C04_CopyListWithRandom.equals(head, newHead));

        assertTrue(C04_CopyListWithRandom.equals(head, newHead2));
    }

    @Test
    public void FindFirstIntersectNodeTeest() {
        // 1->2->3->4->5->6->7->null
        C05_FindFirstIntersectNode.Node head1 = new C05_FindFirstIntersectNode.Node(1);
        head1.next = new C05_FindFirstIntersectNode.Node(2);
        head1.next.next = new C05_FindFirstIntersectNode.Node(3);
        head1.next.next.next = new C05_FindFirstIntersectNode.Node(4);
        head1.next.next.next.next = new C05_FindFirstIntersectNode.Node(5);
        head1.next.next.next.next.next = new C05_FindFirstIntersectNode.Node(6);
        head1.next.next.next.next.next.next = new C05_FindFirstIntersectNode.Node(7);

        // 0->9->8->6->7->null
        C05_FindFirstIntersectNode.Node head2 = new C05_FindFirstIntersectNode.Node(0);
        head2.next = new C05_FindFirstIntersectNode.Node(9);
        head2.next.next = new C05_FindFirstIntersectNode.Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        assertEquals(6, C05_FindFirstIntersectNode.getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new C05_FindFirstIntersectNode.Node(1);
        head1.next = new C05_FindFirstIntersectNode.Node(2);
        head1.next.next = new C05_FindFirstIntersectNode.Node(3);
        head1.next.next.next = new C05_FindFirstIntersectNode.Node(4);
        head1.next.next.next.next = new C05_FindFirstIntersectNode.Node(5);
        head1.next.next.next.next.next = new C05_FindFirstIntersectNode.Node(6);
        head1.next.next.next.next.next.next = new C05_FindFirstIntersectNode.Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new C05_FindFirstIntersectNode.Node(0);
        head2.next = new C05_FindFirstIntersectNode.Node(9);
        head2.next.next = new C05_FindFirstIntersectNode.Node(8);
        head2.next.next.next = head1.next; // 8->2
        assertEquals(2, C05_FindFirstIntersectNode.getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new C05_FindFirstIntersectNode.Node(0);
        head2.next = new C05_FindFirstIntersectNode.Node(9);
        head2.next.next = new C05_FindFirstIntersectNode.Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        assertEquals(4, C05_FindFirstIntersectNode.getIntersectNode(head1, head2).value);
    }
}
