package com.osfocus.www.basic.c03;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class C03_BasicTester {
    private static final int MAX_NUM = 100;
    private static final int NUM_OF_ITEMS = 100;
    private static final int[] UN_SORTED_ARR;

    static {
        UN_SORTED_ARR = new int[NUM_OF_ITEMS];
        for (int i = 0; i < NUM_OF_ITEMS; i ++) {
            UN_SORTED_ARR[i] = (int) ((MAX_NUM + 1) * Math.random());
        }
    }

    @Test
    public void MergeSortTest() {
        int[] unsortedArr = new int[NUM_OF_ITEMS];
        System.arraycopy(UN_SORTED_ARR, 0, unsortedArr, 0, NUM_OF_ITEMS);

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

        int res1 = C02_SmallSum.smallSum(arr1);
        int res2 = C02_SmallSum.checkSum(arr2);

        assertEquals(res1, res2);
    }

    @Test
    public void QuickSortTest() {
        int[] mySortedArr1 = new int[NUM_OF_ITEMS];
        System.arraycopy(UN_SORTED_ARR, 0, mySortedArr1, 0, NUM_OF_ITEMS);
        int[] systemSortedArr = new int[NUM_OF_ITEMS];
        System.arraycopy(UN_SORTED_ARR, 0, systemSortedArr, 0, NUM_OF_ITEMS);
        C03_QuickSort.quickSort1(mySortedArr1);
        Arrays.sort(systemSortedArr);

        assertArrayEquals(systemSortedArr, mySortedArr1);

        int[] mySortedArr2 = new int[NUM_OF_ITEMS];
        System.arraycopy(UN_SORTED_ARR, 0, mySortedArr2, 0, NUM_OF_ITEMS);
        C03_QuickSort.quickSort2(mySortedArr2);

        assertArrayEquals(systemSortedArr, mySortedArr2);

        int[] mySortedArr3 = new int[NUM_OF_ITEMS];
        System.arraycopy(UN_SORTED_ARR, 0, mySortedArr3, 0, NUM_OF_ITEMS);
        C03_QuickSort.quickSort2(mySortedArr3);
        assertArrayEquals(systemSortedArr, mySortedArr3);
    }
}
