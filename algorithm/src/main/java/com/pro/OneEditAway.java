package com.pro;

import org.springframework.util.StopWatch;

/**
 * @author : ttl
 * 2020/4/7 14:37
 * @return
 */
public class OneEditAway {


    public static void main(String[] args) {

        String a = "spartan";
        String b = "part";
        StopWatch stopWatch = new StopWatch("oneEditAway");
        stopWatch.start("oneEditAway");
        System.out.println(oneEditAway(a, b));
        stopWatch.stop();
        stopWatch.start("oneEditAway");
        System.out.println(oneEditAway(a, b));
        stopWatch.stop();
        stopWatch.start("oneEditAway");
        System.out.println(oneEditAway(a, b));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    public static boolean oneEditAway(String first, String second) {
        if ((first == null || first.length() == 0) && second != null && second.length() > 1){
            return false;
        }
        if ((second == null || second.length() == 0) && first != null && first.length() > 1){
            return false;
        }
        if ((first == null || first.length() == 0) && second != null && second.length() == 1){
            return true;
        }
        if ((second == null || second.length() == 0) && first != null && first.length() == 1){
            return true;
        }
        if (Math.abs(first.length() - second.length()) > 1){
            return false;
        }
        int firstIndex = 0;
        int secondIndex = 0;
        int notSameCount = 0;
        while (firstIndex < first.length() && secondIndex < second.length()){
            if (first.charAt(firstIndex) == second.charAt(secondIndex)){
                firstIndex ++;
                secondIndex ++;
            }else {
                if (notSameCount < 1){
                    notSameCount++;
                    if (first.length() > second.length()) {
                        firstIndex++;
                    } else if (first.length() < second.length()){
                        secondIndex++;
                    }else {
                        firstIndex ++;
                        secondIndex ++;
                    }
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
