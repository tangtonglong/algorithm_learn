package com.pro;

import java.util.LinkedList;

public class MoveZeroes {


    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
//        int[] nums = {1,0};
//        int[] nums = {1};
//        solution(nums);
        solution3(nums);
    }

    /**
     * 283. 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     *
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     *
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     * @param nums
     */
    private static void solution(int[] nums) {
        int zeroStart = 0;
        int zeroCount = 0;
        while (zeroStart < nums.length) {
            if (nums[zeroStart] != 0){
                zeroStart++;
                continue;
            }
            zeroCount += 1;
            int noZeroStart = zeroStart + zeroCount;
            while (noZeroStart < nums.length && nums[noZeroStart] == 0){
                noZeroStart++;
                zeroCount ++;
            }
            while (noZeroStart < nums.length && nums[noZeroStart] != 0 && zeroCount > 0){
                nums[zeroStart] = nums[noZeroStart];
                nums[noZeroStart] = 0;
                zeroStart++;
                noZeroStart++;
                zeroCount--;
            }
            if (noZeroStart >= nums.length){
                return;
            }
            zeroCount = 0;
        }
    }

    public static void solution2(int[] nums){
        int p1 = 0;
        int p2 = 0;
        while (p1 < nums.length && p2 < nums.length){
            while (p1 < nums.length && nums[p1] != 0){
                p1++;
            }
            p2 = p1;
            while (p2 < nums.length && nums[p2] == 0){
                p2++;
            }
            while (p1 < nums.length && p2 < nums.length && p1 < p2 && nums[p2] != 0){
                nums[p1] = nums[p2];
                nums[p2] = 0;
                p1++;
                p2++;
            }
        }
    }

    public static void solution3(int[] nums){
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (0 != nums[fast]){
                if (slow != fast){
                    nums[slow] = nums[fast];
                }
                slow++;
            }
        }
        while (slow < nums.length){
            nums[slow] = 0;
            slow++;
        }
    }
}
