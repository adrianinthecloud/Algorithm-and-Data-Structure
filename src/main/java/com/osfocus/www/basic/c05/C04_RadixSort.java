package com.osfocus.www.basic.c05;

public class C04_RadixSort {
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        radixSort(arr, 0, arr.length - 1, maxBit(arr));
    }

    public static int maxBit(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        int res = 0;
        while (max != 0) {
            max /= 10;
            res++;
        }

        return res;
    }

    public static int getDigit(int number, int d) {
        return ((number / ((int) Math.pow(10, d - 1))) % 10);
    }

    private static void radixSort(int[] arr, int L, int R, int digits) {
        final int radix = 10;
        int i, j = 0;
        int[] help = new int[R - L + 1];
        for (int d = 1; d <= digits; d++) {
            int[] count = new int[radix];
            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }

            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }

            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d);
                help[count[j] - 1] = arr[i];
                count[j]--;
            }

            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = help[j];
            }
        }
    }
}
