package com.osfocus.www.basic.c02;

import java.util.EmptyStackException;
import java.util.Stack;

public class C06_TwoStacksImplementQueue<T> {
    private Stack<T> cacheStack = new Stack<>();
    private Stack<T> dataStack = new Stack<>();

    public int size() {
        return (cacheStack.size() + dataStack.size());
    }

    public boolean isEmpty() {
        return cacheStack.isEmpty() && dataStack.isEmpty();
    }

    public void pushToPop() {
        while (cacheStack.size() > 0) {
            dataStack.push(cacheStack.pop());
        }
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException();

        if (dataStack.size() == 0) {
            pushToPop();
        }
        return dataStack.peek();
    }

    public T poll() {
        if (isEmpty()) throw new EmptyStackException();

        if (dataStack.size() == 0) {
            pushToPop();
        }
        return dataStack.pop();
    }

    public void offer(T elem) {
        cacheStack.push(elem);
    }
}
