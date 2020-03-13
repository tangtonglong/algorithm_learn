package com.pro;

import org.springframework.util.StopWatch;

import java.util.*;

/**
 *
 *  三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * @author : ttl
 * 2020/3/12 17:53
 * @return
 */
public class ThreeNumSum {

    public static void main(String[] args) {
        int[] nums = {-1, -1, 2, 9527, -1, -1, 2, 0, 0, 0, 0, 0, 0};
//        int[] nums = {-2,0,1,1,2};
        StopWatch stopWatch = new StopWatch("Fibonacci");
        stopWatch.start("threeSum");
        System.out.println(threeSum(nums));
        stopWatch.stop();
        stopWatch.start("threeSumV2");
        System.out.println(threeSumV2(nums));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    /**
     * 很蠢的用了一个set 来去重
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if (nums == null || nums.length < 3 || nums[0] > 0 || nums[nums.length - 1] < 0) {
            return null;
        }
        List<List<Integer>> outerList = new LinkedList<List<Integer>>();
        //用一个set来去重
        Set<String> numsSet = new HashSet<String>();
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] == 0) {
                    List<Integer> tmpIntList = new LinkedList<Integer>();
                    tmpIntList.add(nums[left]);
                    tmpIntList.add(nums[i]);
                    tmpIntList.add(nums[right]);
                    //由于数组排过序了，所以 一定有 num[i] <= nums[left] <= nums[right]
                    //这3个数字拼接到一块，判断 numsSet 中是否已经有这个组合了
                    String tmpStr = nums[i] + "_" + nums[left] + "_" + nums[right];
                    if (!numsSet.contains(tmpStr)){
                        numsSet.add(tmpStr);
                        outerList.add(tmpIntList);
                    }
                    left++;
                    right--;
                } else if (nums[left] + nums[right] + nums[i] > 0) {
                    right--;
                } else if (nums[left] + nums[right] + nums[i] < 0) {
                    left++;
                }
            }
        }
        return outerList;
    }

    /**
     *
     * 本题的难点在于如何去除重复解。
     *
     * 算法流程：
     * 特判，对于数组长度 nn，如果数组为 nullnull 或者数组长度小于 33，返回 [][]。
     * 对数组进行排序。
     * 遍历排序后数组：
     * 若 nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果。
     * 对于重复元素：跳过，避免出现重复解
     * 令左指针 L=i+1，右指针 R=n−1，当 L<R 时，执行循环：
     * 当 nums[i] + nums[L] + nums[R] == 0，执行循环，
     * 判断左界和右界是否和下一位置重复
     * nums[L] == nums[L+1] 会导致结果重复，应该跳过，L++，
     * nums[R] == nums[R−1] 会导致结果重复，应该跳过，R--
     * 去除重复解。
     * 并同时将 L,R 移到下一位置，寻找新的解
     *
     * 若和大于 0，说明 nums[R] 太大，R 左移
     * 若和小于 0，说明 nums[L] 太小，L 右移
     * 复杂度分析
     * 时间复杂度：O(n^2)，数组排序 O(N * log N)，遍历数组 O(n)，双指针遍历 O(n)，总体 O(NlogN)+O(n)∗O(n)，O(n^2)
     * 空间复杂度：O(1)
     *
     * 作者：zhu_shi_fu
     * 链接：https://leetcode-cn.com/problems/3sum/solution/pai-xu-shuang-zhi-zhen-zhu-xing-jie-shi-python3-by/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSumV2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> outerList = new LinkedList<List<Integer>>();
        if (nums == null || nums.length < 3 || nums[0] > 0 || nums[nums.length - 1] < 0) {
            return outerList;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0){
                //当进行到 nums[i] > 0时已经不可能了
                return outerList;
            }
            if (i > 0 && nums[i] == nums[i-1]){
                //（去重）值相同的项已经跑过了不用重复跑；
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] == 0) {
                    List<Integer> tmpIntList = new LinkedList<Integer>();
                    tmpIntList.add(nums[left]);
                    tmpIntList.add(nums[i]);
                    tmpIntList.add(nums[right]);
                    outerList.add(tmpIntList);
                    while (left<right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while (left<right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                } else if (nums[left] + nums[right] + nums[i] > 0) {
                    right--;
                } else if (nums[left] + nums[right] + nums[i] < 0) {
                    left++;
                }
            }
        }
        return outerList;
    }
}
