package com.pro.dynamicProcess;

public class GiftMaxValue {


    /**
     *
     在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，
     并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
     示例 1:

     输入:
     [
     [1,3,1],
     [1,5,1],
     [4,2,1]
     ]
     输出: 12
     解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物

     提示：

     0 < grid.length <= 200
     0 < grid[0].length <= 200

     * @param matrix
     * @return
     */
    public int maxValue(int[][] matrix){
        int[][] dp = new int[matrix.length][matrix[0].length];

        int rows = matrix.length;
        int cols = matrix[0].length;
        dp[0][0] = matrix[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++){
                if (i-1 >= 0 && j-1 >= 0){
                    dp[i][j] = matrix[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                if (i - 1 < 0 && j - 1 >= 0){
                    dp[i][j] = matrix[i][j] + dp[i][j - 1];
                }
                if (j - 1 < 0 && i - 1 >= 0){
                    dp[i][j] = matrix[i][j] + dp[i - 1][j];
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
