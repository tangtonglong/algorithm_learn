package com.pro;

import org.springframework.util.StopWatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 8. 字符串转换整数 (atoi)
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * <p>
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * <p>
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * <p>
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * <p>
 * 说明：
 * <p>
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 * 因此返回 INT_MIN (−2^31) 。
 *
 * @author : ttl
 * 2020/2/28 16:29
 * @return
 */
public class StringToInt {

    public static void main(String[] args) {
        String a = "21474836499";
        StopWatch stopWatch = new StopWatch("字符串转换整数 (atoi)");
        stopWatch.start("myAtoiForce");
        System.out.println(myAtoiForce(a));
        stopWatch.stop();
        stopWatch.start("myAtoiByReg");
        System.out.println(myAtoiByReg(a));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    public static int myAtoiForce(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int startIndex = 0;
        while (startIndex < str.length()) {
            // 0~9的ascii码 48~57, 空格' ' 32, 负号'-' 45, 正号'+' 43
            if (str.charAt(startIndex) == 32) {
                startIndex++;
            } else if (str.charAt(startIndex) == '+' || str.charAt(startIndex) == '-' || (str.codePointAt(startIndex) >= 48 && str.codePointAt(startIndex) <= 57)) {
                break;
            } else {
                return 0;
            }
        }
        if (startIndex == str.length()) {
            return 0;
        } else {
            if (startIndex == str.length() - 1 && (str.charAt(startIndex) == '-' || str.charAt(startIndex) == '+')) {
                return 0;
            } else {
                int tmpIndex = startIndex;
                int tmpInter = 0;
                boolean isNegativeNums = false;
                if (str.charAt(startIndex) == '-') {
                    tmpIndex += 1;
                    isNegativeNums = true;
                } else if (str.charAt(startIndex) == '+') {
                    tmpIndex += 1;
                }

                while (tmpIndex < str.length() && str.codePointAt(tmpIndex) >= 48 && str.codePointAt(tmpIndex) <= 57) {
                    if (!isNegativeNums && (tmpInter > Integer.MAX_VALUE / 10 || (tmpInter == Integer.MAX_VALUE / 10 && str.codePointAt(tmpIndex) - 48 >= 7))) {
                        return Integer.MAX_VALUE;
                    } else if (!isNegativeNums) {
                        tmpInter = tmpInter * 10 + str.codePointAt(tmpIndex) - 48;
                    } else if (isNegativeNums && ((-tmpInter) < Integer.MIN_VALUE / 10 || ((-tmpInter) == Integer.MIN_VALUE / 10 && (str.codePointAt(tmpIndex) - 48) >= 8))) {
                        return Integer.MIN_VALUE;
                    } else {
                        tmpInter = tmpInter * 10 + str.codePointAt(tmpIndex) - 48;
                    }
                    tmpIndex++;
                }
                //转数字
                if (isNegativeNums) {
                    return -tmpInter;
                } else {
                    return tmpInter;
                }
            }
        }
    }

    /**
     * 使用正则表达式
     *
     * @param str
     * @return
     */
    public static int myAtoiByReg(String str) {
        //清空字符串开头和末尾空格（这是trim方法功能，事实上我们只需清空开头空格）
        str = str.trim();
        //java正则表达式
        Pattern p = Pattern.compile("^[\\+\\-]?\\d+");
        Matcher m = p.matcher(str);
        int value = 0;
        //判断是否能匹配
        if (m.find()) {
            //字符串转整数，溢出
            try {
                value = Integer.parseInt(str.substring(m.start(), m.end()));
            } catch (Exception e) {
                //由于有的字符串"42"没有正号，所以我们判断'-'
                value = str.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return value;
    }
}
