package com.osfocus.www.basic.c05;

import java.util.HashMap;

public class C02_PrefixTreeForAllChars {
    private static class Node2 {
        public int pass;
        public int end;
        public HashMap<Integer, Node2> nexts;

        public Node2() {
            this.pass = 0;
            this.end = 0;
            this.nexts = new HashMap<>();
        }
    }

    public static class PTree2 {
        private Node2 root;

        public PTree2() {
            this.root = new Node2();
        }

        public void insert(String word) {
            char[] str = word.toCharArray();
            Node2 cur = root;
            cur.pass++;
            for (int i = 0, path = 0; i < str.length; i++) {
                path = (int) str[i];
                if (!cur.nexts.containsKey(path)) {
                    cur.nexts.put(path, new Node2());
                }
                cur = cur.nexts.get(path);
                cur.pass++;
            }

            cur.end++;
        }

        public void remove(String word) {
            if (search(word) > 0) {
                char[] str = word.toCharArray();
                Node2 cur = root;
                cur.pass--;
                for (int i = 0, path = 0; i < str.length; i++) {
                    path = (int) str[i];
                    if (--cur.nexts.get(path).pass == 0) {
                        cur.nexts.remove(path);
                        return;
                    } else {
                        cur = cur.nexts.get(path);
                    }
                }
                cur.end--;
            }
        }

        public int search(String word) {
            char[] str = word.toCharArray();
            Node2 cur = root;
            for (int i = 0, path = 0; i < str.length; i++) {
                path = (int) str[i];
                if (cur.nexts.get(path) == null) {
                    return 0;
                } else {
                    cur = cur.nexts.get(path);
                }
            }

            return cur.end;
        }

        public int numOfPrefix(String pre) {
            char[] str = pre.toCharArray();
            Node2 cur = root;
            for (int i = 0, path = 0; i < str.length; i++) {
                path = (int) str[i];
                cur = cur.nexts.get(path);
                if (cur == null) return 0;
            }

            return cur.pass;
        }
    }
}
