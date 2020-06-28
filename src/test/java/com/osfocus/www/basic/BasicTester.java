package com.osfocus.www.basic;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BasicTester {
    private static final int NUM_OF_INT = 100;
    private static final int MAX_NUM = 1000;
    private static final int[] unsortArr1;
    private static final int[] unsortArr2;
    private static final int[] sortArr1;
    private static final int[] sortArr2;

    static {
//        Random r = new Random();
//        for (int i = 0; i < NUM_OF_INT; i++) {
//            unsortArr1[i] = r.nextInt(MAX_NUM);
//            unsortArr2[i] = r.nextInt(MAX_NUM);
//        }
        unsortArr1 = generateRandomArray();
        unsortArr2 = generateRandomArray();

        sortArr1 = unsortArr1.clone();
        sortArr2 = unsortArr2.clone();
        Arrays.sort(sortArr1);
        Arrays.sort(sortArr2);
    }

    public static int[] generateRandomArray() {
        int[] arr = new int[NUM_OF_INT];
        for (int i = 0; i < NUM_OF_INT; i++) {
            arr[i] = (int) ((NUM_OF_INT+1) * Math.random()) - (int) ((NUM_OF_INT+1) * Math.random());
        }

        return arr;
    }

    @Test
    public void testSelectionSort() {
        int[] c01SelectionSortResult1 = unsortArr1.clone();
        int[] c01SelectionSortResult2 = unsortArr2.clone();
        C01_SelectionSort.selectionSort(c01SelectionSortResult1);
        C01_SelectionSort.selectionSort(c01SelectionSortResult2);
        assertArrayEquals(sortArr1, c01SelectionSortResult1);
        assertArrayEquals(sortArr2, c01SelectionSortResult2);
    }

    @Test
    public void testBubbleSort() {
        int[] c02BubbleSortResult1 = unsortArr1.clone();
        int[] c02BubbleSortResult2 = unsortArr2.clone();
        C02_BubbleSort.bubbleSort(c02BubbleSortResult1);
        C02_BubbleSort.bubbleSort(c02BubbleSortResult2);
        assertArrayEquals(sortArr1, c02BubbleSortResult1);
        assertArrayEquals(sortArr2, c02BubbleSortResult2);
    }

    @Test
    public void testInsertionSort() {
        int[] c03InsertionSortResult1 = unsortArr1.clone();
        int[] c03InsertionSortResult2 = unsortArr2.clone();
        C03_InsertionSort.insertionSort(c03InsertionSortResult1);
        C03_InsertionSort.insertionSort(c03InsertionSortResult2);
        assertArrayEquals(sortArr1, c03InsertionSortResult1);
        assertArrayEquals(sortArr2, c03InsertionSortResult2);
    }
}
