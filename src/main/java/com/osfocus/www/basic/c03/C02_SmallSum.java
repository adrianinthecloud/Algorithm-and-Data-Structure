package com.osfocus.www.basic.c03;

public class C02_SmallSum {
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) return 0;

        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int L, int R) {
        if (L == R) return 0;

        int M = L + ((R - L) >> 1);

        return process(arr, L, M) + process(arr, M + 1, R) + mergeSum(arr, L, M, R);
    }

    private static int mergeSum(int[] arr, int L, int M, int R) {
        int[] tmpArr = new int[R - L + 1];
        int i = 0;
        int sum = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            sum += arr[p1] < arr[p2] ? arr[p1] * (R - p2 + 1) : 0;
            tmpArr[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
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

        return sum;
    }

    public static int checkSum(int[] arr) {
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    sum += arr[j];
                }
            }
        }

        return sum;
    }

    public static int[] generateArray(int maxNum, int numOfItems) {
        int[] unsortedArr = new int[numOfItems];

        for (int i = 0; i < numOfItems; i ++) {
            unsortedArr[i] = (int) ((maxNum + 1) * Math.random());
        }

        return unsortedArr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        int[] arr2 = new int[]{8, 7, 9};

        System.out.println(checkSum(arr));
        System.out.println(smallSum(arr));
        System.out.println(checkSum(arr2));
    }
}
