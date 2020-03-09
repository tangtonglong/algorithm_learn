package com.basic.sort;

/**
 * @author : tangtonglong
 * 2020/2/17 17:36
 * @return
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] nums = {242045, 9527, 3733001, 134000, 97, 25, 23, 98, 265};

        int[] numsb = InsertSort.insertSort(nums);

        for (int i = 0; i < numsb.length; i++) {
            System.out.println(numsb[i]);
        }
    }

    /**
     * 插入排序
     *
     * @param nums
     * @return
     */
    private static int[] insertSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int tmpIndex = i + 1;
            int tmp = nums[tmpIndex];
            for (int j = i; j >= 0 && j < nums.length; j--) {
                if (tmp < nums[j]) {
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                } else {
                    System.out.println("stop:" + j);
                    break;
                }
            }

        }
        return nums;
    }


}
