package com.osfocus.www.basic.c02;

public class C04_RingArray<T> {
    private T[] arr;
    private int pullI;
    private int pushI;
    private int size;
    private int capacity;

    public C04_RingArray() {
        this(7);
    }

    public C04_RingArray(int capacity) {
        arr = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(T elem) {
        if (size == capacity) {
            throw new RuntimeException("The Ring Array is full.");
        }

        arr[pushI] = elem;
        size++;
        nextIndex(pushI);
    }

    public T pop() {
        if (size == 0) {
            throw new RuntimeException("The Ring Array is full.");
        }

        T result = arr[pullI];
        size--;
        nextIndex(pullI);
        return result;
    }

    private int nextIndex(int i) {
        return i < capacity - 1 ? i + 1 : 0;
    }
}
