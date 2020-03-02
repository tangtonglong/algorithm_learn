package com.pro;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author : ttl
 * 2020/2/24 19:31
 * @return
 */
public class LongestNoDuplicateSubString {

    public static void main(String[] args) {
        String a = "asdfasaesdasfd";
        System.out.println(lengthOfLongestSubstring2(a));
    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    /**
     * 方法二：滑动窗口
     * 算法
     * <p>
     * 暴力法非常简单，但它太慢了。那么我们该如何优化它呢？
     * <p>
     * 在暴力法中，我们会反复检查一个子字符串是否含有有重复的字符，但这是没有必要的。如果从索引 ii 到 j - 1j−1 之间的子字符串 s_{ij}s
     * ij
     * ​
     * 已经被检查为没有重复字符。我们只需要检查 s[j]s[j] 对应的字符是否已经存在于子字符串 s_{ij}s
     * ij
     * ​
     * 中。
     * <p>
     * 要检查一个字符是否已经在子字符串中，我们可以检查整个子字符串，这将产生一个复杂度为 O(n^2)O(n
     * 2
     * ) 的算法，但我们可以做得更好。
     * <p>
     * 通过使用 HashSet 作为滑动窗口，我们可以用 O(1)O(1) 的时间来完成对字符是否在当前的子字符串中的检查。
     * <p>
     * 滑动窗口是数组/字符串问题中常用的抽象概念。 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，即 [i, j)[i,j)（左闭，右开）。而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。例如，我们将 [i, j)[i,j) 向右滑动 11 个元素，则它将变为 [i+1, j+1)[i+1,j+1)（左闭，右开）。
     * <p>
     * 回到我们的问题，我们使用 HashSet 将字符存储在当前窗口 [i, j)[i,j)（最初 j = ij=i）中。 然后我们向右侧滑动索引 jj，如果它不在 HashSet 中，我们会继续滑动 jj。直到 s[j] 已经存在于 HashSet 中。此时，我们找到的没有重复字符的最长子字符串将会以索引 ii 开头。如果我们对所有的 ii 这样做，就可以得到答案。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetcod/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        Set<Character> tmpSet = new HashSet();
        int maxLength = 1;
        int start = 0;
        int end = 1;
        tmpSet.add(s.charAt(start));
        while (end < s.length()) {
            if (end < s.length() && tmpSet.add(s.charAt(end))) {
                end++;
            } else {
                start = end;
                end++;
                tmpSet.clear();
                tmpSet.add(s.charAt(start));
            }
            if (maxLength < tmpSet.size()) {
                maxLength = tmpSet.size();
            }
        }
        return maxLength;
    }

    /**
     * 方法三：优化的滑动窗口
     * 上述的方法最多需要执行 2n 个步骤。事实上，它可以被进一步优化为仅需要 n 个步骤。我们可以定义字符到索引的映射，而不是使用集合来判断一个字符是否存在。 当我们找到重复的字符时，我们可以立即跳过该窗口。
     * <p>
     * 也就是说，如果 s[j]s[j] 在 [i, j)[i,j) 范围内有与 j'j
     * ′
     * 重复的字符，我们不需要逐渐增加 ii 。 我们可以直接跳过 [i，j'][i，j
     * ′
     * ] 范围内的所有元素，并将 ii 变为 j' + 1j
     * ′
     * +1。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetcod/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        Map<Character, Integer> tmpMap = new HashMap<Character, Integer>();
        int maxLength = 1;
        int start = 0;
        int end = 1;
        tmpMap.put(s.charAt(start), start);
        while (end < s.length() && start < s.length()) {
            if (tmpMap.containsKey(s.charAt(end)) && start <= tmpMap.get(s.charAt(end))) {
                start = tmpMap.get(s.charAt(end)) + 1;
            }
            tmpMap.put(s.charAt(end), end);
            end++;
            maxLength = Math.max(maxLength, end - start);

        }
        return maxLength;
    }
}
