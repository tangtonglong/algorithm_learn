package com.pro.dynamicProcess;

import org.springframework.util.StopWatch;

/**
 * 最长公共子串/最长公共子序列
 * <p>
 * 1143. 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * <p>
 * 若这两个字符串没有公共子序列，则返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 * <p>
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 示例 3:
 * <p>
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * 输入的字符串只含有小写英文字符。
 *
 * @author : ttl
 * 2020/3/3 11:36
 * @return
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "bsbininmk";
        String text2 = "jmjkbkjkv";
        StopWatch stopWatch = new StopWatch("longestCommonSubsequence");
        stopWatch.start("dp");
        System.out.println(longestCommonSubsequence(text1, text2));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    /**
     * lcs(x(i),y(j))=
     * 1. lcs(x(i-1), y(j-1)) + 1 , x(i) = y(j)
     * 2. max( lcs(x(i-1), y(j)), lcs(x(i), y(j-1)) ) , x(i) != y(j)
     * 3. 0 , i=-1或j=-1
     *
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2) {

        int[][] lcs = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {

            for (int j = 0; j < text2.length(); j++) {
                if (i - 1 >= 0 && j - 1 >= 0 && text1.charAt(i) == text2.charAt(j)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else if (i == 0 || j == 0) {
                    if (i == 0 && j != 0) {
                        if (text2.indexOf(text1.charAt(i)) >= 0 && text2.indexOf(text1.charAt(i)) <= j) {
                            lcs[i][j] = 1;
                        } else {
                            lcs[i][j] = 0;
                        }
                    } else if (i != 0 && j == 0) {
                        if (text1.indexOf(text2.charAt(j)) >= 0 && text1.indexOf(text2.charAt(j)) <= i) {
                            lcs[i][j] = 1;
                        } else {
                            lcs[i][j] = 0;
                        }
                    } else if (i == 0 && j == 0) {
                        if (text1.charAt(i) == text2.charAt(j)) {
                            lcs[i][j] = 1;
                        } else {
                            lcs[i][j] = 0;
                        }
                    }
                } else if (text1.charAt(i) != text2.charAt(j)) {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        System.out.print("  :");
        for (int i = 0; i < text2.length(); i++) {
            System.out.print(text2.charAt(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < lcs.length; i++) {
            System.out.print(text1.charAt(i) + " :");
            for (int j = 0; j < lcs[0].length; j++) {
                System.out.print(lcs[i][j]+" ");
            }
            System.out.println();
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = text1.length() - 1;
        int j = text2.length() - 1;
        while (i >= 0 && j >= 0 && lcs[i][j] > 0) {
            if (text1.charAt(i) == text2.charAt(j)) {
                stringBuilder.append(text1.charAt(i));
                i--;
                j--;
            } else if (i - 1 >= 0 && j - 1 >= 0 && lcs[i - 1][j] > lcs[i][j - 1]) {
                i--;
            } else if (i - 1 >= 0 && j - 1 >= 0 && lcs[i][j - 1] > lcs[i - 1][j]) {
                j--;
            } else if (i - 1 >= 0 && j - 1 >= 0 && lcs[i - 1][j] == lcs[i][j - 1]) {
                i--;
            } else if (i == 0 && j >= 0 && lcs[i][j] > 0){
                if (text1.charAt(i) == text2.charAt(j)){
                    stringBuilder.append(text1.charAt(i));
                }
                j--;
            }else if (i >= 0 && j==0 && lcs[i][j] > 0){
                if (text1.charAt(i) == text2.charAt(j)){
                    stringBuilder.append(text1.charAt(i));
                }
                i--;
            }else {
                break;
            }
        }
        System.out.println("lcs: " + stringBuilder.reverse().toString());
        return lcs[text1.length() - 1][text2.length() - 1];
    }
}
