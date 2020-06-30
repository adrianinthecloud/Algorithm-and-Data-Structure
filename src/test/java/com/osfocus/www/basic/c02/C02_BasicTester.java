package com.osfocus.www.basic.c02;

import com.osfocus.www.basic.c02.C01_ReverseList.Node;
import com.osfocus.www.basic.c02.C01_ReverseList.DoubleNode;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class C02_BasicTester {
    @Test
    public void ReverseListTest() {
        int maxNum = 1000;
        int numOfItems = 20;

        Node head = C01_ReverseList.generateLinkedList(maxNum, numOfItems);
        List<Integer> list = new LinkedList<>();
        List<Integer> reverseList = new LinkedList<>();
        Node cur = head;
        while (cur != null) {
            list.add(cur.value);
            cur = cur.next;
        }

        Collections.reverse(list);
        head = C01_ReverseList.reverseLinkedList(head);

        cur = head;
        while (cur != null) {
            reverseList.add(cur.value);
            cur = cur.next;
        }

        assertEquals(list, reverseList);

        DoubleNode dhead = C01_ReverseList.generateRandomDoublyLinkedList(maxNum, numOfItems);
        List<Integer> dList = new LinkedList<>();
        List<Integer> dReverseList = new LinkedList<>();
        DoubleNode dCur = dhead;
        while (dCur != null) {
            dList.add(dCur.value);
            dCur = dCur.next;
        }

        Collections.reverse(dList);
        dhead = C01_ReverseList.reverseDoublyLinkedList(dhead);

        dCur = dhead;
        while (dCur != null) {
            dReverseList.add(dCur.value);
            dCur = dCur.next;
        }

        assertEquals(dList, dReverseList);
    }
}
