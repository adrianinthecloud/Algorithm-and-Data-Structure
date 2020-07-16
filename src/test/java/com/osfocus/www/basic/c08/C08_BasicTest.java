package com.osfocus.www.basic.c08;

import org.junit.Test;

import static org.junit.Assert.*;

public class C08_BasicTest {
    @Test
    public void SuccessorNodeTest() {
        //              9
        //           6      13
        //         5   8  10   15
        //        1   7
        C02_SuccessorNode.Node head = new C02_SuccessorNode.Node(9, null);
        head.left = new C02_SuccessorNode.Node(6, head);
        head.left.left = new C02_SuccessorNode.Node(5, head.left);
        head.left.left.left = new C02_SuccessorNode.Node(1, head.left.left);
        head.left.right = new C02_SuccessorNode.Node(8, head.left);
        head.left.right.left = new C02_SuccessorNode.Node(7, head.left.right);
        head.right = new C02_SuccessorNode.Node(13, head);
        head.right.left = new C02_SuccessorNode.Node(10, head.right);
        head.right.right = new C02_SuccessorNode.Node(15, head.right);

        assertEquals(head.left.right, C02_SuccessorNode.getSuccessorNode(head.left.right.left));
        assertEquals(head, C02_SuccessorNode.getSuccessorNode(head.left.right));
        assertTrue(C02_SuccessorNode.getSuccessorNode(head.right.right) == null);
    }

    @Test
    public void isBalancedTest() {
        //          9
        //      5       13
        //    2   6   11   16
        //   1
        C04_IsBalanced.Node head = new C04_IsBalanced.Node(9);
        head.left = new C04_IsBalanced.Node(5);
        assertTrue(C04_IsBalanced.isBalanced1(head));
        head.left.left = new C04_IsBalanced.Node(2);
        assertFalse(C04_IsBalanced.isBalanced1(head));
        head.right = new C04_IsBalanced.Node(13);
        assertTrue(C04_IsBalanced.isBalanced1(head));
        head.left.right = new C04_IsBalanced.Node(6);
        head.left.left.left = new C04_IsBalanced.Node(1);
        head.right.left = new C04_IsBalanced.Node(11);
        head.right.right = new C04_IsBalanced.Node(16);
        assertTrue(C04_IsBalanced.isBalanced1(head));
    }

    @Test
    public void MaxSubBSTSizeTest() {
        //          9
        //      5       13
        //    2   3   11   16
        //   1
        C05_MaxSubBSTSize.Node head = new C05_MaxSubBSTSize.Node(9);
        head.left = new C05_MaxSubBSTSize.Node(5);
        head.right = new C05_MaxSubBSTSize.Node(13);
        assertTrue(C05_MaxSubBSTSize.getMaxBSTSize(head) == 3);
        head.left.left = new C05_MaxSubBSTSize.Node(2);
        assertTrue(C05_MaxSubBSTSize.getMaxBSTSize(head) == 4);
        head.left.right = new C05_MaxSubBSTSize.Node(3);
        assertTrue(C05_MaxSubBSTSize.getMaxBSTSize(head) == 1);
        head.right.left = new C05_MaxSubBSTSize.Node(11);
        head.right.right = new C05_MaxSubBSTSize.Node(16);
        assertTrue(C05_MaxSubBSTSize.getMaxBSTSize(head) == 3);
    }
}
