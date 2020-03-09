package com.pro;

import org.springframework.util.StopWatch;

public class FibonacciNum {

    public static void main(String[] args) {
        int num = 10;
        StopWatch stopWatch = new StopWatch("Fibonacci");
        stopWatch.start("Fibonacci");
        System.out.println(Fibonacci(num));
        stopWatch.stop();
        stopWatch.start("FibonacciV2");
        System.out.println(FibonacciV2(num));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    public static int Fibonacci(int n) {
        int fib = 0;
        if (n >= 2) {
            fib = Fibonacci(n - 1) + Fibonacci(n - 2);
        } else if (n == 1) {
            fib = 1;
        } else if (n == 0) {
            fib = 0;
        }
        System.out.println("n = [" + n + "  --" + fib + "]");
        return fib;
    }

    public static int FibonacciV2(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(" V2--" + dp[i]);
        }
        return dp[n - 1];
    }
}
