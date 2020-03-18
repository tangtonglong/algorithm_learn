package com.pro;

import org.springframework.util.StopWatch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author : ttl
 * 2020/3/17 16:57
 * @return
 */
public class GenerateParenthesis {

    public static void main(String[] args){
        int n = 3;
        StopWatch stopWatch = new StopWatch("GenerateParenthesis");
        stopWatch.start("generateParenthesis");
        List<String> resultList = generateParenthesis(n);
        for (String ele :
                resultList) {
            System.out.printf( ele + " ,");
        }
        System.out.println(generateParenthesis(n));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());

    }

    public static List<String> generateParenthesis(int n) {
        List<String> resultList = new LinkedList<String>();
        if (n == 1){
            resultList.add("()");
            return resultList;
        }
        List<String> tmpList = generateParenthesis(n-1);
        Set<String> tmpSet = new HashSet<String>();
        for (String ele :
                tmpList) {
            for (int i = 0; i < ele.length(); i++) {
                StringBuilder tmpBuilder = new StringBuilder(ele);
                tmpBuilder.insert(i, "()");
                String tmpStr = tmpBuilder.toString();
                if (tmpSet.contains(tmpStr)){
                    System.out.println("duplicate String:" + tmpStr);
                }else {
                    tmpSet.add(tmpStr);
                    resultList.add(tmpStr);
                }
            }
        }
        return resultList;
    }
    

}
