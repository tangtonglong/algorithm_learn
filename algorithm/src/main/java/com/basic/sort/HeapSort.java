package com.basic.sort;

/**
 * @author : tangtonglong
 * 2020/3/1 18:40
 * @return
 */
public class HeapSort {

    public static void main(String[] args){
        int[] nums = {242045,9527,3733001,134000, 97, 25, 23, 98, 265};

        int[] numsb = HeapSort.bigMergeSort(nums);

        for (int i = 0; i < numsb.length; i++){
            System.out.println(numsb[i]);
        }
    }

    /**
     * 堆排序(大)
     * @param nums
     * @return
     */
    private static int[] bigMergeSort(int[] nums) {

        return nums;
    }


    /**
     * 堆排序(小)
     * @param nums
     * @return
     */
    private static int[] smallMergeSort(int[] nums) {

        return nums;
    }
}
