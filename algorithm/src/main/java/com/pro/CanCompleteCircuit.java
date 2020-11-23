package com.pro;

import org.springframework.util.StopWatch;

public class CanCompleteCircuit {

    public static void main(String[] args) {
        int[] gas = {67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66};
        int[] cost = {27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
        StopWatch stopWatch = new StopWatch("canJump");
        stopWatch.start("CanCompleteCircuit1");
        for (int i = 0; i < 100000; i++) {
//            System.out.println(solution(gas, cost) + "");
            solution(gas, cost);
        }

        stopWatch.stop();
        stopWatch.start("CanCompleteCircuit2");
        for (int i = 0; i < 100000; i++) {
            solution2(gas, cost);
        }
//        System.out.println(solution2(gas, cost) + "");
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        System.out.println(stopWatch.getTotalTimeMillis() * 1000);
    }

    public static int solution(int[] gas, int[] cost) {
        if (gas.length == 1) {
            return gas[0] >= cost[0] ? 0 : -1;
        }
        int starterIndex = 0;
//        List<Integer> couldStart = new LinkedList<>();
        while (starterIndex < gas.length) {
            if (gas[starterIndex] - cost[starterIndex] < 0) {
                starterIndex++;
                continue;
            }

            int curPoint = starterIndex;
            int nextPoint = (curPoint + 1) % gas.length;
            int savings = gas[starterIndex];
            while (nextPoint != starterIndex && (savings = savings - cost[curPoint]) >= 0) {
//                if (gas[curPoint] - cost[curPoint] >= 0 && starterIndex < curPoint){
//                    couldStart.add(curPoint);
//                }
                savings += gas[nextPoint];
                nextPoint = (nextPoint + 1) % gas.length;
                curPoint = (curPoint + 1) % gas.length;
            }
            if (nextPoint == starterIndex && savings - cost[curPoint] >= 0) {
                return starterIndex;
            }
//            if (couldStart.isEmpty()){
            starterIndex++;
//            }else {
//                starterIndex = couldStart.remove(0);
//            }
        }
        return -1;
    }

    public static int solution2(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }

        return spare < 0 ? -1 : (minIndex + 1) % len;

//        作者：cyaycz
//        链接：https://leetcode-cn.com/problems/gas-station/solution/shi-yong-tu-de-si-xiang-fen-xi-gai-wen-ti-by-cyayc/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}
