package com;

public class Test {

    public static void main(String[] args) {

    }

    public void solution(int[] nums1, int[] nums2, int k){

        int p1 = 0;
        int p2 = nums2.length - 1;
        int tmpK = 0;
        while (p1 < nums1.length && p2 >= 0 && tmpK < k){

            if (nums1[p1] < nums2[p2]){
                System.out.printf(nums1[p1] + "");
                //p1移动到第一个和当前nums[p1]不相等位置
                p1 = moveIndex(nums1, p1, true);
            }else if (nums1[p1] == nums2[p2]){
                System.out.printf(nums1[p1] + "");
                //p1移动到第一个和当前nums1[p1]不相等位置
                p1 = moveIndex(nums1, p1, true);
                //p2 移动到第一个和当前nums2[p1]不相等位置
                p2 = moveIndex(nums2, p2, false);
            }else {
                System.out.printf(nums2[p2] + "");
                //p2移动到第一个和当前nums2[p2]不相等位置
                p2 = moveIndex(nums2, p2, false);
            }
            tmpK++;
        }
        //数组到头（或者尾）还不够K个数字
        return;
    }

    /**
     *
     * @param nums
     * @param sourceIndex
     * @param positve true:向后找，false：向前找
     * @return
     */
    public static int moveIndex(int[] nums, int sourceIndex, boolean positve){

        int tmp = nums[sourceIndex];
        if (positve){
            for (int i = sourceIndex + 1; i < nums.length; i++) {
                if (nums[i] != tmp){
                    return i;
                }
            }
            //边界判断
        }else {
            for (int i = sourceIndex - 1; i > 0; i++) {
                if (nums[i] != tmp){
                    return i;
                }
            }
            //边界判断
        }
        return -1;
    }
}
