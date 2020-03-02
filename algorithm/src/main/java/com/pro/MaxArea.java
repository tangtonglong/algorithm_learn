package com.pro;

import org.springframework.util.StopWatch;

/**
 * @author : ttl
 * 2020/3/2 16:58
 * @return
 */
public class MaxArea {

    public static void main(String[] args) {
//        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] height = new int[]{1, 1};
        StopWatch stopWatch = new StopWatch("");
        stopWatch.start("maxArea");
        System.out.println(maxArea(height));
        stopWatch.stop();
        stopWatch.start("maxAreaV2");
        System.out.println(maxAreaV2(height));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    public static int maxArea(int[] height) {
        int max_area = 0;
        for (int i = 0; i <= height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int tmpArea = (j - i) * Math.min(height[i], height[j]);
                max_area = tmpArea > max_area ? tmpArea : max_area;
            }
        }
        return max_area;
    }

    public static int maxAreaV2(int[] height) {

        return 0;
    }
}
