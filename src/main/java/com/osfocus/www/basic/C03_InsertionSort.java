package com.osfocus.www.basic;

public class C03_InsertionSort {
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j >= 0 && arr[j]>arr[j+1]; j--) {
                swap(arr, j, j+1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
