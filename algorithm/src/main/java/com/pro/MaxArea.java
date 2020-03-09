package com.pro;

import org.springframework.util.StopWatch;

/**
 * @author : ttl
 * 2020/3/2 16:58
 * @return
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int[] height = new int[]{1, 1};
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

    /**
     * 双指针法
     * 算法
     * <p>
     * 这种方法背后的思路在于，两线段之间形成的区域总是会受到其中较短那条长度的限制。此外，两线段距离越远，得到的面积就越大。
     * <p>
     * 我们在由线段长度构成的数组中使用两个指针，一个放在开始，一个置于末尾。 此外，我们会使用变量 maxareamaxarea 来持续存储到目前为止所获得的最大面积。 在每一步中，我们会找出指针所指向的两条线段形成的区域，更新 maxareamaxarea，并将指向较短线段的指针向较长线段那端移动一步
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/container-with-most-water/solution/sheng-zui-duo-shui-de-rong-qi-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param height
     * @return
     */
    public static int maxAreaV2(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int area = (j - i) * Math.min(height[i], height[j]);
        while (i < j) {
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
            area = Math.max(area, (j - i) * Math.min(height[i], height[j]));
        }
        return area;
    }
}
