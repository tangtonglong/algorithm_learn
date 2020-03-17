package com.pro;

import java.util.*;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * @author : ttl
 * 2020/3/17 14:40
 * @return
 */
public class OperatorIsValid {



    public static void main(String[] args){
        OperatorIsValid operatorIsValid = new OperatorIsValid();
        operatorIsValid.isValid("(]");
    }

    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1){
            return false;
        }
        Stack<Character> opStack = new Stack<Character>();
        Set<Character> leftOpSet = new HashSet<Character>(){{add('('); add('{'); add('[');}};
        Map<Character, Character> r2lMap = new HashMap<Character, Character>();
        r2lMap.put(')', '(');
        r2lMap.put('}', '{');
        r2lMap.put(']', '[');
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                continue;
            }else if (leftOpSet.contains(s.charAt(i))){
                opStack.push(s.charAt(i));
            }else {
                if (opStack.isEmpty()){
                    return false;
                }
                Character tmpChar = opStack.pop();
                if (tmpChar == null){
                    return false;
                }else if (tmpChar.equals(r2lMap.get(s.charAt(i)))){
                    continue;
                }else {
                    return false;
                }
            }
        }
        return opStack.empty();
    }

    public boolean isValidV2(String s) {
        if (s == null || s.length() % 2 == 1){
            return false;
        }
        Stack<Character> opStack = new Stack<Character>();
        Map<Character, Character> r2lMap = new HashMap<Character, Character>();
        r2lMap.put(')', '(');
        r2lMap.put('}', '{');
        r2lMap.put(']', '[');
        for (int i = 0; i < s.length(); i++) {
            Character tmp = s.charAt(i);
            if (tmp.equals(' ')){
                continue;
            }else if (r2lMap.containsKey(s.charAt(i))){
                Character tmpChar = opStack.isEmpty()? '#': opStack.pop();
                if (!tmpChar.equals(r2lMap.get(s.charAt(i)))){
                    return false;
                }
            }else {
                opStack.push(s.charAt(i));
            }
        }
        return opStack.empty();
    }

}
