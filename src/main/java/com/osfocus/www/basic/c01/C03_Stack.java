package com.osfocus.www.basic.c01;

import com.osfocus.www.basic.c02.C03_Queue;
import com.osfocus.www.basic.c02.Node;

public class C03_Stack<T> {
    private C03_Queue<T> queue = new C03_Queue<>();

    public C03_Stack() {}

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public void push(T elem) {
        queue.offer(elem);
    }

    public T pop() {
        return queue.pollFromTail();
    }
}
