package com.osfocus.www.basic.c08;

// find the max size of sub BST with a given head node
// need to know:
// 1. whether a subtree is balance or not;
// 2. max BST size of a subtree;
// 3. min and max value of a subtree.
public class C05_MaxSubBSTSize {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class Info {
        public boolean isBalanced;
        public int maxSize;
        public int min;
        public int max;

        public Info(boolean isBalanced, int maxSize, int min, int max) {
            this.isBalanced = isBalanced;
            this.maxSize = maxSize;
            this.min = min;
            this.max = max;
        }
    }

    public static int getMaxBSTSize(Node head) {
        return process1(head).maxSize;
    }

    private static Info process1(Node node) {
        if (node == null) {
            return null;
        }

        Info leftInfo = process1(node.left);
        Info rightInfo = process1(node.right);

        boolean isBalanced = false;
        int maxSize = 0;
        int min = node.value;
        int max = node.value;
        if (leftInfo != null) {
            min = Math.min(leftInfo.min, min);
            max = Math.max(leftInfo.max, max);
            maxSize = leftInfo.maxSize;
        }

        if (rightInfo != null) {
            min = Math.min(rightInfo.min, min);
            max = Math.max(rightInfo.max, max);
            maxSize = Math.max(rightInfo.maxSize, maxSize);
        }

        if (((leftInfo == null) ? true : leftInfo.isBalanced && leftInfo.max < node.value) &&
                ((rightInfo == null) ? true : rightInfo.isBalanced && node.value < rightInfo.min)) {
            maxSize = (leftInfo != null ? leftInfo.maxSize : 0) +
                        (rightInfo != null ? rightInfo.maxSize : 0) + 1;
            isBalanced = true;
        }

        return new Info(isBalanced, maxSize, min, max);
    }
}
