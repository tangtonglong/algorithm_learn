package com.pro;

import org.springframework.util.StopWatch;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 面试题 01.01. 判定字符是否唯一
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 *
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 *
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 *
 * @author : ttl
 * 2020/4/3 16:45
 * @return
 */
public class IsUnique {

    public static void main(String[] args){

            String a = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZa";
            StopWatch stopWatch = new StopWatch("isUnique");
            stopWatch.start("isUnique");
            System.out.println(isUnique(a));
            stopWatch.stop();
            stopWatch.start("isUniqueV2");
            System.out.println(isUniqueV2(a));
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
    }

    public static boolean isUnique(String astr) {
        if (StringUtils.isEmpty(astr)){
            return true;
        }
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < astr.length(); i++) {
            if (characterSet.contains(astr.charAt(i))){
                return false;
            }else {
                characterSet.add(astr.charAt(i));
            }
        }
        return true;
    }

    /**
     * 我们可以使用一个int类型的变量（下文用mark表示）来代替长度为26的bool数组。假设这个变量占26个bit（在多数语言中，这个值一般不止26），
     * 那么我们可以把它看成000...00(26个0)，这26个bit对应着26个字符，对于一个字符c，检查对应下标的bit值即可判断是否重复。
     * 那么难点在于如何检查？这里我们可以通过位运算来完成。首先计算出字符char离'a'这个字符的距离，即我们要位移的距离，用move_bit表示，
     * 那么使用左移运算符1 << move_bit则可以得到对应下标为1，其余下标为0的数，如字符char = 'c'，则得到的数为000...00100，
     * 将这个数跟mark做与运算，由于这个数只有一个位为1，其他位为0，那么与运算的结果中，其他位肯定是0，而对应的下标位是否0则取决于之前这个字符有没有出现过，
     * 若出现过则被标记为1，那么与运算的结果就不为0；若之前没有出现过，则对应位的与运算的结果也是0，那么整个结果也为0。
     * 对于没有出现过的字符，我们用或运算mark | (1 << move_bit)将对应下标位的值置为1。
     *
     * 作者：zhen-zhu-hao-hao-chi
     * 链接：https://leetcode-cn.com/problems/is-unique-lcci/solution/wei-yun-suan-fang-fa-si-lu-jie-shao-by-zhen-zhu-ha/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param astr
     * @return
     */
    public static boolean isUniqueV2(String astr){
        if (astr == null || astr.length() == 0){
            return true;
        }
        int result = 0;
        for (int i = 0; i < astr.length(); i++) {
            int tmpOffset = (astr.codePointAt(i) - 'a');
            if ((result & (1 << tmpOffset)) != 0){
                return false;
            }else {
                result |= (1 << tmpOffset);
            }
        }
        return true;
    }
}
