package com.osfocus.www.basic.c05;

public class C03_CountSort {
    public static void countSort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        int[] bucket = new int[max+1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        for (int i = 0, j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0) {
                arr[i++] = j;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{33,11,59,200,12};
        countSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print("-");
            } else {
                System.out.println();
            }
        }
    }
}
