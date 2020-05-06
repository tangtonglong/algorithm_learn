package com.pro;

import org.springframework.util.StopWatch;

import java.util.HashSet;
import java.util.Set;

/**
 *
 *  快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 *
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 *
 *
 *
 * 示例：
 *
 * 输入：19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * @author : ttl
 * 2020/4/30 16:48
 * @return
 */
public class HappyNumber {

    public static void main(String[] args){
//        int[] nums = {4,5,6,7,0,1,2,4,5,6,7,0,1,2,25,26};
        int nums = 99999999;
        StopWatch stopWatch = new StopWatch("isHappy");
        stopWatch.start("isHappy");
        System.out.println(isHappy(nums));
        stopWatch.stop();
        stopWatch.start("isHappyV2");
        System.out.println(isHappyV2(nums));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    public static boolean isHappy(int n) {

        Set<Integer> sumedInt = new HashSet<>();
        while (!sumedInt.contains(n)){
            if (n == 1){
                return true;
            }
            sumedInt.add(n);
            n = getSquSum(n);
        }
        return false;
    }

    /**
     * 快慢指针法
     * https://leetcode-cn.com/problems/happy-number/solution/kuai-le-shu-by-leetcode-solution/
     * https://leetcode-cn.com/problems/happy-number/solution/kuai-le-de-zhi-shi-dian-zeng-jia-liao-by-sweetiee/
     * @param n
     * @return
     */
    public static boolean isHappyV2(int n) {

        int slowIndex = n;
        int fastIndex = getSquSum(n);
        while (fastIndex != 1 && fastIndex != slowIndex){
            slowIndex = getSquSum(slowIndex);
            fastIndex = getSquSum(getSquSum(fastIndex));
        }

        return slowIndex == 1;
    }

    public static int getSquSum(int num){
        int result = 0;
        while (num != 0){
            result += Math.pow(num%10, 2);
            num /= 10;
        }
        return result;
    }


}
