package com.source;

import java.util.Stack;

public class StringLearn {


    public static void main(String[] args){



//        String c = new String("aaa").intern();
//        String d = new String("aaa").intern();
//        String a = "aaa";
//        String b = "aaa";
//        System.out.println(a == b);
//        System.out.println(a == c);
//        System.out.println(a == d);
//        System.out.println(c == d);


        String x1 = new String("xxx") + new String("2");
//        System.out.println(x1 == x1.intern());
        String x2 = "xxx2";
        x1.intern();

        int[][] a = new int[10][20];
        System.out.printf(""+ a.length);
        System.out.printf(""+ a[0].length);
        for (int i = 0; i < a.length; i++) {

        }

        System.out.println(x2 == x1);
        System.out.println(x2 == x1.intern());
        System.out.println(x1 == x1.intern());

        String str1 = new String("SEU") + new String("Calvin");
        System.out.println(str1.intern() == str1);
        System.out.println(str1 == "SEUCalvin");


//        String str2 = "SEUCalvin";//新加的一行代码，其余不变
//        String str1 = new String("SEU")+ new String("Calvin");
//        System.out.println(str1.intern() == str1);
//        System.out.println(str1 == "SEUCalvin");


        String s1 = new String("abc") + new String("");

        s1.intern();

        String s2 = "abc";

//s1 == s2 ? false
        System.out.println(String.format("s1 == s2 ? %s", s1 == s2));


    }

    static class Address{
        private int row;
        private int col;

        public Address(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }
    }

    public static boolean havePath(char[][] board, int row, int col, String word, boolean[][] visited){
        int rows = board.length;
        int cols = board[0].length;
        boolean haveP = false;
        if (board[row][col] == word.charAt(0)){
            return false;
        }
        Stack<Address> pathChar = new Stack();
        pathChar.push(new Address(row, col));
        int pathLen = 1;
        while (row >= 0 && row < rows && col >= 0 && col < cols && pathLen < word.length()){
            if ((row + 1) < rows && visited[row + 1][col] && board[row + 1][col] == word.charAt(pathLen)){
                pathLen ++;
                row++;
                visited[row][col] = false;
                pathChar.push(new Address(row, col));
            }else if ((row + 1) < rows && visited[row + 1][col] && board[row + 1][col] != word.charAt(pathLen)){
                visited[row + 1][col] = false;
            }else if ((row - 1) >= 0 && visited[row - 1][col] && board[row - 1][col] == word.charAt(pathLen)){
                pathLen ++;
                row--;
                visited[row][col] = false;
                pathChar.push(new Address(row, col));
            }else if ((row - 1) >= 0 && visited[row - 1][col] && board[row - 1][col] != word.charAt(pathLen)){
                visited[row - 1][col] = false;
            }else if ((col+1) < cols && visited[row][col+1] && board[row][col+1] == word.charAt(pathLen)){
                pathLen ++;
                col++;
                visited[row][col] = false;
                pathChar.push(new Address(row, col));
            }else if ((col+1) < cols && visited[row][col+1] && board[row][col+1] != word.charAt(pathLen)){
                visited[row][col + 1] = false;
            }else if ((col-1) >= 0 && visited[row][col-1] && board[row][col-1] == word.charAt(pathLen)){
                pathLen ++;
                col--;
                visited[row][col] = false;
                pathChar.push(new Address(row, col));
            }else if ((col-1) >= 0 && visited[row][col-1] && board[row][col-1] != word.charAt(pathLen)){
                visited[row][col-1] = false;
            }else{
                if (pathChar.size() == word.length()){
                    haveP = true;
                    break;
                }else if ((row + 1) >= rows || (row - 1) < 0 || (col+1) >= cols || (col - 1) < 0
                        || (!visited[row + 1][col] && !visited[row - 1][col] && !visited[row][col+1] && !visited[row][col-1]) ){
                    if (pathChar.peek() == null){
                        Address address = pathChar.pop();
                    }else {
                        haveP = false;
                        break;
                    }
                }
            }
        }
        String a= "";
        a.toCharArray();
        return haveP;
    }

    public static boolean havePath(char[][] board, int row, int col, char[] word, int index){
        int rows = board.length;
        int cols = board[0].length;

        if (row >= rows || row < 0 || col >= cols || col < 0 || board[row][col] != word[index]){
            return false;
        }
        if (index == word.length - 1){
            return true;
        }
        boolean haveP = false;
        char tmp = board[row][col];
        board[row][col] = '.';
        haveP = havePath(board, row - 1, col, word, index + 1)
                || havePath(board, row + 1, col, word, index + 1)
                || havePath(board, row, col + 1, word, index + 1)
                || havePath(board, row, col - 1, word, index + 1);
        board[row][col] = tmp;
        return haveP;
    }
}
