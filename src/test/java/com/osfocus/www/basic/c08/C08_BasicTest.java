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

    @Test
    public void MaxHappyTest() {
        //                  Boss(100)
        //        e1(70)     e2(30)      e3(50)
        //   e4(35) e5(10)              e6(65)  e7(80)
        C06_MaxHappy.Employee boss = new C06_MaxHappy.Employee(100);
        C06_MaxHappy.Employee e1 = new C06_MaxHappy.Employee(70);
        C06_MaxHappy.Employee e2 = new C06_MaxHappy.Employee(30);
        C06_MaxHappy.Employee e3 = new C06_MaxHappy.Employee(50);
        C06_MaxHappy.Employee e4 = new C06_MaxHappy.Employee(35);
        C06_MaxHappy.Employee e5 = new C06_MaxHappy.Employee(10);
        C06_MaxHappy.Employee e6 = new C06_MaxHappy.Employee(65);
        C06_MaxHappy.Employee e7 = new C06_MaxHappy.Employee(80);
        assertEquals(100, C06_MaxHappy.getMaxHappy(boss));
        boss.subordinates.add(e1);
        boss.subordinates.add(e2);
        boss.subordinates.add(e3);
        assertEquals(150, C06_MaxHappy.getMaxHappy(boss));
        e1.subordinates.add(e4);
        e1.subordinates.add(e5);
        e3.subordinates.add(e6);
        e3.subordinates.add(e7);
        assertEquals(290, C06_MaxHappy.getMaxHappy(boss));
    }
}
