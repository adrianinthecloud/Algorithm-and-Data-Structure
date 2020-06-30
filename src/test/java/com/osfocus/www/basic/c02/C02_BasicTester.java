package com.osfocus.www.basic.c02;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class C02_BasicTester {
    private static final int MAX_NUM = 1000;
    private static final int NUM_OF_ITEMS = 20;

    @Test
    public void ReverseListTest() {
        C01_ReverseList.Node head = C01_ReverseList.generateLinkedList(MAX_NUM, NUM_OF_ITEMS);
        List<Integer> list = new LinkedList<>();
        List<Integer> reverseList = new LinkedList<>();
        C01_ReverseList.Node cur = head;
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

        C01_ReverseList.DoubleNode dhead = C01_ReverseList.generateRandomDoublyLinkedList(MAX_NUM, NUM_OF_ITEMS);
        List<Integer> dList = new LinkedList<>();
        List<Integer> dReverseList = new LinkedList<>();
        C01_ReverseList.DoubleNode dCur = dhead;
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

    @Test
    public void DeleteGivenValueTest() {
        for (int i = 0; i < 50; i++) {
            List<Integer> list = new LinkedList<>();

            C02_DeleteGivenValue.Node head = C02_DeleteGivenValue.generateList(MAX_NUM, NUM_OF_ITEMS);
            C02_DeleteGivenValue.Node cur = head;

            while (cur != null) {
                list.add(cur.value);
                cur = cur.next;
            }

            int removeIndex = (int) (list.size() * Math.random());
            Integer item = list.get(removeIndex);
            list.remove(item);

            System.out.println();

            head = C02_DeleteGivenValue.remove(head, item);

            List<Integer> listAfterRemove = new LinkedList<>();
            cur = head;
            while (cur != null) {
                listAfterRemove.add(cur.value);
                cur = cur.next;
            }

            assertEquals(list, listAfterRemove);
        }
    }

}
