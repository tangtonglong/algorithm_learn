package com.pro;

import org.springframework.util.StopWatch;

/**
 * @author : ttl
 * 2020/3/26 16:40
 * @return
 */
public class TwoNumDivide {

    public static void main(String[] args){
        int dividend = 4;
        int divisor = 2;

        StopWatch stopWatch = new StopWatch("TwoNumDivide");
        stopWatch.start("divide");
        System.out.println(divide(dividend, divisor));
        stopWatch.stop();
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == 0){
            return 0;
        }
        if (divisor == -1 || divisor == 1){
            //溢出处理
//            return dividend;
        }
        int tmpDividend = Math.abs(dividend);
        int tmpDivisor = Math.abs(divisor);

    }
}
