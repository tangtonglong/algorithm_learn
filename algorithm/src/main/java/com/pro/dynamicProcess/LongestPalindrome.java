package com.pro.dynamicProcess;

public class LongestPalindrome {


    public String longestPalindrome(String s) {

        if (s == null || s.length() < 2){
            return "";
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int maxLength = 1;
        int begin = 0;
        for (int j = 1; j< s.length(); j++){
            for (int i = 0; i< j; i++){
                if (s.charAt(i) != s.charAt(j) ){
                    dp[i][j] = false;
                }else {
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && maxLength < (j - i + 1)){
                    maxLength = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLength );
    }
}
