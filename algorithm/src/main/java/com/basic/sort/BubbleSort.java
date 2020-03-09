package com.basic.sort;

/**
 * @author : tangtonglong
 * 2020/2/17 11:38
 * @return
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {9527, 242045, 3733001, 134000, 97, 25, 23, 98, 265};

        int[] numsb = BubbleSort.bubbleSort(nums);

        for (int i = 0; i < numsb.length; i++) {
            System.out.println(numsb[i]);
        }
    }

    /**
     * 冒泡排序
     *
     * @param nums
     * @return
     */
    public static int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        return nums;
    }
}
