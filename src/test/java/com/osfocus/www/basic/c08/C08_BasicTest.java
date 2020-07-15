package com.osfocus.www.basic.c08;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C08_BasicTest {
    @Test
    public void SuccessorNode() {
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
}
