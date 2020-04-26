package com.pro;

import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 串联所有单词的子串
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 *
 * @author : ttl
 * 2020/3/27 18:06
 * @return
 */
public class FindSubstring {
    public static void main(String[] args){
        String s = "abababab";
        String[] words = {"a","b","a"};
        StopWatch stopWatch = new StopWatch("waysToChange");
        stopWatch.start("waysToChangeV6");
        System.out.println(findSubstring(s, words));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        System.out.println(1000 * 60 * 60 * 24);
    }

    public static List<Integer> findSubstring(String s, String[] words) {

        List resultList = new LinkedList<Integer>();
        if (words == null || words.length == 0){
            return resultList;
        }
        int totalLength = words[0].length() * words.length;
        if (s == null || s.length() == 0 || totalLength > s.length()){
            return resultList;
        }
        Arrays.sort(words);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            stringBuilder.append(words[i]);
        }
        String wordStr = stringBuilder.toString();
        for (int i = 0; i <= s.length() - totalLength; i++) {
            String tmp = s.substring(i, i + totalLength);
            if (splitAndMerge(tmp, words[0].length()).equals(wordStr)){
                resultList.add(i);
            }
        }
        return resultList;
    }

    public static String splitAndMerge(String strs, int len){
        String[] tmp = new String[strs.length()/len];
        for (int i = 0; i*len <= strs.length() - len; i++) {
            tmp[i] = strs.substring(i*len, i*len + len);
        }
        Arrays.sort(tmp);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tmp.length; i++) {
            stringBuilder.append(tmp[i]);
        }
        return stringBuilder.toString();
    }
}
