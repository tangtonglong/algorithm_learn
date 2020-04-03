package com.pro;

import org.springframework.util.StopWatch;

import java.util.Arrays;

/**
 * @author : ttl
 * 2020/4/3 19:33
 * @return
 */
public class CheckPermutation {

    public static void main(String[] args) {

        String a = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZZYXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcbaZYXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcbaZYXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcbababcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZZYXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcbaZYXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcbaZYXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcbab";
        String b = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZZYXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcbaZYXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcbaZYXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcbaaabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZZYXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcbaZYXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcbaZYXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcbab";
        StopWatch stopWatch = new StopWatch("checkPermutation");
        stopWatch.start("checkPermutation");
        System.out.println(checkPermutation(a, b));
        stopWatch.stop();
        stopWatch.start("checkPermutationV2");
        System.out.println(checkPermutationV2(a, b));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    public static boolean checkPermutation(String s1, String s2) {
        if ((s1 == null && s2 == null) || (s1.length() == 0 && s2.length() == 0)) {
            return true;
        } else if (s1.length() != s2.length()) {
            return false;
        }
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);
        for (int i = 0; i < s1Array.length; i++) {
            if (s1Array[i] != s2Array[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 有问题例如：
     * abab 和 bdbd
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkPermutationV2(String s1, String s2) {
        if ((s1 == null && s2 == null) || (s1.length() == 0 && s2.length() == 0)) {
            return true;
        } else if (s1.length() != s2.length()) {
            return false;
        }
        int result = 0;
        for (int i = 0; i < s1.length(); i++) {
            result ^= s1.codePointAt(i) ^ s2.codePointAt(i);
        }
        return result == 0;
    }
}
