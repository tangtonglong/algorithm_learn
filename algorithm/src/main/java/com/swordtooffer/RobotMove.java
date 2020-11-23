package com.swordtooffer;

public class RobotMove {

    public static void main(String[] args) {
        System.out.printf("");
    }

    public static int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return countPath(m, n, 0, 0, k, visited);

    }

    public static int countPath( int rows, int cols, int row, int col, int target, boolean[][] visited){
        if (row <= rows && col <= cols && row >= 0 && col >= 0
                && !visited[row][col] && couldMoveIn(row, col, target)){
            visited[row][col] = true;
            return 1 + countPath(rows, cols, row + 1, col, target, visited)
                    + countPath(rows, cols, row, col + 1, target, visited)
                    + countPath(rows, cols, row - 1, col, target, visited)
                    + countPath(rows, cols, row, col - 1, target, visited);
        }else {
            return 0;
        }

    }

    public static boolean couldMoveIn(int row, int col, int target){
        int result = 0;
        while (row > 0){
            if (result > target){return false;}
            result += row % 10;
            row = row / 10;
        }
        while (col > 0){
            if (result > target){return false;}
            result += col % 10;
            col = col / 10;
        }
        return result <= target;
    }
}
