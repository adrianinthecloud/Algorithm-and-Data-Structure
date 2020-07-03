package com.osfocus.www.basic;

public class ArrayCommonUsage {
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
}
