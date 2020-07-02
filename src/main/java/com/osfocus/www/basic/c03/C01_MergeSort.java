package com.osfocus.www.basic.c03;

public class C01_MergeSort {
    public static void mergeSort1(int[] arr) {
        int L = 0;
        int R = arr.length - 1;
        process(arr, L, R);
    }

    public static void process(int[] arr, int L, int R) {
        if (L == R) return;

        int M = L + ((R - L) >> 1);
        process(arr, L, M);
        process(arr, M+1, R);
        merge(arr, L, M, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        if (L == R) return;

        int p1 = L;
        int p2 = M+1;
        int i = 0;
        int[] tmpArr = new int[R - L + 1];

        while (p1 <= M && p2 <= R) {
            tmpArr[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= M) {
            tmpArr[i++] = arr[p1++];
        }

        while (p2 <= R) {
            tmpArr[i++] = arr[p2++];
        }

        for (i = 0; i < tmpArr.length; i++) {
            arr[L + i] = tmpArr[i];
        }
    }

    // non recursive implementation
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) return;

        int mergeSize = 1; // size of left group
        int N = arr.length;

        while (mergeSize < N) {
            int L = 0;

            while (L < N) {
                int M = L + mergeSize - 1;
                if (M >= N) break;
                // control boundary L...M   M+1...R(mergeSize)
                int R = Math.min(M + mergeSize, N-1);
                merge(arr, L, M, R);
                L = R + 1;
            }

            // avoid overflow
            if (mergeSize > N / 2) {
                break;
            }

            mergeSize <<= 1;
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print("-");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int numOfItem = 10;
        int maxNum = 1000;
        int[] arr = new int[numOfItem];
        for (int i = 0; i < numOfItem; i++) {
            arr[i] = (int) ((1000 + 1) * Math.random());
        }

        mergeSort2(arr);
        printArray(arr);
    }
}
