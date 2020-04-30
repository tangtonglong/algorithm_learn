package com.pro;

import org.springframework.util.StopWatch;

import java.util.HashMap;

/**
 *
 * 只出现一次的数字 II
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 *
 * @author : ttl
 * 2020/4/28 16:04
 * @return
 */
public class SingleNumber2 {

    public static void main(String[] args){
//        int[] nums = {4,5,6,7,0,1,2,4,5,6,7,0,1,2,25,26};
        int[] nums = {4,4,6};
        StopWatch stopWatch = new StopWatch("singleNumber2");
        stopWatch.start("singleNumber2");
        System.out.println(singleNumber2(nums));
        stopWatch.stop();
        stopWatch.start("singleNumber2");
        System.out.println(singleNumber2(nums));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        for (int i = 0; i < 0; i++) {
            System.out.println(i);
        }
    }

    public static int singleNumber2(int[] nums) {

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
