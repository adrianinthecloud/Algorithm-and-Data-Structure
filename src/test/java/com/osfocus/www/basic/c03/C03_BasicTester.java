package com.osfocus.www.basic.c03;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class C03_BasicTester {
    private static final int MAX_NUM = 100;
    private static final int NUM_OF_ITEMS = 100000;

    @Test
    public void MergeSortTest() {
        int[] unsortedArr = new int[NUM_OF_ITEMS];;
        for (int i = 0; i < NUM_OF_ITEMS; i ++) {
            unsortedArr[i] = (int) ((MAX_NUM + 1) * Math.random());
        }

        int[] mergeSortedArr1 = new int[NUM_OF_ITEMS];
        int[] mergeSortedArr2 = new int[NUM_OF_ITEMS];
        System.arraycopy(unsortedArr, 0, mergeSortedArr1, 0, NUM_OF_ITEMS);
        System.arraycopy(unsortedArr, 0, mergeSortedArr2, 0, NUM_OF_ITEMS);
        C01_MergeSort.mergeSort1(mergeSortedArr1);
        C01_MergeSort.mergeSort2(mergeSortedArr2);

        Arrays.sort(unsortedArr);

        assertArrayEquals(unsortedArr, mergeSortedArr1);
        assertArrayEquals(mergeSortedArr1, mergeSortedArr2);
    }

    @Test
    public void SmallSumTest() {
        int[] arr1 = C02_SmallSum.generateArray(MAX_NUM, NUM_OF_ITEMS);
        int[] arr2 = new int[arr1.length];

        System.arraycopy(arr1, 0, arr2, 0, arr2.length);

        long start = System.currentTimeMillis();

        int res1 = C02_SmallSum.smallSum(arr1);

        long expired = System.currentTimeMillis();

        System.out.println("C02_SmallSum smallSum(arr1) took " + (expired-start) + "ms.");

        start = System.currentTimeMillis();

        int res2 = C02_SmallSum.checkSum(arr2);

        expired = System.currentTimeMillis();

        System.out.println("C02_SmallSum checkSum(arr2) took " + (expired-start) + "ms.");

        assertEquals(res1, res2);
    }
}
