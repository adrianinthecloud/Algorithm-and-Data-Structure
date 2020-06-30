package com.osfocus.www.basic;

import com.osfocus.www.basic.c01.*;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class C01BasicTester {
    private static final int NUM_OF_INT = 100;
    private static final int[] unsortArr1;
    private static final int[] unsortArr2;
    private static final int[] sortArr1;
    private static final int[] sortArr2;

    static {
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

    @Test
    public void testBSExist() {
        int num1 = sortArr1[(int) ((NUM_OF_INT)*Math.random())];
        int num2 = sortArr2[(int) ((NUM_OF_INT)*Math.random())];
        assertEquals(C04_BSExist.slowCheckExist(sortArr1, num1),
                     C04_BSExist.exist(sortArr1, num1));
        assertEquals(C04_BSExist.slowCheckExist(sortArr2, num2),
                     C04_BSExist.exist(sortArr2, num2));
    }

    @Test
    public void testBSNearLeft() {
        int num1 = sortArr1[(int) ((NUM_OF_INT)*Math.random())];
        int num2 = sortArr2[(int) ((NUM_OF_INT)*Math.random())];

        assertEquals(C05_BSNearLeft.test(sortArr1, num1),
                     C05_BSNearLeft.nearestIndex(sortArr1, num1));
        assertEquals(C05_BSNearLeft.test(sortArr2, num2),
                     C05_BSNearLeft.nearestIndex(sortArr2, num2));
    }

    @Test
    public void testBSLocalMin() {
        int[] arr = new int[]{1,2};
        assertEquals(0, C06_BSLocalMin.getLocalMinIndex(arr));

        int[] arr2 = new int[]{5,3,1,7,9};
        assertEquals(2, C06_BSLocalMin.getLocalMinIndex(arr2));

        int[] arr3 = new int[]{9,8,1,3};
        assertEquals(2, C06_BSLocalMin.getLocalMinIndex(arr3));

        int[] arr4 = new int[]{9,8,3,2};
        assertEquals(3, C06_BSLocalMin.getLocalMinIndex(arr4));

        int[] arr5 = new int[]{9,8,3,2,1,0};
        assertEquals(5, C06_BSLocalMin.getLocalMinIndex(arr5));
    }

    @Test
    public void testEventTimesOddTimes() {
        int[] arr = new int[]{3,2,3,2,99,5,1,1,99,99,100,202,100,5,202};
        assertEquals(99, C07_EvenTimesOddTimes.getOddTimesNum(arr));

        int[] arr2 = new int[arr.length+1];
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        arr2[arr2.length-1] = 100;

        int[] twoOddOcrNums = C07_EvenTimesOddTimes.getTwoOddTimesNumbers(arr2);
        assertArrayEquals(new int[]{99,100}, twoOddOcrNums);
    }
}
