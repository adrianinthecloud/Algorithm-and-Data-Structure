package com.osfocus.www.basic.C07;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C07_BasicTest {
    @Test
    public void UnRecursiveTraversalBTTest() {
        PrintStream oldOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        C02_UnRecursiveTraversalBT.Node head = new C02_UnRecursiveTraversalBT.Node(1);
        head.left = new C02_UnRecursiveTraversalBT.Node(2);
        head.right = new C02_UnRecursiveTraversalBT.Node(3);
        head.left.left = new C02_UnRecursiveTraversalBT.Node(4);
        head.left.right = new C02_UnRecursiveTraversalBT.Node(5);
        head.right.left = new C02_UnRecursiveTraversalBT.Node(6);
        head.right.right = new C02_UnRecursiveTraversalBT.Node(7);

        C02_UnRecursiveTraversalBT.pre(head);

        System.setOut(oldOut);
        String output = new String(baos.toByteArray());

        assertEquals("pre-order: 1 2 4 5 3 6 7 \n", output);

        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        C02_UnRecursiveTraversalBT.in(head);

        System.setOut(oldOut);
        output = new String(baos.toByteArray());
        assertEquals("in-order: 4 2 5 1 6 3 7 \n", output);

        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        C02_UnRecursiveTraversalBT.pos1(head);
        System.setOut(oldOut);
        output = new String(baos.toByteArray());
        assertEquals("pos-order1: 4 5 2 6 7 3 1 \n", output);

        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        C02_UnRecursiveTraversalBT.pos2(head);
        System.setOut(oldOut);
        output = new String(baos.toByteArray());
        assertEquals("pos-order2: 4 5 2 6 7 3 1 \n", output);
    }

    @Test
    public void LevelTraversalTest() {
        C03_LevelTraversalBT.Node head = new C03_LevelTraversalBT.Node(1);
        head.left = new C03_LevelTraversalBT.Node(2);
        head.right = new C03_LevelTraversalBT.Node(3);
        head.left.left = new C03_LevelTraversalBT.Node(4);
        head.left.right = new C03_LevelTraversalBT.Node(5);
        head.right.left = new C03_LevelTraversalBT.Node(6);
        head.right.right = new C03_LevelTraversalBT.Node(7);

        PrintStream oldOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        C03_LevelTraversalBT.level(head);

        String output = new String(baos.toByteArray());

        assertEquals("1 2 3 4 5 6 7 \n", output);
    }

    @Test
    public void TreeMaxWidthTest() {
        C04_TreeMaxWidth.Node head = new C04_TreeMaxWidth.Node(1);
        head.left = new C04_TreeMaxWidth.Node(2);
        head.right = new C04_TreeMaxWidth.Node(3);
        head.left.left = new C04_TreeMaxWidth.Node(4);
        head.left.right = new C04_TreeMaxWidth.Node(5);
        head.right.right = new C04_TreeMaxWidth.Node(6);

        assertEquals(3, C04_TreeMaxWidth.maxWidthUseMap(head));
        assertEquals(3, C04_TreeMaxWidth.maxWidthWithoutMap(head));

        int maxLevel = 10;
        int maxValue = 10000;
        int testCases = 1000;
        for (int i = 0; i < testCases; i++) {
            C04_TreeMaxWidth.Node bst = C04_TreeMaxWidth.generateRandomBST(maxLevel, maxValue);
            assertEquals(C04_TreeMaxWidth.maxWidthUseMap(head), C04_TreeMaxWidth.maxWidthWithoutMap(head));
        }
    }

    @Test
    public void SerializeAndReconstructTreeTest() {
        //        8
        //    5       10
        //   3 6     9  11
        //  1   7
        C05_SerializeAndReconstructTree.Node head = new C05_SerializeAndReconstructTree.Node(8);
        head.left = new C05_SerializeAndReconstructTree.Node(5);
        head.right = new C05_SerializeAndReconstructTree.Node(10);
        head.left.left = new C05_SerializeAndReconstructTree.Node(3);
        head.left.right = new C05_SerializeAndReconstructTree.Node(6);
        head.left.left.left= new C05_SerializeAndReconstructTree.Node(1);
        head.left.right.right = new C05_SerializeAndReconstructTree.Node(7);
        head.right.left = new C05_SerializeAndReconstructTree.Node(9);
        head.right.right = new C05_SerializeAndReconstructTree.Node(11);
        C05_SerializeAndReconstructTree.prePrintTree(head);

        Queue<String> res = new LinkedList<>();
        Queue<String> res2 = new LinkedList<>();
        C05_SerializeAndReconstructTree.pre(head, res);
        C05_SerializeAndReconstructTree.levelSerialize(head, res2);
        System.out.println();
        for (String str : res) {
            System.out.print(str + " ");
        }

        System.out.println();
        for (String str : res2) {
            System.out.print(str + " ");
        }

        C05_SerializeAndReconstructTree.Node levelDeserializedHead = C05_SerializeAndReconstructTree.levelDeserialize(res2);


        System.out.println();
        C05_SerializeAndReconstructTree.Node resume = C05_SerializeAndReconstructTree.preB(res);
        System.out.println("Resume: ");
        C05_SerializeAndReconstructTree.prePrintTree(resume);

        assertTrue(C05_SerializeAndReconstructTree.equals(head, resume));
        assertTrue(C05_SerializeAndReconstructTree.equals(head, levelDeserializedHead));
    }
}
