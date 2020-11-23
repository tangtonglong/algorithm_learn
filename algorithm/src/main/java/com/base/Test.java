package com.base;

import java.util.Arrays;

public class Test {
    
    
    public void solution(int[][] array){
        
        int rows = array.length;
        int cols = array[0].length;

        for (int i = 0; rows - 2*i - 2 >= 0; i++) {
            printCycle(array, i, i);
        }
    }

    public void printCycle(int[][] array, int row, int col){
        int tmpRow = row;
        int tmpCol = col;
        // array.length - row
        // array.length - col
        //打印上
        for (int i = col; i < array.length - col; i++) {
            System.out.println(array[row][i]);
        }
        //打印右
        for (int i = row + 1; i < array.length - row; i++) {
            System.out.println(array[i][array.length - col - 1]);
        }
        //打印下
        for (int i = array.length - col - 1 - 1; i >= col; i--) {
            System.out.println(array[array.length - row - 1][i]);
        }
        //打印左
        for (int i = array.length - row - 1 - 1; i > row; i--) {
            System.out.println(array[i][col]);
        }
    }
}
