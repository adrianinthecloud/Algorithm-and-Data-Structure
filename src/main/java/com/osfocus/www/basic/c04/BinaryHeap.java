package com.osfocus.www.basic.c04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BinaryHeap<T extends Comparable<T>> {
    private List<T> heap;
    private int capacity;
    private int heapSize = 0;

    public BinaryHeap() {
        this(1);
    }

    public BinaryHeap(int capacity) {
        heap = new ArrayList<>();
    }

    public BinaryHeap(Collection<T> elems) {
        this(elems.size());
        for (T elem : elems) add(elem);
    }

    public BinaryHeap(T[] elems) {
        heapSize = capacity = elems.length;
        heap = new ArrayList<T>(capacity);

        // Place all element in heap
        for (int i = 0; i < heapSize; i++) heap.add(elems[i]);

        // Heapify process, O(n)
        for (int i = Math.max(0, (heapSize >> 1) - 1); i >= 0; i--) sink(i);
    }

    public int size() {
        return heapSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(T elem) {
        if (elem == null) throw new IllegalArgumentException();

        if (heapSize < capacity) {
            heap.set(heapSize, elem);
        } else {
            heap.add(elem);
            capacity++;
        }

        swim(heapSize);
        heapSize++;
    }

    public T peek() {
        if (isEmpty()) return null;
        return heap.get(0);
    }

    public T poll() {
        return removeAt(0);
    }

    public boolean remove(T elem) {
        if (isEmpty()) throw new RuntimeException("The heap is empty.");
        if (elem == null) return false;

        for (int i = 0; i < heapSize; i++) {
            if (heap.get(i).equals(elem)) {
                removeAt(i);
                return true;
            }
        }

        return false;
    }

    private T removeAt(int i) {
        // empty => null
        // last direct delete
        // --heapSize
        // swap targetNode and the end
        // swim and sink to reorder the heap

        if (isEmpty()) return null;
        heapSize--;

        T res = heap.get(i);
        if (i == heapSize) {
            heap.set(i, null);
        } else {
            swap(i, heapSize);
            heap.set(heapSize, null);
            T reorderNode = heap.get(i);
            swim(i);

            if (reorderNode == heap.get(i)) sink(i);
        }

        return res;
    }

    public boolean contains(T elem) {
        return heap.contains(elem);
    }

    private void swim(int k) {
        int parent = (k - 1) >> 1;
        while (k > 0 && less(k, parent)) {
            swap(parent, k);
            k = parent;
            parent = (k - 1) >> 1;
        }
    }

    private void sink(int k) {
        while (true) {
            int left = (k << 1) + 1;
            if (left >= heapSize) break;
            int right = left + 1;
            int smallest = (right < heapSize) && (less(right, left)) ? right : left;
            if (less(smallest, k)) {
                swap(k, smallest);
                k = smallest;
            } else {
                break;
            }
        }
    }

    private boolean less(int i, int j) {
        return heap.get(i).compareTo(heap.get(j)) <= 0;
    }

    private void swap(int i, int j) {
        T tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) heap.set(i, null);
        heapSize = 0;
    }

    public boolean isMinHeap(int k) {
        if (k >= heapSize) return true;

        int left = (k << 1) + 1;
        int right = (k << 1) + 2;

        if (left < heapSize && !less(k, left)) return false;
        if (right < heapSize && !less(k, right)) return false;

        return isMinHeap(left) && isMinHeap(right);
    }

    @Override
    public String toString() {
        return "MyHeap{" +
                "heap=" + heap +
                ", capacity=" + capacity +
                ", heapSize=" + heapSize +
                '}';
    }
}
