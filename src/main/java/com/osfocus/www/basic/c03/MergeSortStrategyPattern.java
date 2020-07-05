package com.osfocus.www.basic.c03;


import java.util.Comparator;

public class MergeSortStrategyPattern<T> {
    public void sort(T[] arr, Comparator<T> comparator) {
        process(arr, 0, arr.length - 1, comparator);
    }

    private void process(T[] arr, int L, int R, Comparator<T> comparator) {
        if (L == R) return;

        int M = L + ((R - L) >> 1);
        process(arr, L, M, comparator);
        process(arr, M + 1, R, comparator);
        merge(arr, L, M, R, comparator);
    }

    private void merge(T[] arr, int L, int M, int R, Comparator<T> comparator) {
        if (L == R) return;

        int p1 = L;
        int p2 = M + 1;
        T[] help = (T[]) new Object[R - L + 1];

        int i = 0;
        while (p1 <= M && p2 <= R) {
            help[i++] = (comparator.compare(arr[p1], (arr[p2])) <= 0) ? arr[p1++] : arr[p2++];
        }

        while (p1 <= M) {
            help[i++] = arr[p1++];
        }

        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }
}
