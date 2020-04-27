package com.pro;

import org.springframework.util.StopWatch;

/**
 * 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * @author : ttl
 * 2020/4/27 10:57
 * @return
 */
public class SearchNums {

    public static void main(String[] args){
        int target = 0;
        int[] nums = {4,5,6,7,0,1,2};
        StopWatch stopWatch = new StopWatch("search");
        stopWatch.start("search");
        System.out.println(search(nums, target));
        stopWatch.stop();
        stopWatch.start("searchV2");
        System.out.println(searchV2(nums, target));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
//        for (int i = 0; i < 500; i++) {
//            System.out.print(" " + i + ",");
//        }
//
//        for (int i = 2000; i < 3000; i++) {
//            System.out.print(" " + i + ",");
//        }
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return  -1;
        }
        return findX(nums, target, 0, nums.length - 1);
    }

    public static int findX(int[] nums, int target, int start, int end){

        if (start > end){
            return -1;
        }
        if (nums[start] == target){
            return start;
        }
        if (nums[end] == target){
            return end;
        }
        int privot = (start + end) / 2;
//        System.out.println(nums[privot]);
        if (nums[privot] == target){
            return privot;
        }
        if (nums[privot] > nums[start] && nums[privot] > nums[end]){
            if (target > nums[start] && target < nums[privot]){
                return findX(nums, target, start, privot - 1);
            }else if (target > nums[privot] && target > nums[end]){
                return findX(nums, target, privot + 1, end);
            }else if (target < nums[privot] && target < nums[end]){
                return findX(nums, target, privot + 1, end);
            } else{
                //其实是 elseif (target > nums[end] && target < nums[start])
                return -1;
            }
        }else if(nums[privot] < nums[start] && nums[privot] < nums[end]){
            //其实是
            if (target > nums[start] && target > nums[privot]){
                return findX(nums, target, start, privot - 1);
            }else if (target < nums[start] && target < nums[privot]){
                return findX(nums, target, start, privot - 1);
            } else if (target > nums[privot] && target < nums[end]){
                return findX(nums, target, privot + 1, end);
            }else{
                //其实是 else if(target > nums[end] && target < nums[start])
                return -1;
            }
        }else{
            // if (nums[privot] > nums[start] && nums[privot] < nums[end])
            if (target > nums[start] && target < nums[privot]){
                return findX(nums, target, start, privot - 1);
            }else{
                // if (target > nums[privot] && target < nums[end])
                return findX(nums, target, privot + 1, end);
            }
        }
    }

    public static int searchV2(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return  -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int tmpPrivot = (start + end) / 2;
            if (nums[tmpPrivot] == target){
                return tmpPrivot;
            }
            if (nums[tmpPrivot] > nums[start]){
                if (target >= nums[start] && target < nums[tmpPrivot]){
                    end = tmpPrivot - 1;
                }else {
                    start = tmpPrivot + 1;
                }
            }else{
                if (target > nums[tmpPrivot] && target <= nums[end]){
                    start = tmpPrivot + 1;
                }else {
                    end = tmpPrivot - 1;
                }
            }
        }
        return -1;
    }
}
