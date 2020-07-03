package com.osfocus.www.basic.c03;

public class C03_QuickSort {
    // pick the number in R position of arr[] as the key
    public static int partition(int[] arr, int L, int R) {
        int lessEqual = L - 1;

        for (int i = L; i < R; i++) {
            if (arr[i] <= arr[R]) {
                swap(arr, ++lessEqual, i);
            }
        }

        swap(arr, ++lessEqual, R);

        return lessEqual;
    }

    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        int less = L - 1;
        int bigger = R;

        int i = L;

        while (i < bigger) {
            if (arr[i] < arr[R]) {
                swap(arr, ++less, i++);
            } else if (arr[i] > arr[R]){
                swap(arr, --bigger, i);
            } else {
                i++;
            }
        }
        swap(arr, bigger, R);
        return new int[]{++less, bigger};
    }

    public static void process1(int[] arr, int L, int R) {
        if (L >= R) return;

        int p = partition(arr, L, R);
        process1(arr, L, p-1);
        process1(arr, p, R);
    }

    public static void process2(int[] arr, int L, int R) {
        if (L >= R) return;

        int[] equalZone = netherlandsFlag(arr, L, R);

        process2(arr, L, equalZone[0] - 1);
        process2(arr, equalZone[1] + 1, R);
    }

    public static void process3(int[] arr, int L, int R) {
        if (L >= R) return;

        swap(arr, L + (int) ((R - L + 1) * Math.random()), R);
        int[] equalZone = netherlandsFlag(arr, L, R);
        process3(arr, L, equalZone[0] - 1);
        process3(arr, equalZone[1] + 1, R);
    }

    // Worst Case O(N^2)
    public static void quickSort1(int[] arr) {
        process1(arr, 0, arr.length - 1);
    }

    // Worst Case O(N^2)
    public static void quickSort2(int[] arr) {
        process2(arr, 0, arr.length - 1);
    }

    // O(NlogN);
    public static void quickSort3(int[] arr) {
        process3(arr, 0, arr.length - 1);
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print("-");
            } else {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,3,1,6,4};
        partition(arr, 0, arr.length - 1);
        printArray(arr);
    }
}
