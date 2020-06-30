package com.osfocus.www.basic.c02;

import java.util.Arrays;
import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T> {
    private int size = 0;
    private int capacity;
    private T[] array;

    public DynamicArray() {
        this(16);
    }

    public DynamicArray(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Cannot create an dynamic array with capacity less than 0.");

        this.capacity = capacity;

        array = (T[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public void add(T item) {
        if (size + 1 >= capacity) {
            if (capacity == 0) {
                capacity = 1;
            } else {
                capacity = capacity * 2;
            }

            T[] newArray = (T[]) new Object[capacity];

            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }

            array = newArray;
        }

        array[size++] = item;
    }

    public static class TestInner {
        public static String name;
    }

    public void set(int index, T item) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        array[index] = item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        return array[index];
    }

    public int indexOf(T obj) {
        if (isEmpty()) return -1;

        for (int i = 0; i < size; i++) {
            if (array[i] == obj || (array[i] != null && array[i].equals(obj))) return i;
        }

        return -1;
    }

    public boolean contains(T obj) {
        return indexOf(obj) != -1;
    }

    public void clear() {
        for (int i = 0; i < size; i++) array[i] = null;
        size = 0;
    }

    public boolean remove(T obj) {
        int index = indexOf(obj);
        if (index == -1) return false;

        removeAt(index);

        return true;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        T[] newArray = (T[]) new Object[--capacity];
        T removeItem = null;
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != index) {
                newArray[j] = array[i];
                j++;
            } else {
                removeItem = array[i];
            }
        }

        array = newArray;
        size--;

        return removeItem;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return array[index++];
            }

        };
    }

    @Override
    public String toString() {
        return "DynamicArray [size=" + size + ", capacity=" + capacity + ", array=" + Arrays.toString(array) + "]";
    }
}

