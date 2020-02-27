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
        String a = "cwziydanrqvsdtvnnqgjnbrvvwxwqojeqgxhwxdoktjktulemwpbeqscbbtbfvkxsrjetfdrovcrdwzfmnnihtgxybuairswfewvpuscocqifuwylhssldpjrawqdrbvkykpaggspbfrulcktpbofchzikhzxhpocgvdbwpewpywsgqbczmamprklaoovcfecwchhmsaqkhvuvvzjblmgvqpqtnlipgqsanvovylpmxlmxvymppdykphhaamtxjnnlsqfwjwhyywgurteaummwhvavxbcpgrfffxrowluqmqjaugryxdmwvyokdcfcvcytxpixbvwrdgzctejdoaavgtezexmvxgrkpnayvfarkyoruofqmpnsqdzojxqrjsnfwsbzjmaoigytygukqlrcqaxazvmytgfghdczvzphfdbnxtklaiqqsotavdmhiaermluafheowcobjqmrkmlzyas";
        System.out.println(force(a));
    }

    public static String longestPalindrome(String s) {

        return s;
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
}
