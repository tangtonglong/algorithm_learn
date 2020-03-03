package com.pro.dynamicProcess;

import org.springframework.util.StopWatch;

/**
 * 最长公共子串/最长公共子序列
 *
 * 1143. 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 *
 *
 * 示例 1:
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 示例 3:
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 *
 *
 * 提示:
 *
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
        String text1 = "asdklaweioadjasdfwe";
        String text2 = "qerkadfgahrskdfsdkakkdf";
        StopWatch stopWatch = new StopWatch("longestCommonSubsequence");
        stopWatch.start("dp");
        System.out.println(longestCommonSubsequence(text1, text2));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    public static int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();
        int[][] b = new int[m][n];
        for ()
        return 0;
    }
}
