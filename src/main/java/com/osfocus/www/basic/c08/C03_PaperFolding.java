package com.osfocus.www.basic.c08;

// print out the state of crease on folding paper from bottom to top
public class C03_PaperFolding {
    public static void printPaperFolding(int curLevel, int N, boolean isConcave) {
        if (curLevel > N) return;

        printPaperFolding(curLevel + 1, N, true);
        System.out.println(isConcave ? "Concave" : "Convex");
        printPaperFolding(curLevel + 1, N, false);
    }

    public static void main(String[] args) {
        printPaperFolding(1, 3, true);
    }
}
