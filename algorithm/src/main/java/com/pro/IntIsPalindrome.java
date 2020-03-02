package com.pro;

import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ttl
 * 2020/3/2 15:45
 * @return
 */
public class IntIsPalindrome {

    /**
     * 9. 回文数
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 121
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     * <p>
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     * 进阶:
     * <p>
     * 你能不将整数转为字符串来解决这个问题吗？
     *
     * @param args
     */
    public static void main(String[] args) {
        int x = 10;
        StopWatch stopWatch = new StopWatch("");
        stopWatch.start("isPalindrome");
        System.out.println(isPalindrome(x));
        stopWatch.stop();
        stopWatch.start("isPalindromeV2");
        System.out.println(isPalindromeV2(x));
        stopWatch.stop();
        stopWatch.start("isPalindromeV3");
        System.out.println(isPalindromeV3(x));
        stopWatch.stop();
        stopWatch.start("isPalindromeV4");
        System.out.println(isPalindromeV4(x));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        } else if (x == 0) {
            return true;
        }
        List<Integer> intList = new ArrayList<Integer>();
        while (x > 0) {
            intList.add(x % 10);
            x = x / 10;
        }
        int start = 0;
        int end = intList.size() - 1;
        while (start <= end && start <= intList.size() - 1 && end >= 0) {
            if (intList.get(start).equals(intList.get(end))) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeV2(int x) {
        String s1 = String.valueOf(x);
        String s2 = new StringBuffer(s1).reverse().toString();
        return s1.equals(s2);
    }

    public static boolean isPalindromeV3(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        } else if (x == 0) {
            return true;
        }
        Integer reversedInt = 0;
        while (x > 0 && x > reversedInt) {
            reversedInt = reversedInt * 10 + x % 10;
            x = x / 10;
        }
        return  reversedInt==x || reversedInt/10==x;
    }

    /**
     * 解题思路：
     * 对于数字的末位，直接取余就可以了，对于数字的首位，我们可以这么算。
     * 首先用一个变量记录数字的最高位，
     * 比如 1232112321，可以标记 help 为 1000010000，
     * 第一个末位为 11，第一个首位为 12321/10000=1，
     * 接下来我们需要计算 232232 是否为回文，怎么计算呢？
     * 我们需要去掉首位和末位。
     * 可以采用 x % help / 10 的方式
     * 12321%10000==2321 可以将最高位去掉，然后 2321/10==232 可以将最低为去掉。
     * 最后不要忘记将 help/100。
     *
     * 作者：reedfan
     * 链接：https://leetcode-cn.com/problems/palindrome-number/solution/ji-bai-liao-99de-javayong-hu-dai-ma-you-ya-by-reed/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param x
     * @return
     */
    public static boolean isPalindromeV4(int x){
        if (x < 0) {
            return false;
        }
        int help = 1;
        int tmp = x;
        while (tmp >= 10) {
            help *= 10;
            tmp /= 10;
        }
        while (x != 0) {
            if (x % 10 != x / help) {
                return false;
            }
            x = x % help / 10;
            help /= 100;
        }
        return true;
    }

}
