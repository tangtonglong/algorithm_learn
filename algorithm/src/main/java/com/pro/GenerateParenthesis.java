package com.pro;

import org.springframework.util.StopWatch;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : ttl
 * 2020/3/17 16:57
 * @return
 */
public class GenerateParenthesis {

    public static void main(String[] args){
        int n = 13;
        StopWatch stopWatch = new StopWatch("GenerateParenthesis");
        stopWatch.start("generateParenthesis");
        System.out.println(generateParenthesis(n));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());

    }

    public static List<String> generateParenthesis(int n) {
        List<String> resultList = new LinkedList<String>();


        return resultList;
    }
}
