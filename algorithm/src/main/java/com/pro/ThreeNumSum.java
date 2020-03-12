package com.pro;

import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : ttl
 * 2020/3/12 17:53
 * @return
 */
public class ThreeNumSum {

    public static void main(String[] args) {
        int[] nums = {9527, 242045, 3733001, 134000, 97, 25, 23, 98, 265};
        StopWatch stopWatch = new StopWatch("Fibonacci");
        stopWatch.start("threeSum");
        System.out.println(threeSum(nums));
        stopWatch.stop();
        stopWatch.start("threeSum");
        System.out.println(threeSum(nums));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);


        List<List<Integer>> outerList = new LinkedList<List<Integer>>();

        return outerList;
    }
}
