package com.basic.sort;

/**
 * @author : tangtonglong
 * 2020/3/1 18:40
 * @return
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {242045, 9527, 3733001, 134000, 97, 25, 23, 98, 265};

        int[] numsb = MergeSort.mergeSort(nums);

        for (int i = 0; i < numsb.length; i++) {
            System.out.println(numsb[i]);
        }
    }

    /**
     * 归并排序
     *
     * @param nums
     * @return
     */
    private static int[] mergeSort(int[] nums) {
        return nums;
    }
}
