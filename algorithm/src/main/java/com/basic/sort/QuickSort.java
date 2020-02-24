package com.basic.sort;

/**
 * @author : ttl
 * 2020/2/19 10:49
 * @return
 */
public class QuickSort {


    public static void main(String[] args) {
//        int[] nums = {9527, 242045, 3733001, 134000, 97, 25, 23, 98, 265};
        int[] nums = {23, 25, 98};
        int[] numsB = quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < numsB.length; i++) {
            System.out.println(numsB[i]);
        }


    }

    private static int[] quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int privot = getPrivot(nums, start, end);

            quickSort(nums, start, privot - 1);

            quickSort(nums, privot + 1, end);
        }
        return nums;
    }

    public static int getPrivot(int[] nums, int start, int end) {
        int tmpStart = start;
        int tmpEnd = end;
        if (tmpStart < tmpEnd && tmpEnd >= start && tmpStart <= end) {

            int privot = tmpStart;
            while (tmpStart < tmpEnd) {
                while (tmpEnd >= start && tmpEnd >= tmpStart && nums[tmpEnd] >= nums[privot]) {
                    tmpEnd--;
                }
                if (tmpEnd >= tmpStart) {
                    int tmp = nums[privot];
                    nums[privot] = nums[tmpEnd];
                    nums[tmpEnd] = tmp;
                    privot = tmpEnd;
                } else {
                    return tmpStart;
                }

                while (tmpStart <= end && tmpStart <= tmpEnd && nums[tmpStart] <= nums[privot]) {
                    tmpStart++;
                }
                if (tmpStart <= tmpEnd) {
                    int tmp = nums[privot];
                    nums[privot] = nums[tmpStart];
                    nums[tmpStart] = tmp;
                    privot = tmpStart;
                } else {
                    return tmpEnd;
                }
            }
            if (tmpStart == tmpEnd) {
                return tmpStart;
            }
            return privot;
        } else {
            return start;
        }
    }

}
