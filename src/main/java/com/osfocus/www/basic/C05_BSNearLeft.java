package com.osfocus.www.basic;

public class C05_BSNearLeft {
    public static int nearestIndex(int[] sortedArr, int value) {
        if (sortedArr == null || sortedArr.length == 0) return -1;

        int L = 0;
        int R = sortedArr.length-1;
        int index = -1;

        while (R >= L) {
            int mid = L + ((R - L) >> 1);
            if (sortedArr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        return index;
    }

    public static int test(int[] sortedArr, int value) {
        if (sortedArr == null || sortedArr.length == 0) return -1;

        for (int i = 0; i < sortedArr.length; i++) {
            if (sortedArr[i] >= value) return i;
        }

        return -1;
    }
}
