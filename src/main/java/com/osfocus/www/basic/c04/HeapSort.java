package com.osfocus.www.basic.c04;

public class HeapSort {
    public static void sort(int[] arr) {
        // heapify O(NLogN)
        for (int i = arr.length - 1; i >= 0; i--) {
            sink(arr, i, arr.length); // O(logN)
        }

        int heapSize = arr.length;
        while (heapSize > 0) {
            swap(arr, 0, --heapSize);
            sink(arr, 0, heapSize);
        }
    }

    // only sink to the input heapSize
    private static void sink(int[] arr, int k, int heapSize) {
        while (true) {
            int left = (k << 1) + 1;
            if (left >= heapSize) break;
            int right = left + 1;
            int largest = (right < heapSize && less(arr, left, right)) ? right : left;
            if (less(arr, k, largest)) {
                swap(arr, k, largest);
                k = largest;
            } else {
                break;
            }
        }
    }

    private static boolean less(int[] arr, int i, int j) {
        return arr[i] < arr[j];
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
