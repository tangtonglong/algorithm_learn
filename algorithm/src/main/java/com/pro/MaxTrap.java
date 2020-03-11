package com.pro;

import org.springframework.util.StopWatch;

/**
 *  接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * @return
 */
public class MaxTrap {

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int[] height = new int[]{1, 1};
        StopWatch stopWatch = new StopWatch("");
        stopWatch.start("trap");
        System.out.println(trap(height));
        stopWatch.stop();
//        stopWatch.start("maxAreaV2");
//        System.out.println(maxAreaV2(height));
//        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }


    /**
     * 寻找数组中的 V 型结构
     * @param height
     * @return
     */
    public static int trap(int[] height) {

        if (height.length < 3){
            return 0;
        }

        int maxVolumn = 0;

        int i = 0;

        while (i < height.length - 1){
            int lengthCount = 0;
            int v1Index = i;
            int v2Index = i;
            int tmpVolumn = 0;
            while ((i+1)< height.length && height[i]<= height[i+1]){
                i++;
            }
            v1Index = i;
            while ((i+1)< height.length && height[i] > height[i+1]){
                i++;
                lengthCount ++;
                tmpVolumn += height[v1Index]-height[i];
            }
//            low = height[i];
            while ((i+1)< height.length && height[i] < height[i+1]){
                i++;
                lengthCount ++;
                tmpVolumn += height[v1Index]-height[i];
            }
            v2Index = i;
            if (v2Index > v1Index){
                if (height[v1Index] > height[v2Index]){
                    tmpVolumn -= (height[v1Index] - height[v2Index]) * lengthCount;
                    maxVolumn += tmpVolumn;
                }else {

                    tmpVolumn += (height[v2Index] - height[v1Index]);
                    maxVolumn += tmpVolumn;
                }
            }

        }
        return maxVolumn;
    }
}
