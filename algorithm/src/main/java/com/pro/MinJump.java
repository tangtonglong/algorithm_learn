package com.pro;

import org.springframework.util.StopWatch;


/**
 * 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * @author : ttl
 * 2020/4/17 17:00
 * @return
 */
public class MinJump {

    public static void main(String[] args) {
        int[] nums = new int[]{90,5,0,0,0,4,0,0,0};
//        int[] nums = new int[]{2,3,1,1,4};

        StopWatch stopWatch = new StopWatch("canJump");
        stopWatch.start("jump");
        System.out.println(jump(nums));
        stopWatch.stop();
        stopWatch.start("jumpV2");
        System.out.println(jumpV2(nums));
        stopWatch.stop();
        stopWatch.start("jumpV3");
        System.out.println(jumpV3(nums));
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
                boolean haveMoreThanZero = false;
                for (int i = index + 1; i <= tmpIndex && i < dp.length; i++) {
                    if (dp[i] == 1){
                        haveMoreThanZero = true;
                        tmpFoots = 1;
                        break;
                    }else if (dp[i] > 1){
                        haveMoreThanZero = true;
                        if (tmpFoots == 0){
                            tmpFoots = dp[i];
                        }else {
                            tmpFoots = Math.min(tmpFoots, dp[i]);
                        }
                    }
                }
                if (haveMoreThanZero){
                    dp[index] = tmpFoots + 1;
                }
            }
            index--;
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i]);
        }
        return dp[0];
    }

    public static int jumpV2(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        int count = 0;
        int start = 0;
        int end = 1;
        while (start < nums.length && end < nums.length){
            int tmpIndex = end;
            for (int i = start; i < end; i++) {
                if (nums[i] + i >= nums.length - 1){
                    return count++;
                }
                tmpIndex = Math.max(tmpIndex, nums[i] + i);
            }
            count++;
            start = end;
            end = tmpIndex + 1;
        }
        return count;
    }

    public static int jumpV3(int[] nums){
        int count = 0;
        int endIndex = 0;
        int nextEnd = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            nextEnd = Math.max(nums[i] + i, nextEnd);
            if (i == endIndex){
                endIndex = nextEnd;
                count++;
            }
        }
        return count;
    }
}
