package com.pro.dynamicProcess;

import org.springframework.util.StopWatch;

public class CoinChange {

    public static void main(String[] args) {
        int capacity = 10;
        StopWatch stopWatch = new StopWatch("maxProfit");
        stopWatch.start("dp");
        System.out.println(coinChange());
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    public static int coinChange() {
        return 0;
    }
}
