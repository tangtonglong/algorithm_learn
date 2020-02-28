package com.pro;

import org.springframework.util.StopWatch;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author : ttl
 * 2020/2/25 16:33
 * @return
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String a = "cwziydanrqvsdtvnnqgjnbrvvwxwqojeqgxhwxdoktjktulemwpbeqscbbtbfvkxsrjetfdrovcrdwzfmnnihtgxybuairswfewvpuscocqifuwylhssldpjrawqdrbvkykpaggspbfrulcktpbofchzikhzxhpocgvdbwpewpywsgqbczmamprklaoovcfecwchhmsaqkhvuvvzjblmgvqpqtnlipgqsanvovylpmxlmxvymppdykphhaamtxjnnlsqfwjwhyywgurteaummwhvavxbcpgrfffxrowluqmqjaugryxdmwvyokdcfcvcytxpixbvwrdgzctejdoaavgtezexmvxgrkpnayvfarkyoruofqmpnsqdzojxqrjsnfwsbzjmaoigytygukqlrcqaxazvmytgfghdczvzphfdbnxtklaiqqsotavdmhiaermluafheowcobjqmrkmlzyas";
//        String a = "ac";
        StopWatch watch = new StopWatch("测试运行时间");
        watch.start("force");
        System.out.println(force(a));
        watch.stop();
        watch.start("dp");
        System.out.println(longestPalindrome(a));
        watch.stop();
        watch.start("mancher");
        System.out.println(mancher(a));
        watch.stop();
        System.out.println(watch.prettyPrint());
    }

    /**
     * 暴力法
     * 超时
     * @param s
     * @return
     */
    public static String force(String s) {
        if (s == null || s.length() <= 0) {
            return "";
        }
        int tmpStart = 0;
        int tmpEnd = 1;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String tmp = new StringBuffer(s.substring(i, j)).reverse().toString();
                if (tmp.equals(s.substring(i, j))) {
                    if (maxLength < (j - i)) {
                        maxLength = j - i;
                        tmpStart = i;
                        tmpEnd = j;
                    }
                }
            }
        }
        return s.substring(tmpStart, tmpEnd);
    }

    /**
     * dp 算法
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return "";
        }else if (s.length() == 1){
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        String res = s.substring(0, 1);
        dp[s.length() - 1][s.length() - 1] = true;
        for (int i = s.length() - 2; i>=0; i--){
            dp[i][i] = true;
            for (int j = i + 1 ; j < s.length(); j++){
                if ( j - i == 1){
                    //aa,ab 类型
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else if (j - i > 1){
                    //abc , aba 类型
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]);
                }
                if (dp[i][j] && j - i + 1 > res.length()){
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }


    public static String longestPalindromeV2(String s) {
        return s;
    }


    /**
     * mancher算法
     * @param s
     * @return
     */
    public static String mancher(String s){
        String T = preProcess(s);
        int n = T.length();
        int[] P = new int[n];
        int C = 0, R = 0;
        for (int i = 1; i < n - 1; i++) {
            int i_mirror = 2 * C - i;
            if (R > i) {
                P[i] = Math.min(R - i, P[i_mirror]);// 防止超出 R
            } else {
                P[i] = 0;// 等于 R 的情况
            }

            // 碰到之前讲的三种情况时候，需要利用中心扩展法
            while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                P[i]++;
            }

            // 判断是否需要更新 R
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }

        }

        // 找出 P 的最大值
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLen) / 2; //最开始讲的求原字符串下标
        return s.substring(start, start + maxLen);
    }

    public static String preProcess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        String ret = "^";
        for (int i = 0; i < n; i++)
            ret += "#" + s.charAt(i);
        ret += "#$";
        return ret;
    }

}
