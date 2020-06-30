package com.osfocus.www.basic.c02;

public class C08_GetMax {
    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int L, int R) {
        if (L == R) return arr[L];

        int mid = L + ((R - L) >> 1);
        int left = process(arr, L, mid);
        int right = process(arr, mid + 1, R);
        return Math.max(left, right);
    }
}
