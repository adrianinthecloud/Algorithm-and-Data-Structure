package com.osfocus.www.basic.c02;

import java.util.LinkedList;
import java.util.Queue;

public class C07_TwoQueuesImplementStack<T> {
    private Queue<T> queue = new LinkedList<>();
    private Queue<T> help = new LinkedList<>();

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public T pop() {
        while (queue.size() > 1) {
            help.add(queue.poll());
        }

        T result = queue.poll();
        queue = help;
        help = new LinkedList<>();

        return result;
    }

    public T peek() {
        T result = pop();
        queue.add(result);
        return result;
    }

    public void push(T elem) {
        queue.add(elem);
    }
}
