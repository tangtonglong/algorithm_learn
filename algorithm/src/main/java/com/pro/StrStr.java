package com.pro;

import org.springframework.util.StopWatch;

/**
 * @author : ttl
 * 2020/3/26 16:24
 * @return
 */
public class StrStr {

    public static void main(String[] args) {

        String haystack = "";
        String needle = "";

        StopWatch stopWatch = new StopWatch("strStr");
        stopWatch.start("strStr");
        System.out.println(haystack.substring(strStr(haystack, needle)));
        stopWatch.stop();
    }

    public static int strStr(String haystack, String needle) {

        boolean flag = false;

        return haystack.indexOf(needle);
    }
}
