package com.pro;

import org.springframework.util.StopWatch;

import java.util.*;

/**
 * @author : ttl
 * 2020/3/16 16:39
 * @return
 */
public class FourNumSum {

    public static void main(String[] args) {
        int[] nums = {-1, -5, -5, -3, 2, 5, 0, 4};
//        int[] nums = {-2,0,1,1,2};

        int target = -7;
        StopWatch stopWatch = new StopWatch("fourSum");
        stopWatch.start("fourSum");
        System.out.println(fourSum(nums, target));
        stopWatch.stop();
        stopWatch.start("fourSumV2");
        System.out.println(fourSumV2(nums, target));
        stopWatch.stop();
        stopWatch.start("fourSumV3");
        System.out.println(fourSumV3(nums, target));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> resultList = new LinkedList<List<Integer>>();

        if (nums == null || nums.length < 4) {
            return resultList;
        }
        Arrays.sort(nums);
        Set<String> numsSet = new HashSet<String>();
        for (int j = 0; j < nums.length - 3; j++) {
            //负数时可能不符合
//            if (nums[j] > target){
//                //当进行到 nums[j] > target 时已经不可能了
//                System.out.println("j:" + j);
//                return resultList;
//            }
            if (j > 0 && nums[j] == nums[j - 1] && nums[j] == nums[j + 1]) {
                System.out.println("continue j:" + j);
                continue;
            }
            for (int i = j + 1; i < nums.length - 2; i++) {
                //负数时可能不符合
//                if (nums[i] > target - nums[j]){
//                    //当进行到 nums[i] > target 本轮i已经不可能了
//                    System.out.println("nums[i] = [" + nums[i] + "], target = [" + target + "]" + "target - nums[j]" + (target - nums[j]));
//                    break;
//                }
                if (i - j > 1 && nums[i] == nums[i - 1]) {
                    //（去重）值相同的项已经跑过了不用重复跑；
                    continue;
                }
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] + nums[i] == (target - nums[j])) {
                        String tmpString = nums[j] + "_" + nums[i] + "_" + nums[left] + "_" + nums[right];
                        if (!numsSet.contains(tmpString)) {
                            numsSet.add(tmpString);
                            List<Integer> tmpIntList = new LinkedList<Integer>();
                            tmpIntList.add(nums[j]);
                            tmpIntList.add(nums[i]);
                            tmpIntList.add(nums[left]);
                            tmpIntList.add(nums[right]);
                            resultList.add(tmpIntList);
                        }
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] + nums[i] > target - nums[j]) {
                        right--;
                    } else if (nums[left] + nums[right] + nums[i] < target - nums[j]) {
                        left++;
                    }
                }
            }
        }
        System.out.println("end");
        return resultList;
    }

    public static List<List<Integer>> fourSumV2(int[] nums, int target) {

        List<List<Integer>> resultList = new LinkedList<List<Integer>>();

        if (nums == null || nums.length < 4) {
            return resultList;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j - i > 1 && nums[j] == nums[j - 1]) {
                    //（去重）值相同的项已经跑过了不用重复跑；
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] == target) {
                        List<Integer> tmpIntList = new LinkedList<Integer>();
                        tmpIntList.add(nums[i]);
                        tmpIntList.add(nums[j]);
                        tmpIntList.add(nums[left]);
                        tmpIntList.add(nums[right]);
                        resultList.add(tmpIntList);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right--;
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    }
                }
            }
        }
        return resultList;
    }

    public static List<List<Integer>> fourSumV3(int[] nums, int target) {
        /*定义一个返回值*/
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        /*当数组为null或元素小于4个时，直接返回*/
        if (nums == null || nums.length < 4) {
            return result;
        }
        /*对数组进行从小到大排序*/
        Arrays.sort(nums);
        /*数组长度*/
        int length = nums.length;
        /*定义4个指针k，i，j，h  k从0开始遍历，i从k+1开始遍历，留下j和h，j指向i+1，h指向数组最大值*/
        for (int k = 0; k < length - 3; k++) {
            /*当k的值与前面的值相等时忽略*/
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
            int min1 = nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
            if (min1 > target) {
                break;
            }
            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
            int max1 = nums[k] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (max1 < target) {
                continue;
            }
            /*第二层循环i，初始值指向k+1*/
            for (int i = k + 1; i < length - 2; i++) {
                /*当i的值与前面的值相等时忽略*/
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                /*定义指针j指向i+1*/
                int j = i + 1;
                /*定义指针h指向数组末尾*/
                int h = length - 1;
                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏，忽略*/
                int min = nums[k] + nums[i] + nums[j] + nums[j + 1];
                if (min > target) {
                    continue;
                }
                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                int max = nums[k] + nums[i] + nums[h] + nums[h - 1];
                if (max < target) {
                    continue;
                }
                /*开始j指针和h指针的表演，计算当前和，如果等于目标值，j++并去重，h--并去重，当当前和大于目标值时h--，当当前和小于目标值时j++*/
                while (j < h) {
                    int curr = nums[k] + nums[i] + nums[j] + nums[h];
                    if (curr == target) {
                        result.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
                        j++;
                        while (j < h && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        h--;
                        while (j < h && i < h && nums[h] == nums[h + 1]) {
                            h--;
                        }
                    } else if (curr > target) {
                        h--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return result;
    }

}
