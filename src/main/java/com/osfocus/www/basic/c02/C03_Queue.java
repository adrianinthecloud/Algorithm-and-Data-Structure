package com.osfocus.www.basic.c02;

import java.util.Iterator;

public class C03_Queue<T> {
    public Node<T> head;
    public Node<T> tail;

    private int size = 0;

    public C03_Queue() {}

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T peek() {
        return head.value;
    }

    public T pollFromTail() {
        if (tail == null) return null;

        Node<T> cur = tail;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.pre;
            tail.next = null;
        }

        size--;

        return cur.value;
    }

    public T poll() {
        if (head == null) return null;
        Node<T> cur = head;

        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.pre = null;
            cur.next = null;
        }

        size--;
        return cur.value;
    }

    public void addToHead(T elem) {
        Node<T> cur = new Node<>(elem);
        cur.next = head;
        head.pre = cur;
        head = cur;
        if (tail == null) tail = head;
    }

    public void offer(T elem) {
        if (head == null) {
            head = tail = new Node<>(elem);
        } else {
            tail.next = new Node<>(elem, tail, null);
            tail = tail.next;
        }
        size++;
    }

    public void print() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value);
            cur = cur.next;
            if (cur != null) {
                System.out.print("-");
            }
        }
    }

    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {
        private Node<T> cur = head;

        @Override
        public boolean hasNext() {
            return cur.next != null;
        }

        @Override
        public T next() {
            if (cur == null) return null;
            T result = cur.value;
            cur = cur.next;
            return result;
        }
    }

    public static void main(String[] args) {
        C03_Queue<Integer> queue = new C03_Queue<>();
        queue.offer(3);
        queue.offer(2);
        queue.offer(9);
        queue.print();
        System.out.println();
        System.out.println(queue.peek());

        queue.print();
    }
}
