package com.pro;

import org.springframework.util.StopWatch;

/**
 * @author : ttl
 * 2020/2/28 11:39
 * @return
 */
public class ReverseInt {

    public static void main(String[] args) {
        Integer x = -2147483648;
        StopWatch stopWatch = new StopWatch("reverse");
        stopWatch.start("force");
        System.out.println(reverse(x));
        stopWatch.stop();
        stopWatch.start("% 10");
        System.out.println(reverse2(x));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    public static int reverse(int x) {
        if (x == 0) {
            return x;
        }
        String s = new StringBuffer(String.valueOf(x)).reverse().toString().replace("-", "");
        int i = s.length() - 1;
        while (i > 0 && s.charAt(i) == '0') {
            i--;
        }
        String reversedString = s.substring(0, i + 1);
        if (x > 0) {
            if (reversedString.length() >= String.valueOf(Integer.MAX_VALUE).length() && String.valueOf(Integer.MAX_VALUE).compareTo(reversedString) < 0) {
                return 0;
            }
            return Integer.valueOf(reversedString);
        } else {
            if (reversedString.length() >= String.valueOf(Integer.MIN_VALUE).replace("-", "").length() && String.valueOf(-Integer.MIN_VALUE).replace("-", "").compareTo(reversedString) < 0) {
                return 0;
            }
            return -Integer.valueOf(reversedString);
        }
    }

    /**
     * 方法：弹出和推入数字 & 溢出前进行检查
     * 思路
     * <p>
     * 我们可以一次构建反转整数的一位数字。在这样做的时候，我们可以预先检查向原整数附加另一位数字是否会导致溢出。
     * <p>
     * 算法
     * <p>
     * 反转整数的方法可以与反转字符串进行类比。
     * <p>
     * 我们想重复“弹出” xx 的最后一位数字，并将它“推入”到 \text{rev}rev 的后面。最后，\text{rev}rev 将与 xx 相反。
     * <p>
     * 要在没有辅助堆栈 / 数组的帮助下 “弹出” 和 “推入” 数字，我们可以使用数学方法。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param x
     * @return
     */
    public static int reverse2(int x) {
        int tmp = x;
        int reversedInt = 0;
        while (tmp != 0) {
            int model = tmp % 10;
            tmp = tmp / 10;
            if (x > 0 && (reversedInt > Integer.MAX_VALUE / 10 || Integer.MAX_VALUE - model < reversedInt * 10)) {
                return 0;
            } else if (x < 0 && (reversedInt < Integer.MIN_VALUE / 10 || Integer.MIN_VALUE - model > reversedInt * 10)) {
                return 0;
            }
            reversedInt = reversedInt * 10 + model;
        }
        return reversedInt;
    }
}
