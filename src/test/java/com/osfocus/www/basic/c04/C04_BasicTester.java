package com.osfocus.www.basic.c04;

import com.osfocus.www.basic.ArrayCommonUsage;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class C04_BasicTester {
    private static final int MAX_NUM = 10000;
    private static final int NUM_OF_ITEMS = 1000;
    private static final int[] UN_SORTED_ARR;

    static {
        UN_SORTED_ARR = new int[NUM_OF_ITEMS];
        for (int i = 0; i < NUM_OF_ITEMS; i ++) {
            UN_SORTED_ARR[i] = (int) ((MAX_NUM + 1) * Math.random());
        }
    }

    @Test
    public void HeapSortTest() {
        for (int i = 0; i < 100; i++) {
            int[] heapSortedArr = new int[NUM_OF_ITEMS];
            int[] systemSortedArr = new int[NUM_OF_ITEMS];
            System.arraycopy(UN_SORTED_ARR, 0, heapSortedArr, 0, NUM_OF_ITEMS);
            System.arraycopy(UN_SORTED_ARR, 0, systemSortedArr, 0, NUM_OF_ITEMS);

            Arrays.sort(systemSortedArr);
            HeapSort.sort(heapSortedArr);

            assertArrayEquals(systemSortedArr, heapSortedArr);
        }
    }
}
