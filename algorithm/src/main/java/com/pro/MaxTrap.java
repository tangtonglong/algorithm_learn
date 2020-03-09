package com.pro;

public class MaxTrap {

    public static int trap(int[] height) {

        int maxVolumn = 0;
        int high1 = 0;
        int high2 = 0;
        int low = 0;
        int i = 0;

        while (i < height.length - 1){
            int h12lowCount = 0;
            int low2h2count = 0;
            while (height[i]<= height[i+1]){
                i++;
            }
            high1 = height[i];
            while (height[i] > height[i+1]){
                i++;
                h12lowCount ++;
                maxVolumn += high1-height[i];
            }
            low = height[i];
            while (height[i] <= height[i+1]){
                i++;
                maxVolumn +=
            }
            high2 = height[i];
        }
    }
}
