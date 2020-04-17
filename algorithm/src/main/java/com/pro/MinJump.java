package com.pro;

import org.springframework.util.StopWatch;

/**
 * @author : ttl
 * 2020/4/17 17:00
 * @return
 */
public class MinJump {

    public static void main(String[] args) {
        int[] nums = new int[]{90,5,0,0,0,4,0,0,0};
//        int[] nums = new int[]{1,2,3};

        StopWatch stopWatch = new StopWatch("canJump");
        stopWatch.start("jump");
        System.out.println(jump(nums));
        stopWatch.stop();
        stopWatch.start("jumpV2");
        System.out.println(jump(nums));
        stopWatch.stop();
        stopWatch.start("jumpV3");
        System.out.println(jump(nums));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }


    public static int jump(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        int[] dp = new int[nums.length - 1];
        int index = nums.length - 2;
        if (index + nums[index] >= nums.length - 1){
            dp[index] = 1;
        }
        while (index >= 0){
            if (index + nums[index] >= nums.length - 1){
                dp[index] = 1;
            }else {
                int tmpIndex = index + nums[index];
                int tmpFoots = 0;
                for (int i = index + 1; i <= tmpIndex && i < dp.length; i++) {
                    if (dp[i] == 1){
                        tmpFoots = 1;
                    }else if (dp[i] > 1){
                        tmpFoots =
                    }
                }
                if (dp[index] > 0){
                    dp[index]++;
                }
            }

            index--;
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i]);
        }
        return dp[0];
    }
}
