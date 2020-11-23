package com.pro.dynamicProcess;

public class MaxSubArray {

    public int solution(int[] nums){

//        int[] dp = new int[array.length];
//
//        dp[0] = array[0];
//        int max = dp[0];
//        for (int i = 1; i < array.length; i++) {
//            if (dp[i - 1] > 0){
//                if (array[i] > 0){
//                    dp[i] = dp[i-1] + array[i];
//                }else {
//                    dp[i] = dp[i-1];
//                }
//
//            }else {
//                dp[i] = array[i];
//            }
//            max = Math.max(dp[i], max);
//        }
//        return max;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i=1;i<nums.length;i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }

        return max;

    }
}
