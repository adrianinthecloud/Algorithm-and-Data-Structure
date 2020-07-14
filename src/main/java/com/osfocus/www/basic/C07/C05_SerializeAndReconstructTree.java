package com.osfocus.www.basic.C07;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class C05_SerializeAndReconstructTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return value == node.value;
        }
    }

    public static Queue<String> preSerial(Node head) {
        Queue<String> res = new LinkedList<>();
        pre(head, res);

        return res;
    }

    public static void pre(Node head, Queue<String> res) {
        if (head == null) {
            res.add(null);
        } else {
            res.add(String.valueOf(head.value));
            pre(head.left, res);
            pre(head.right, res);
        }
    }

    public static Node preB(Queue<String> preQueue) {
        String curNodeStr = preQueue.poll();
        if (curNodeStr == null) {
            return null;
        }

        Node curNode = new Node(Integer.valueOf(curNodeStr));
        curNode.left = preB(preQueue);
        curNode.right = preB(preQueue);
        return curNode;
    }

    public static Queue<String> levelSerialize(Node head, Queue<String> res) {
        if (head == null) {
            res.add(null);
        } else {
            Queue<Node> nodeQueue = new LinkedList<>();
            nodeQueue.add(head);
            res.add(String.valueOf(head.value));

            while (!nodeQueue.isEmpty()) {
                head = nodeQueue.poll();

                if (head.left != null) {
                    nodeQueue.add(head.left);
                    res.add(String.valueOf(head.left.value));
                } else {
                    res.add(null);
                }

                if (head.right != null) {
                    nodeQueue.add(head.right);
                    res.add(String.valueOf(head.right.value));
                } else {
                    res.add(null);
                }
            }
        }

        return res;
    }

    public static Node levelDeserialize(Queue<String> levelSerializedList) {
        if (levelSerializedList == null | levelSerializedList.size() == 0) return null;

        Node head = buildNode(levelSerializedList.poll());
        if (head == null) {
            return null;
        }
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(head);

        while (!nodeQueue.isEmpty()) {
            Node curNode = nodeQueue.poll();

            curNode.left = buildNode(levelSerializedList.poll());
            curNode.right = buildNode(levelSerializedList.poll());

            if (curNode.left != null) {
                nodeQueue.add(curNode.left);
            }

            if (curNode.right != null) {
                nodeQueue.add(curNode.right);
            }
        }

        return head;
    }

    public static Node buildNode(String value) {
        if (value == null) {
            return null;
        } else {
            return new Node(Integer.valueOf(value));
        }
    }

    public static void prePrintTree(Node head) {
        System.out.print("Print Tree: [ ");
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print(head.value + " ");

            if (head.right != null) {
                stack.push(head.right);
            }

            if (head.left != null) {
                stack.push(head.left);
            }
        }
        System.out.print("]\n");
    }

    public static boolean equals(Node n1, Node n2) {
        if (n1 == null && n2 == null) return true;

        if (n1 == null) return false;
        if (n2 == null) return false;

        if (!n1.equals(n2)) return false;

        return equals(n1.left, n2.left) && equals(n1.right, n2.right);
    }
}
