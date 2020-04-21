package com.pro;

import org.springframework.util.StopWatch;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 *
 * 跳跃游戏 III
 * 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
 *
 * 请你判断自己是否能够跳到对应元素值为 0 的 任意 下标处。
 *
 * 注意，不管是什么情况下，你都无法跳到数组之外。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [4,2,3,0,3,1,2], start = 5
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 5 -> 下标 4 -> 下标 1 -> 下标 3
 * 下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3
 * 示例 2：
 *
 * 输入：arr = [4,2,3,0,3,1,2], start = 0
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 0 -> 下标 4 -> 下标 1 -> 下标 3
 * 示例 3：
 *
 * 输入：arr = [3,0,2,1,2], start = 2
 * 输出：false
 * 解释：无法到达值为 0 的下标 1 处。
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 5 * 10^4
 * 0 <= arr[i] < arr.length
 * 0 <= start < arr.length
 *
 * @author : ttl
 * 2020/4/21 16:48
 * @return
 */
public class CanReach {

    public static void main(String[] args) {
//        int[] nums = new int[]{90,5,0,0,0,4,0,0,0};
        int[] nums = new int[]{3, 0, 2, 1, 2};
        int start = 2;
        StopWatch stopWatch = new StopWatch("canReach");
        stopWatch.start("canReach");
        System.out.println(canReach(nums, start));
        stopWatch.stop();
        stopWatch.start("canReachV2");
        System.out.println(canReach(nums, start));
        stopWatch.stop();
        stopWatch.start("canReachV3");
        System.out.println(canReach(nums, start));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    public static boolean canReach(int[] arr, int start) {

        Set<Integer> reachedIndexSet = new HashSet<>();
        Stack<Integer> rootStack = new Stack<>();
        int tmpStart = start;
        while ((tmpStart >= 0 && tmpStart <= arr.length - 1) || !rootStack.isEmpty()) {
            while (tmpStart >= 0 && tmpStart < arr.length && !reachedIndexSet.contains(tmpStart)) {
                if (arr[tmpStart] == 0) {
                    return true;
                }
                reachedIndexSet.add(tmpStart);
                rootStack.push(tmpStart);
                tmpStart = tmpStart - arr[tmpStart];
            }
            if (!rootStack.isEmpty()) {
                tmpStart = rootStack.pop();
                tmpStart = tmpStart + arr[tmpStart];
            } else {
                if (((tmpStart - arr[tmpStart]) < 0 && tmpStart + arr[tmpStart] > arr.length - 1)
                        || ((tmpStart - arr[tmpStart]) < 0 && (tmpStart + arr[tmpStart]) < arr.length && reachedIndexSet.contains(tmpStart + arr[tmpStart]))
                        || ((tmpStart - arr[tmpStart]) >= 0 && (tmpStart + arr[tmpStart]) > arr.length - 1 && reachedIndexSet.contains(tmpStart - arr[tmpStart]))
                        || (reachedIndexSet.contains(tmpStart - arr[tmpStart]) && reachedIndexSet.contains(tmpStart + arr[tmpStart]))) {
                    break;
                }
            }
        }
        return false;
    }

    public static boolean canReachV2(int[] arr, int start) {

        Set<Integer> reachedIndexSet = new HashSet<>();
        Stack<Integer> rootStack = new Stack<>();
        int tmpStart = start;

    }

}
