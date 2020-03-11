package com.pro;

import org.springframework.util.StopWatch;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 *
 * 输入: 9
 * 输出: "IX"
 * 示例 4:
 *
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 *
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author : ttl
 * 2020/3/11 11:37
 * @return
 */
public class IntToRoma {

    public static void main(String[] args){
        StopWatch stopWatch = new StopWatch("");
        stopWatch.start("intToRoman");
        System.out.println(intToRoman(2994));
        stopWatch.stop();
        stopWatch.start("intToRomanV2");
        System.out.println(intToRomanV2(2994));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }


    /**
     * 1(I), 10(X), 100(C), 1000(M)是转换的关键点（由 4，9，40，90，400，900表达的特殊性导致的）
     *
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        int[] carryArr = new int[]{1, 5, 10, 50, 100, 500, 1000};
        String[] strArr = new String[]{"I", "V", "X", "L", "C", "D", "M"};
        StringBuilder stringBuilder = new StringBuilder();
        int i = carryArr.length - 1;
        while (num > 0) {
            if (num < carryArr[i]) {
                //每次 -2，到达转换的关键点 1，10，100，1000上
                i=i-2;
            } else if (num / carryArr[i] >= 1 && num / carryArr[i] <= 3) {
                for (int j = 0; j < num / carryArr[i]; j++) {
                    stringBuilder.append(strArr[i]);
                    num -= carryArr[i];
                }
            } else if ((i + 1) < strArr.length && num / carryArr[i] == 4) {
                stringBuilder.append(strArr[i]).append(strArr[i+1]);
                num -= carryArr[i] * 4;
            } else if ((i + 1) < strArr.length && num / carryArr[i] == 5) {
                stringBuilder.append(strArr[i+1]);
                num -= carryArr[i+1];
            }else if ((i + 1) < strArr.length && num / carryArr[i] >= 6 && num / carryArr[i] <= 8) {
                stringBuilder.append(strArr[i+1]);
                num -= carryArr[i+1];
                for (int j = 0; j < num / carryArr[i] - 5; j++) {
                    stringBuilder.append(strArr[i]);
                    num -= carryArr[i];
                }
            }else if ((i + 1) < strArr.length && num / carryArr[i] == 9) {
                stringBuilder.append(strArr[i]).append(strArr[i+2]);
                num -= carryArr[i+1];
                num -= carryArr[i] * 4;
            }
        }
        return stringBuilder.toString();
    }

    public static String intToRomanV2(int num) {
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
        // 并且按照阿拉伯数字的大小降序排列，这是贪心选择思想
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index < 13) {
            // 特别注意：这里是等号
            while (num >= nums[index]) {
                // 注意：这里是等于号，表示尽量使用大的"面值"
                stringBuilder.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return stringBuilder.toString();
    }

}
