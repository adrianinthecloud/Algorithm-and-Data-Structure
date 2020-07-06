package com.osfocus.www.basic.c06;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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

        // 3-9-7-1-2-8
        root.next.next.next.next.next = new C01_LinkedListMid.Node(8);
        assertEquals(7, C01_LinkedListMid.midOrUpMidNode(root).value);
        assertEquals(1, C01_LinkedListMid.midOrDownMidNode(root).value);
        assertEquals(9, C01_LinkedListMid.midOrUpMidPreNode(root).value);
        assertEquals(7, C01_LinkedListMid.midOrDownMidPreNode(root).value);
    }
}
