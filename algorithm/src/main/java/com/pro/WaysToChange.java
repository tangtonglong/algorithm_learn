package com.pro;

import org.springframework.util.StopWatch;

/**
 * 硬币
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 * <p>
 * 示例1:
 * <p>
 * 输入: n = 5
 * 输出：2
 * 解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * 示例2:
 * <p>
 * 输入: n = 10
 * 输出：4
 * 解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 * 说明：
 * <p>
 * 注意:
 * <p>
 * 你可以假设：
 * <p>
 * 0 <= n (总金额) <= 1000000
 *
 * @author : ttl
 * 2020/4/23 14:45
 * @return
 */
public class WaysToChange {

    public static void main(String[] args) {
        int start = 25;
        StopWatch stopWatch = new StopWatch("waysToChange");
        stopWatch.start("waysToChange");
        System.out.println(waysToChange(start));
        stopWatch.stop();
//        stopWatch.start("waysToChangeV2");
//        System.out.println(waysToChangeV2(start));
//        stopWatch.stop();
        stopWatch.start("waysToChangeV3");
        System.out.println(waysToChangeV3(start));
        stopWatch.stop();
        stopWatch.start("waysToChangeV4");
        System.out.println(waysToChangeV4(start));
        stopWatch.stop();
        stopWatch.start("waysToChangeV5");
        System.out.println(waysToChangeV5(start));
        stopWatch.stop();
        stopWatch.start("waysToChangeV6");
        System.out.println(waysToChangeV6(start));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    public static int waysToChange(int n) {
        int twentyFiveMax = n / 25;
        int count = 0;
        for (int i = 0; i <= twentyFiveMax; i++) {
            int tmp = n - 25 * i;
//            for (int j = 0; j <= tmp / 10; j++) {
//                int tmp2 = tmp - 10 * j;
////                for (int k = 0; k <= tmp2 / 5; k++) {
////                    count++;
////                }
//                count += tmp2/5 + 1;
//            }
            count = (count + (((tmp / 5 + 1 + (tmp % 10) / 5 + 1) * (tmp / 10 + 1)) / 2));
        }
        return count;
    }

    public static int waysToChangeV2(int n) {
        int twentyFiveMax = n / 25;
        int count = 0;
        for (int i = 0; i <= twentyFiveMax; i++) {
            int tmp = n - 25 * i;
            for (int j = 0; j <= tmp / 10; j++) {
                int tmp2 = tmp - 10 * j;
                for (int k = 0; k <= tmp2 / 5; k++) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int waysToChangeV3(int n) {
        int twentyFiveMax = n / 25;
        int count = 0;
        for (int i = 0; i <= twentyFiveMax; i++) {
            int tmp = n - 25 * i;
            for (int j = 0; j <= tmp / 10; j++) {
                int tmp2 = tmp - 10 * j;
                count += tmp2 / 5 + 1;
            }
        }
        return count;
    }

    public static int waysToChangeV4(int n) {
        int twentyFiveMax = n / 25;
        int count = 0;
        for (int i = 0; i <= twentyFiveMax; i++) {
            int tmp = n - 25 * i;
            count += (((tmp / 5 + 1 + (tmp % 10) / 5 + 1) * (tmp / 10 + 1)) / 2);
        }
        return count;
    }

    public static  int waysToChangeV5(int n){
        int[] coins = new int[]{1,5,10,25};
        int[][] dp = new int[4][n+1];

        for (int i = 0; i < 4; i++) {
            int k = n/coins[i];

            for (int j = k; j >= 0 ; j--) {
                if (i==0){
                    dp[i][j] = 1;
                }else {
                    for (int l = 0; l <= n - j*coins[i]; ) {
                        dp[i][n - j*coins[i]] += dp[i-1][l];
                        l += coins[i];
                    }
                }
            }
        }
        return dp[3][n];
    }

    public static  int waysToChangeV6(int n){
        int[] coins = new int[]{1,5,10,25};
        int[] dp = new int[n+1];

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= n ; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[n];
    }

}
