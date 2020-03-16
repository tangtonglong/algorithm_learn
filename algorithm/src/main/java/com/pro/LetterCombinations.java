package com.pro;

import org.springframework.util.StopWatch;

import java.util.*;

/**
 * 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 九宫格键盘
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * @author : ttl
 * 2020/3/16 15:17
 * @return
 */
public class LetterCombinations {

    public static void main(String[] args){

        String digits = "9527";
        StopWatch stopWatch = new StopWatch("Fibonacci");
        stopWatch.start("letterCombinations");
        System.out.println(letterCombinations(digits));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }



    /**
     * 递归
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {

        List<String> outList = new LinkedList();
        if (digits == null || digits.length() == 0){
            return outList;
        }

        if (digits.length() == 1){
            return getListByNum(Integer.valueOf(digits));
        }else {
            List<String> tmpList = letterCombinations(digits.substring(0, digits.length() - 1));
            //字符 0 的ascii 码是48
            List<String> numStringList = getListByNum(digits.charAt(digits.length() - 1) - 48);
            for (String ele :
                    tmpList) {
                for (String e :
                        numStringList) {
                    outList.add(ele + e);
                }
            }
        }
        return outList;
    }

    public static List<String> getListByNum(int num){
        String num2char = null;
        switch (num){
            case 2:
                num2char = "a,b,c";
                break;
            case 3:
                num2char = "d,e,f";
                break;
            case 4:
                num2char = "g,h,i";
                break;
            case 5:
                num2char = "j,k,l";
                break;
            case 6:
                num2char = "m,n,o";
                break;
            case 7:
                num2char = "p,q,r,s";
                break;
            case 8:
                num2char = "t,u,v";
                break;
            case 9:
                num2char = "w,x,y,z";
                break;
        }
        return Arrays.asList(num2char.split(","));
    }
}
