package com.osfocus.www.basic.c02;

import com.osfocus.www.basic.c01.C03_Stack;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

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

    @Test
    public void testQueue() {
        C03_Queue<Integer> queue = new C03_Queue<>();
        assertTrue(queue.isEmpty());
        queue.offer(99);
        queue.offer(77);
        queue.offer(33);
        queue.offer(199);
        queue.offer(169);

        assertEquals(99, queue.peek().intValue());
        assertEquals(5, queue.size());
        int headVal = queue.poll();
        assertEquals(99, headVal);
        assertEquals(4, queue.size());

        Iterator<Integer> it = queue.iterator();
        assertEquals(77, it.next().intValue());
    }

    @Test
    public void testStack() {
        C03_Stack<Integer> stack = new C03_Stack<>();
        stack.push(99);
        stack.push(55);
        stack.push(177);
        stack.push(201);
        stack.push(10);

        assertEquals(10, stack.pop().intValue());
        assertEquals(4, stack.size());
        assertEquals(201, stack.pop().intValue());
        assertEquals(177, stack.pop().intValue());
        assertEquals(55, stack.pop().intValue());
        assertEquals(99, stack.pop().intValue());
        assertTrue(stack.isEmpty());
    }

    @Test(expected=RuntimeException.class)
    public void testRingArray() {
        C04_RingArray<Integer> ringArray = new C04_RingArray<>(5);
        ringArray.push(3);
        ringArray.push(11);
        ringArray.push(99);
        ringArray.push(55);
        ringArray.push(133);

        int last = ringArray.pop();
        assertEquals(133, last);

        ringArray.push(7);
        ringArray.push(1);
    }

    @Test
    public void testMinStack() {
        C05_MinStack<Integer> minStack = new C05_MinStack<>();
        minStack.push(99);
        minStack.push(102);
        minStack.push(3);
        minStack.push(199);
        minStack.push(888);

        assertEquals(3, minStack.getMin().intValue());
        minStack.push(1);
        assertEquals(1, minStack.getMin().intValue());

        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        assertEquals(99, minStack.getMin().intValue());
    }

    @Test
    public void testTwoStacksImplementQueue() {
        C06_TwoStacksImplementQueue<Integer> queue = new C06_TwoStacksImplementQueue<>();
        assertTrue(queue.isEmpty());

        queue.offer(1);
        assertEquals(1, queue.peek().intValue());

        queue.offer(11);
        queue.offer(133);
        assertEquals(1, queue.peek().intValue());
        int head = queue.poll();
        assertEquals(1, head);
        assertEquals(11, queue.peek().intValue());
        assertEquals(2, queue.size());
        queue.offer(99);
        queue.poll();
        queue.poll();
        head = queue.poll();
        assertEquals(99, head);
    }

    @Test
    public void testTwoQueuesImplementStack() {
        C07_TwoQueuesImplementStack<Integer> myStack = new C07_TwoQueuesImplementStack<>();
        Stack<Integer> test = new Stack<>();
        int testTime = 1000000;
        int max = 1000000;
        for (int i = 0; i < testTime; i++) {
            if (myStack.isEmpty()) {
                assertTrue(test.isEmpty());
                int num = (int) (Math.random() * max);
                myStack.push(num);
                test.push(num);
            } else {
                if (Math.random() < 0.25) {
                    int num = (int) (Math.random() * max);
                    myStack.push(num);
                    test.push(num);
                } else if (Math.random() < 0.5) {
                    assertFalse(!myStack.peek().equals(test.peek()));
                } else if (Math.random() < 0.75) {
                    assertFalse(!myStack.pop().equals(test.pop()));
                } else {
                    assertFalse(myStack.isEmpty() != test.isEmpty());
                }
            }
        }
    }

    @Test
    public void testGetMax() {
        int[] arr = new int[NUM_OF_ITEMS];

        for (int i = 0; i < NUM_OF_ITEMS; i++) {
            arr[i] = (int) ((MAX_NUM + 1) * Math.random());
        }

        int max = C08_GetMax.getMax(arr);
        OptionalInt expectedMax = Arrays.stream(arr).max();

        assertEquals(expectedMax.getAsInt(), max);
    }
}
