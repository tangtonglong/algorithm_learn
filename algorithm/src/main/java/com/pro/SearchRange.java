package com.pro;

public class SearchRange {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        solution2(nums, target);
    }

    public static int[] solution1(int[] nums, int target){
        int[] indexs = new int[2];
        int first = -1;
        int last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                first = first > 0 ? Math.min(first, i) : i;
                last = last > 0 ? Math.max(last, i) : i;
            }
        }
        indexs[0] = first;
        indexs[1] = last;
        return indexs;

    }

    public static int[] solution2(int[] nums, int target){

        int[] indexs = new int[2];
        indexs[0] = getFirst(nums, target, 0, nums.length);
        indexs[1] = getLast(nums, target, 0, nums.length);
        return indexs;
    }

    public static int getFirst(int[] nums, int target, int start, int end){
        if (start>end){
            return -1;
        }
        int middle = (start + end) / 2;
        int middleData = nums[middle];
        if (middleData == target){
            if (middle == 0 || (middle > 0 && nums[middle - 1] != target)){
                return middle;
            }else {
                end = middle - 1;
            }
        }else if (middleData > target){
            end = middle - 1;
        }else {
            start = middle + 1;
        }
        return getFirst(nums, target, start, end);
    }

    public static int getLast(int[] nums, int target, int start, int end){
        if (start>end){
            return -1;
        }
        int middle = (start + end) / 2;
        int middleData = nums[middle];
        if (middleData == target){
            if (middle == nums.length - 1 || (middle < nums.length && nums[middle + 1] != target)){
                return middle;
            }else {
                start = middle + 1;
            }
        }else if (middleData > target){
            end = middle - 1;
        }else {
            start = middle + 1;
        }
        return getLast(nums, target, start, end);
    }
}
