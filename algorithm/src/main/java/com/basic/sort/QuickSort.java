package com.basic.sort;

/**
 * @author : ttl
 * 2020/2/19 10:49
 * @return
 */
public class QuickSort {


    public static void main(String[] args){
        int[] nums = {9527,242045,3733001,134000, 97, 25, 23, 98, 265};
        int[] numsB = quickSort(nums);
        for (int i = 0; i < numsB.length; i++){
            System.out.println(numsB[i]);
        }
    }

    private static int[] quickSort(int[] nums) {

        return nums;
    }

    public int end2st(int[] nums, int privot, int end){
        if (privot < end){
            for (int i = end;i<privot;i--){
                if (nums[i] < nums[privot]){

                }
            }
        }

    }

    public int st2end(int[] nums, int start, int privot){
        if (start < privot){

        }
    }
}
