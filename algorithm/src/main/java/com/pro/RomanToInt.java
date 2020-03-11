package com.pro;

import org.springframework.util.StopWatch;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : ttl
 * 2020/3/11 15:36
 * @return
 */
public class RomanToInt {

    public static void main(String[] args){
        String s = "MCMXCIV";
        StopWatch stopWatch = new StopWatch("");
        stopWatch.start("romanToInt");
        System.out.println(romanToInt(s));
        stopWatch.stop();
        stopWatch.start("romanToIntV2");
        System.out.println(romanToIntV2(s));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> romanInt = new HashMap<Character, Integer>();
        romanInt.put('M', 1000);
        romanInt.put('D', 500);
        romanInt.put('C', 100);
        romanInt.put('L', 50);
        romanInt.put('X', 10);
        romanInt.put('V', 5);
        romanInt.put('I', 1);
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i+1)<s.length() && romanInt.get(s.charAt(i)) < romanInt.get(s.charAt(i+1))){
                a -= romanInt.get(s.charAt(i));
            }else if ((i+1)<s.length() && romanInt.get(s.charAt(i)) >= romanInt.get(s.charAt(i+1))){
                a += romanInt.get(s.charAt(i));
            }else {
                a += romanInt.get(s.charAt(i));
            }
        }
        return a;
    }

    public static int romanToIntV2(String s) {
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i+1)<s.length() && getValue(s.charAt(i)) < getValue(s.charAt(i+1))){
                a -= getValue(s.charAt(i));
            }else if ((i+1)<s.length() && getValue(s.charAt(i)) >= getValue(s.charAt(i+1))){
                a += getValue(s.charAt(i));
            }else {
                a += getValue(s.charAt(i));
            }
        }
        return a;
    }

    private static int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

}
