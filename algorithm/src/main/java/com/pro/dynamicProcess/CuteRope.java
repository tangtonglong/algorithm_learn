package com.pro.dynamicProcess;

import java.math.BigDecimal;

public class CuteRope {


    public static void main(String[] args) {
        System.out.println(cuttingRope(8));
    }

    public static int cuttingRope(int n) {
        if (n < 1){
            return 0;
        }else if (n == 1){
            return 1;
        }else if (n == 2){
            return 1;
        }else if (n == 3){
            return 2;
        }
        int[] maxMultiply = new int[n + 1];
        maxMultiply[0] = 0;
        maxMultiply[1] = 1;
        maxMultiply[2] = 1;
        maxMultiply[3] = 2;
        for (int i = 4;i <= n; i++){
            int maxValue = 0;
            for (int j = 1; j < i; j++){
                maxValue = Math.max(maxValue, Math.max(j * maxMultiply[i - j], j * (i - j)));
            }
            maxMultiply[i] = maxValue;
        }
        return maxMultiply[n];
    }
}
