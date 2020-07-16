package com.osfocus.www.basic.c08;

public class C04_IsBalanced {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isBalanced1(Node head) {
        return process1(head).isBalanced;
    }

    public static Info process1(Node head) {
        if (head == null) {
            return new Info(true, 0);
        }

        Info leftInfo = process1(head.left);
        Info rightInfo = process1(head.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        if (!leftInfo.isBalanced || !rightInfo.isBalanced || (Math.abs(leftInfo.height - rightInfo.height) > 1)) {
            return new Info(false, height);
        }

        return new Info(true, height);
    }

    public static class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}
