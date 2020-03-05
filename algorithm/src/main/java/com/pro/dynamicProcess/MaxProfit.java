package com.pro.dynamicProcess;

import org.springframework.util.StopWatch;

public class MaxProfit {

    public static void main(String[] args) {
        int[] weight = new int[]{2, 3, 5, 5};
        int[] value = new int[]{2, 4, 3, 7};
        int capacity = 10;
        StopWatch stopWatch = new StopWatch("maxProfit");
        stopWatch.start("dp");
        System.out.println(maxProfit());
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    public static int maxProfit(){
        return 0;
    }
}
