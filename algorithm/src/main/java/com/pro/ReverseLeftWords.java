package com.pro;

import java.util.LinkedList;

public class ReverseLeftWords {
    public static void main(String[] args) {

        String s = "abcdefg";
        solution(s, 2);
    }

    public static String solution(String s, int n){
        if (s == null || s.length() < n){

        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s.substring( n, s.length())).append(s.substring(0, n));
        return stringBuilder.toString();
    }
}
