package com.pro;

import org.springframework.util.StopWatch;

/**
 * @author : ttl
 * 2020/3/11 15:47
 * @return
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"fxlower", "fylow", "flight"};
        StopWatch stopWatch = new StopWatch("");
        stopWatch.start("longestCommonPrefix");
        System.out.println(longestCommonPrefix(strs));
        stopWatch.stop();
        stopWatch.start("longestCommonPrefix");
        System.out.println(longestCommonPrefixV2(strs));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    /**
     * 时间复杂度：O(S)，S 是所有字符串中字符数量的总和。
     *
     * 最坏情况下，输入数据为 n 个长度为 m 的相同字符串，算法会进行 S=m∗n 次比较。可以看到最坏情况下，本算法的效率与算法一相同，
     * 但是最好的情况下，算法只需要进行 n∗minLen 次比较，其中 minLen 是数组中最短字符串的长度。
     *
     * 空间复杂度：O(1)，我们只需要使用常数级别的额外空间。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        out:
        for (int i = 0; ; i++) {
            if (i < strs[0].length()) {
                char tmpChar = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (i < strs[j].length() && strs[j].charAt(i) == tmpChar) {

                    } else {
                        break out;
                    }
                }
                stringBuilder.append(tmpChar);
            } else {
                break out;
            }
        }
        return stringBuilder.toString();
    }


    public static String longestCommonPrefixV2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char tmpChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i < strs[j].length() && strs[j].charAt(i) == tmpChar) {

                } else {
                    return strs[0].substring(0, i);
                }
            }
        }
        return "";
    }

    /**
     * 分治法
     * 最坏情况下，我们有 n 个长度为 m 的相同字符串。
     *
     * 时间复杂度：O(S)，S 是所有字符串中字符数量的总和，S=m*n
     *
     * 时间复杂度的递推式为 T(n)=2⋅T( n/2) + O(m)， 化简后可知其就是 O(S)O(S)。最好情况下，算法会进行 minLen⋅n 次比较，其中 minLen 是数组中最短字符串的长度。
     *
     * 空间复杂度：O(m⋅log(n))
     *
     * 内存开支主要是递归过程中使用的栈空间所消耗的。 一共会进行 log(n)log(n) 次递归，每次需要 mm 的空间存储返回结果，所以空间复杂度为 O(m⋅log(n))。
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefixV3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefix(strs, l , mid);
            String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }

}
