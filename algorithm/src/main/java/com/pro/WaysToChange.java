package com.pro;

import org.springframework.util.StopWatch;

/**
 *
 * 硬币
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 *
 * 示例1:
 *
 *  输入: n = 5
 *  输出：2
 *  解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * 示例2:
 *
 *  输入: n = 10
 *  输出：4
 *  解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 * 说明：
 *
 * 注意:
 *
 * 你可以假设：
 *
 * 0 <= n (总金额) <= 1000000
 *
 * @author : ttl
 * 2020/4/23 14:45
 * @return
 */
public class WaysToChange {

    public static void main(String[] args) {
        int start = 786;
        StopWatch stopWatch = new StopWatch("waysToChange");
        stopWatch.start("waysToChange");
        System.out.println(waysToChange(start));
        stopWatch.stop();
        stopWatch.start("waysToChangeV2");
        System.out.println(waysToChangeV2(start));
        stopWatch.stop();
        stopWatch.start("waysToChange");
        System.out.println(waysToChange(start));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    public static int waysToChange(int n) {
        int oneMax = n;
        int fiveMax = n / 5;
        int tenMax = n / 10;
        int twentyFiveMax = n / 25;
        int count = 0;
        for (int i = 0; i <= oneMax; i++) {
            for (int j = 0; j <= fiveMax; j++) {
                for (int k = 0; k <= tenMax; k++) {
                    for (int l = 0; l <= twentyFiveMax; l++) {
                        if (i + 5 * j + 10 * k + 25 * l == n){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static int waysToChangeV2(int n) {
        int[] dp = new int[n + 1];
        int x = getNWays(n, dp);
        return x;
    }

    public static int getNWays(int n, int[] dp){
        if (n < 0){
            return  0;
        }else if (n == 0){
            dp[n] = 0;
            return  1;
        }else if (n >=1 && n < 5){
            dp[n] = 1;
        }else if (n >=5 && n < 10){
            dp[n] = 2;
        }else if (n >=10 && n < 15){
            dp[n] = 4;
        }else if (n >=15 && n < 20){
            dp[n] = 6;
        }else if (n >=20 && n < 25){
            dp[n] = 9;
        }else if (n == 25){
            dp[n] = 13;
        }
        dp[n] = getNWays(n-25,dp) + getNWays(n-10, dp) + getNWays(n-5, dp) + getNWays(n-1, dp);
        return dp[n];
    }
}
