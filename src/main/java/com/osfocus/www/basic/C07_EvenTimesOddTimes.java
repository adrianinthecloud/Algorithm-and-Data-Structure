package com.osfocus.www.basic;

public class C07_EvenTimesOddTimes {
    // get the only one odd times occurrence number in an array.
    // Assumption: only one number has odd times occurrence, others are all even times occurrence
    public static int getOddTimesNum(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }

        return eor;
    }

    // get the only one odd times occurrence number in an array.
    // Assumption: only two numbers have odd times occurrence, others are all even times occurrence
    public static int[] getTwoOddTimesNumbers(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }

        int farRight = eor & ((~eor) + 1);
        int oneOfTheNum = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & farRight) != 0) {
                oneOfTheNum ^= arr[i];
            }
        }

        return new int[]{oneOfTheNum, (eor^oneOfTheNum)};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,3,2,99,5,1,1,99,99,100,202,100,5,202};
        System.out.println(getOddTimesNum(arr));

        int[] arr2 = new int[arr.length+1];
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        arr2[arr2.length-1] = 100;
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]);
            if (i != arr2.length-1) {
                System.out.print("-");
            }
        }
        System.out.println();
        int[] twoOddOcrNums = getTwoOddTimesNumbers(arr2);
        System.out.println("num1 = " + twoOddOcrNums[0] + " num2 = " + twoOddOcrNums[1]);
    }
}
