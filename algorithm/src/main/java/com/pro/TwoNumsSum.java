package com.pro;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @author : ttl
 * 2020/2/24 16:05
 * @return
 */
public class TwoNumsSum {

    public static void main(String[] args) {
        int[] nums = {9527, 242045, 3733001, 134000, 97, 25, 23, 98, 265};
//        int[] nums = {23, 25, 98};
        int target = 48;
        int[] numsB = twoSum2(nums, target);
        for (int i = 0; i < numsB.length; i++) {
            System.out.println(numsB[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> tmpMap = new HashMap(nums.length);
        int[] indexs = new int[2];
        for (int i = 0 ;i < nums.length; i++){
            tmpMap.put(nums[i], i);
        }
        for (int i = 0;i < nums.length; i++){
            int tmp = target - nums[i];
            if (tmpMap.containsKey(tmp) && tmpMap.get(tmp).compareTo(i) != 0){
                indexs[0] = i;
                indexs[1] = tmpMap.get(tmp);
                return indexs;
            }
        }
        return indexs;
    }

    public static int[] twoSum2(int[] nums, int target) {

        HashMap<Integer, Integer> tmpMap = new HashMap(nums.length);
        for (int i = 0 ;i < nums.length; i++){
            int tmp = target - nums[i];
            if (tmpMap.containsKey(tmp) && tmpMap.get(tmp) != i){
                return new int[] {tmpMap.get(tmp), i};
            }
            tmpMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
