package com.osfocus.www.basic.c03;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertArrayEquals;

public class StrategyTest {
    private final int MAX_SIZE = 20;
    private final int MAX_NUM = 1000;

    @Test
    public void test() {
        Integer[] unSortedArr = new Integer[MAX_SIZE];
        Integer[] systemSortedArr = new Integer[unSortedArr.length];
        for (int i = 0; i < MAX_SIZE; i++) {
            unSortedArr[i] = Integer.valueOf((int) ((MAX_NUM + 1) * Math.random()));
        }

        System.arraycopy(unSortedArr, 0, systemSortedArr, 0, unSortedArr.length);

        MergeSortStrategyPattern<Integer> mergeSort = new MergeSortStrategyPattern<>();
        mergeSort.sort(unSortedArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        Arrays.sort(systemSortedArr);

        assertArrayEquals(systemSortedArr, unSortedArr);
    }
}
