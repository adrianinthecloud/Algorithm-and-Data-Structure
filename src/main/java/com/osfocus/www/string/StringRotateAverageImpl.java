package com.osfocus.www.string;

/***
 * Date: 2020-06-23
 * Desc: This is the average implementation of rotating String in O(n)
 */
public class StringRotateAverageImpl {
    public static String rotate(String s, int breakpos) {
        if (breakpos <= 0 || breakpos >= s.length()) {
            return s;
        }
        return process(s.toCharArray(), 0, breakpos - 1, s.length() - 1);
    }

    public static String process(char[] str, int L, int M, int R) {
        reverse(str, L, M);
        reverse(str, M + 1, R);
        reverse(str, L, R);
        return String.valueOf(str);
    }

    public static void reverse(char[] str, int L, int R) {
        while (L < R) {
            char tmp = str[L];
            str[L++] = str[R];
            str[R--] = tmp;
        }
    }

    public static void main(String args[]) {
        String firstStrTest = "abcd"; // expect the result to be cdab
        String secondStrTest = "abcdef"; // expect the result to be efabcd
        String thirdTest = "efabcd"; // expect the result to be abcdef

        System.out.println(firstStrTest + " after rotate starting at pos " + 2 + " has result = " + rotate(firstStrTest, 2));
        System.out.println(secondStrTest + " after rotate starting at pos " + 4 + " has result = " + rotate(secondStrTest, 4));
        System.out.println(thirdTest + " after rotate starting at pos " + 2 + " has result = " + rotate(thirdTest, 2));
    }
}
