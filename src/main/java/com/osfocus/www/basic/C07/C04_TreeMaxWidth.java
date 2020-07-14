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

    public static void main(String[] args) {
        //       1
        //     2   3
        //    4 5    6
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.right = new Node (6);

    }
}
