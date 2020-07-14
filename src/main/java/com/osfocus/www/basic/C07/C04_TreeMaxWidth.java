package com.osfocus.www.basic.C07;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class C04_TreeMaxWidth {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int maxWidthUseMap(Node head) {
        if (head == null) return 0;

        Map<Node, Integer> levelMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        levelMap.put(head, 1);
        queue.add(head);

        int curLevel = 1;
        int curLevelNodes = 0;

        int max = 0;
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int curNodeLevel = levelMap.get(curNode);

            if (curNode.left != null) {
                queue.add(curNode.left);
                levelMap.put(curNode.left, curNodeLevel + 1);
            }

            if (curNode.right != null) {
                queue.add(curNode.right);
                levelMap.put(curNode.right, curNodeLevel + 1);
            }

            if (curNodeLevel == curLevel) {
                curLevelNodes++;
            } else {
                max = Math.max(curLevelNodes, max);
                curLevelNodes = 1;
                curLevel = curNodeLevel;
            }
        }

        max = Math.max(curLevelNodes, max);
        return max;
    }

    public static int maxWidthWithoutMap(Node head) {
        if (head == null) return 0;

        int max = 0;
        int curLevelNodes = 0;
        Node curEnd = head;
        Node nextEnd = null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            if (curNode.left != null) {
                queue.add(curNode.left);
                nextEnd = curEnd.left;
            }

            if (curNode.right != null) {
                queue.add(curNode.right);
                nextEnd = curEnd.right;
            }

            curLevelNodes++;

            if (curNode == curEnd) {
                curEnd = nextEnd;
                max = Math.max(curLevelNodes, max);
                curLevelNodes = 0;
            }
        }

        return max;
    }

    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    private static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel) return null;

        Node head = new Node((int) ((maxValue + 1) * Math.random()));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);

        return head;
    }
}
