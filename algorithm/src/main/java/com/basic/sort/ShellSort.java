package com.basic.sort;

/**
 * @author : ttl
 * 2020/2/24 15:54
 * @return
 */
public class ShellSort {


    public static void main(String[] args) {
//        int[] nums = {9527, 242045, 3733001, 134000, 97, 25, 23, 98, 265};
        int[] nums = {23, 25, 98};
        int[] numsB = shellSort(nums, 0, nums.length - 1);
        for (int i = 0; i < numsB.length; i++) {
            System.out.println(numsB[i]);
        }


    }

    private static int[] shellSort(int[] nums, int i, int i1) {

        return nums;
    }
}
