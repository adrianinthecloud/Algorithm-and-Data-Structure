package com.osfocus.www.basic.c05;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class C05_BasicTester {
    @Test
    public void PrefixTreeTest() {
        String str = "abc";
        C01_PrefixTree.PTree tree = new C01_PrefixTree.PTree();
        tree.insert(str);
        tree.insert(str);
        assertEquals(2, tree.numOfPrefix(str));
        assertEquals(2, tree.search("abc"));
        tree.insert("abcd");
        assertEquals(3, tree.numOfPrefix(str));
        tree.remove(str);

        tree.insert("bacd");
        assertEquals(1, tree.search("abc"));
        assertEquals(2, tree.numOfPrefix(str));
        assertEquals(1, tree.search("bacd"));
    }

    @Test
    public void PrefixTreeForAllCharsTest() {
        String str = "abcX";
        C02_PrefixTreeForAllChars.PTree2 tree = new C02_PrefixTreeForAllChars.PTree2();
        tree.insert(str);
        tree.insert(str);
        assertEquals(2, tree.search(str));
        assertEquals(2, tree.numOfPrefix(str));
        tree.insert(".abcX");
        assertEquals(2, tree.numOfPrefix(str));
        tree.remove(str);
        assertEquals(1, tree.numOfPrefix(str));
        tree.insert("abcPWC");
        assertEquals(2, tree.numOfPrefix("abc"));
        assertEquals(0, tree.search("abcx"));
    }

    @Test
    public void CountSortTest() {
        int maxNum = 200;
        int maxSize = 200;

        int[] arr = new int[maxSize];

        for (int i = 0; i < maxSize; i++) {
            arr[i] = (int) ((maxNum + 1) * Math.random());
        }

        int[] systemSortedArr = new int[arr.length];

        System.arraycopy(arr, 0, systemSortedArr, 0, arr.length);
        Arrays.sort(systemSortedArr);
        C03_CountSort.countSort(arr);

        assertArrayEquals(systemSortedArr, arr);
    }

    @Test
    public void RadixSortTest() {
        int maxNum = 200;
        int maxSize = 200;

        for (int k = 0; k < 100; k++) {
            int[] arr = new int[maxSize];

            for (int i = 0; i < maxSize; i++) {
                arr[i] = (int) ((maxNum + 1) * Math.random());
            }

            int[] systemSortedArr = new int[arr.length];

            System.arraycopy(arr, 0, systemSortedArr, 0, arr.length);
            Arrays.sort(systemSortedArr);
            C04_RadixSort.radixSort(arr);

            assertArrayEquals(systemSortedArr, arr);
        }
    }
}
