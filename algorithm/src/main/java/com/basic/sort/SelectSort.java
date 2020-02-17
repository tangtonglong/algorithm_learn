package com.basic.sort;

/**
 * @author : tangtonglong
 * 2020/2/17 17:09
 * @return
 */
public class SelectSort {

    public static void main(String[] args){
        int[] nums = {9527,242045,3733001,134000, 97, 25, 23, 98, 265};
        int[] numsB = selectSort(nums);
        for (int i = 0; i < numsB.length; i++){
            System.out.println(numsB[i]);
        }
    }

    /**
     * 选择排序
     * @param nums
     * @return
     */
    public static int[] selectSort(int[] nums){
        for (int i = 0 ; i < nums.length; i++){
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++){
                if (nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                int tmp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = tmp;
            }
        }
        return nums;
    }
}
