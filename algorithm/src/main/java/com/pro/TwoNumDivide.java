package com.pro;

import org.springframework.util.StopWatch;

/**
 *
 *  两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 *
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 *
 *
 * 提示：
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
 *
 * @author : ttl
 * 2020/3/26 16:40
 * @return
 */
public class TwoNumDivide {

    public static void main(String[] args){
        int dividend = -2147483648;
        int divisor = -1109186033;
        StopWatch stopWatch = new StopWatch("TwoNumDivide");
        stopWatch.start("divide");
        System.out.println(divide(dividend, divisor));
        stopWatch.stop();
        stopWatch.start("divideV2");
        System.out.println(divideV2(dividend, divisor));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    /**
     * 超时了
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        if (dividend == 0){
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            //溢出处理
            return Integer.MAX_VALUE;
        }else if (dividend == Integer.MIN_VALUE && divisor == 1){
            return Integer.MIN_VALUE;
        }
        int tmpDividend = dividend;
        int tmpDivisor = divisor;
        if (tmpDividend > 0){
            tmpDividend = 0 - tmpDividend;
        }
        if (tmpDivisor > 0){
            tmpDivisor = 0 - tmpDivisor;
        }
        int result = 0;
        while (tmpDividend < 0 && tmpDividend <= tmpDivisor){
            tmpDividend -= tmpDivisor;
            result++;
        }
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)){
            result = 0 - result;
        }
        return result;
    }

    public static int divideV2(int dividend, int divisor) {
        if (dividend == 0){
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            //溢出处理
            return Integer.MAX_VALUE;
        }else if (dividend == Integer.MIN_VALUE && divisor == 1){
            return Integer.MIN_VALUE;
        }

        String dividendStr = null;
        if (dividend > Integer.MIN_VALUE && dividend < 0){
            dividendStr = Integer.toBinaryString(0 - dividend);
        }else{
            dividendStr = Integer.toBinaryString(dividend);
        }
        String divisorStr = null;
        if (divisor > Integer.MIN_VALUE && divisor < 0){
            divisorStr = Integer.toBinaryString(0 - divisor);
        }else{
            divisorStr = Integer.toBinaryString(divisor);
        }
        if (dividendStr.length() < divisorStr.length()){
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        String ans = "";
        while(index < dividendStr.length()){
            String tmp = ans;
            int length = 1;
            if((tmp.length() < divisorStr.length() || Integer.valueOf(tmp, 2) < Math.abs(divisor)) && index < dividendStr.length()){
                tmp = ans + dividendStr.substring(index, index + length);
                index += length;
            }

            int tmpDividend = Integer.valueOf(tmp, 2);
            if (tmpDividend >= Math.abs(divisor)){
                if (tmpDividend - Math.abs(divisor) == 0){
                    ans = "";
                }else {
                    ans = Integer.toBinaryString(tmpDividend - Math.abs(divisor));
                }
                stringBuilder.append(1);
            }else {
                ans = tmp;
                stringBuilder.append(0);
            }
        }

        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)){
            return 0 - Integer.valueOf(stringBuilder.toString(), 2);
        }else {
            return Integer.valueOf(stringBuilder.toString(), 2);
        }
    }
}
