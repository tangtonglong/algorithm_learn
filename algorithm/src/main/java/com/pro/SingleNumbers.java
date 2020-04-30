package com.pro;

import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 *
 * 限制：
 *
 * 2 <= nums <= 10000
 *
 * @author : ttl
 * 2020/4/28 11:58
 * @return
 */
public class SingleNumbers {

    public static void main(String[] args){
//        int[] nums = {4,5,6,7,0,1,2,4,5,6,7,0,1,2,25,26};
        int[] nums = {4,1,4,6};
        StopWatch stopWatch = new StopWatch("singleNumbers");
        stopWatch.start("singleNumbers");
        System.out.println(singleNumbers(nums));
        stopWatch.stop();
        stopWatch.start("singleNumbers");
        System.out.println(singleNumbers(nums));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());

    }

    public static int[] singleNumbers(int[] nums) {
        int[] index = new int[2];
        List<Integer> integerList = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 1;) {
            if (i <= nums.length - 2 && (nums[i]^nums[i+1]) == 0){
                i += 2;
            }else if ( i == nums.length - 1 || (i <= nums.length - 3 && (nums[i]^nums[i+1]) != 0 && (nums[i+1]^nums[i+2]) ==0)){
                integerList.add(nums[i]);
                if (integerList.size() == 2){

                    index[0] = integerList.get(0);
                    index[1] = integerList.get(1);
                    return index;
                }
                i += 3;
            }else if ( (i == nums.length - 2 && (nums[i] ^ nums[i+1]) != 0) ||(i <= nums.length - 3 && (nums[i] ^ nums[i+1]) != 0 && (nums[i+1] ^ nums[i+2]) != 0)){
                index[0] = nums[i];
                index[1] = nums[i + 1];
                return index;
            }
        }
        index[0] = integerList.get(0);
        index[1] = integerList.get(1);
        return index;
    }
}
