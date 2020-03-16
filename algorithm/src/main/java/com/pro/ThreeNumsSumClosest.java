package com.pro;

import org.springframework.util.StopWatch;

import java.util.Arrays;

/**
 * @author : ttl
 * 2020/3/13 16:25
 * @return
 */
public class ThreeNumsSumClosest {

    public static void main(String[] args) {
//        int[] nums = {1,1,1,0};
        int[] nums = {-10,0,-2,3,-8,1,-10,8,-8,6,-7,0,-7,2,2,-5,-8,1,-4,6};
        int target = 18;
        ThreeNumsSumClosest threeNumsSumClosest = new ThreeNumsSumClosest();
        StopWatch stopWatch = new StopWatch("Fibonacci");
        stopWatch.start("threeNumsSumClosest");
        System.out.println(threeNumsSumClosest.threeSumClosest(nums, target));
        stopWatch.stop();
        stopWatch.start("threeSumClosestV2");
        System.out.println(threeNumsSumClosest.threeSumClosestV2(nums, target));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    private int threeSumClosestV2(int[] nums, int target) {
        return 0;
    }

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3){
            return 0;
        }
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[nums.length - 1];
        int closetDiv = Math.abs(closestSum - target);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int tmpSum = nums[i] + nums[left] + nums[right];
                if (tmpSum == target){
                    return target;
                }
                int tmpDiv = Math.abs(tmpSum - target);
                if (tmpDiv < closetDiv){
                    closetDiv = tmpDiv;
                    closestSum = tmpSum;
                }
                if (tmpSum > target){
                    right--;
                }else if (tmpSum < target){
                    left++;
                }
            }

        }
        return closestSum;
    }
}
