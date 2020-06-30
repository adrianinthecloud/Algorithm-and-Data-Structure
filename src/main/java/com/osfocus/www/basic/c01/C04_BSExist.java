package com.osfocus.www.basic.c01;

/***
 * Author: Adrian LIU
 * Date: 2020-06-29
 * Desc: checking whether a number exists in a sorted array with at worst logarithmic time.
 */
public class C04_BSExist {
    // worst case: O(logn)
    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) return false;

        int L = 0;
        int R = sortedArr.length - 1;
        while (L < R) {
            int mid = L + ((R-L) >> 1);
            if (sortedArr[mid] == num) return true;
            if (sortedArr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        return false;
    }

    // worst case: O(n)
    public static boolean slowCheckExist(int[] sortedArr, int num) {
        for (int i = 0; i < sortedArr.length-1; i++) {
            if (sortedArr[i] == num) return true;
        }

        return false;
    }
}
