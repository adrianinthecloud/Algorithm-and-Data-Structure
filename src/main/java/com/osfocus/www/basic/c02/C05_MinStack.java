package com.osfocus.www.basic.c02;

import java.util.Stack;

public class C05_MinStack<T extends Comparable> {
    private Stack<T> dataStack = new Stack<>();
    private Stack<T> minStack = new Stack<>();

    public int size() {
        return dataStack.size();
    }

    public boolean isEmpty() {
        return dataStack.isEmpty();
    }

    public T pop() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("The stack is empty.");
        }
        minStack.pop();
        return dataStack.pop();
    }

    public void push(T elem) {
        if (dataStack.isEmpty()) {
            minStack.push(elem);
        } else {
            if (elem.compareTo(minStack.peek()) < 0) {
                minStack.push(elem);
            } else {
                minStack.push(minStack.peek());
            }
        }
        dataStack.push(elem);
    }

    public T getMin() {
        return minStack.peek();
    }
}
