package com.pro.dynamicProcess;

import org.springframework.util.StopWatch;

/**
 * 0,1背包问题
 * https://www.cnblogs.com/mfrank/p/10533701.html
 *
 * @author : ttl
 * 2020/3/3 11:33
 * @return
 */
public class ZeroOneBag {

    public static void main(String[] args) {
        int[] weight = new int[]{2, 3, 5, 5};
        int[] value = new int[]{2, 4, 3, 7};
        int capacity = 10;
        StopWatch stopWatch = new StopWatch("01bag");
        stopWatch.start("dp");
        System.out.println(maxValue(weight, value, capacity));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    public static int maxValue(int[] weight, int[] value, int capacity) {
        int[][] v = new int[weight.length][capacity + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                if (j == 0) {
                    v[i][j] = 0;
                } else {
                    if (j < weight[i] && (i - 1) >= 0) {
                        v[i][j] = v[i - 1][j];
                    } else if (j < weight[i]) {
                        v[i][j] = 0;
                    } else if (j >= weight[i] && (i - 1) >= 0) {
                        v[i][j] = Math.max(v[i - 1][j], v[i - 1][j - weight[i]] + value[i]);
                    } else if (j >= weight[i]){
                        v[i][j] = value[i];
                    }
                }
            }
        }
        return v[weight.length - 1][capacity];
    }

}
