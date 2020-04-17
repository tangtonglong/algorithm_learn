package com.pro;

import org.springframework.util.StopWatch;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * @author : ttl
 * 2020/4/17 14:29
 * @return
 */
public class CanJump {

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,0,0,0,0,0,0,0};
//        int[] nums = new int[]{1,2,3};

        StopWatch stopWatch = new StopWatch("canJump");
        stopWatch.start("canJump");
        System.out.println(canJump(nums));
        stopWatch.stop();
        stopWatch.start("canJumpV2");
        System.out.println(canJumpV2(nums));
        stopWatch.stop();
        stopWatch.start("canJumpV3");
        System.out.println(canJumpV3(nums));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0){
            return false;
        }else if (nums.length == 1){
            return true;
        }else if (nums[0] == 0){
            return false;
        }
        boolean[] dp = new boolean[nums.length - 1];
        int index = nums.length - 2;
        while (index >= 0){
            if (index + nums[index] >= nums.length - 1){
                dp[index] = true;
            }else {
                int tmp = index + 1;
                while (tmp <= index + nums[index] && tmp <= nums.length - 2){
                    if (dp[tmp]){
                        dp[index] = true;
                        break;
                    }
                    tmp++;
                }
            }
            index--;
        }
        return dp[0];
    }

    public static boolean canJumpV2(int[] nums) {
        if (nums == null || nums.length == 0){
            return false;
        }else if (nums.length == 1){
            return true;
        }else if (nums[0] == 0){
            return false;
        }
        int index = 0;
        int maxIndex = nums[index] + index;
        while (maxIndex < nums.length ){
            int tmpMax = maxIndex;
            while (index <= maxIndex){
                if (index + nums[index] >= nums.length - 1){
                    return true;
                }else if (index + nums[index] > maxIndex){
                    tmpMax = index + nums[index];
                }
                index ++;
            }
            index = maxIndex;
            if (tmpMax == maxIndex){
                break;
            }
            maxIndex = tmpMax;
        }
        return maxIndex >= nums.length - 1;
    }

    public static boolean canJumpV3(int[] nums) {
        if (nums == null || nums.length == 0){
            return false;
        }
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxIndex){
                return false;
            }
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }
        return true;
    }
}
