package com.pro;

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
//        String a = "cwziydanrqvsdtvnnqgjnbrvvwxwqojeqgxhwxdoktjktulemwpbeqscbbtbfvkxsrjetfdrovcrdwzfmnnihtgxybuairswfewvpuscocqifuwylhssldpjrawqdrbvkykpaggspbfrulcktpbofchzikhzxhpocgvdbwpewpywsgqbczmamprklaoovcfecwchhmsaqkhvuvvzjblmgvqpqtnlipgqsanvovylpmxlmxvymppdykphhaamtxjnnlsqfwjwhyywgurteaummwhvavxbcpgrfffxrowluqmqjaugryxdmwvyokdcfcvcytxpixbvwrdgzctejdoaavgtezexmvxgrkpnayvfarkyoruofqmpnsqdzojxqrjsnfwsbzjmaoigytygukqlrcqaxazvmytgfghdczvzphfdbnxtklaiqqsotavdmhiaermluafheowcobjqmrkmlzyas";
        String a = "ac";
        System.out.println(force(a));
        System.out.println(longestPalindrome(a));
    }

    /**
     * dp 算法
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        long start = System.currentTimeMillis();
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
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return res;
    }

    /**
     * 暴力法
     * 超时
     * @param s
     * @return
     */
    public static String force(String s) {
        long start = System.currentTimeMillis();
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
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return s.substring(tmpStart, tmpEnd);
    }
}
