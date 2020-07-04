package com.osfocus.www.basic.c05;

// Prefix tree working with [a-z] letters
public class C01_PrefixTree {
    private static class Node1 {
        public int pass;
        public int end;
        public Node1 nexts[];

        public Node1() {
            this.pass = 0;
            this.end = 0;
            this.nexts = new Node1[26];
        }
    }

    public static class PTree {
        public Node1 root;

        public PTree() {
            root = new Node1();
        }

        public void insert(String word) {
            char[] str = word.toCharArray();
            Node1 cur = root;
            cur.pass++;
            for (int i = 0; i < str.length; i++) {
                int index = str[i] - 'a';
                if (cur.nexts[index] == null) {
                    cur.nexts[index] = new Node1();
                }

                cur = cur.nexts[index];
                cur.pass++;
            }
            cur.end++;
        }

        public void print(Node1 node) {
            for (int i = 0; i < node.nexts.length; i++) {
                Node1 cur = node.nexts[i];
                if (cur != null) {
                    System.out.print(((char) ('a'+i))+"["+cur.pass+"]-");
                    print(cur);
                }
            }
        }

        public void remove(String word) {
            if (search(word) > 0) {
                char[] str = word.toCharArray();
                Node1 cur = root;
                cur.pass--;
                for (int i = 0, path = 0; i < str.length; i++) {
                    path = str[i] - 'a';
                    cur.nexts[path].pass--;
                    if (cur.nexts[path].pass == 0) {
                        cur.nexts[path] = null;
                        return;
                    }
                    cur = cur.nexts[path];
                }

                cur.end--;
            }
        }

        public int search(String word) {
            char[] str = word.toCharArray();
            Node1 cur = root;
            for (int i = 0, index = 0; i < str.length; i++) {
                index = str[i] - 'a';
                cur = cur.nexts[index];
                if (cur == null) return 0;
            }

            return cur.end;
        }

        public int numOfPrefix(String pre) {
            char[] str = pre.toCharArray();
            Node1 cur = root;
            for (int i = 0, index = 0; i < str.length; i++) {
                index = str[i] - 'a';
                cur = cur.nexts[index];
            }

            return cur.pass;
        }
    }
}
