package com.pro;

import com.base.ListNode;
import org.springframework.util.StopWatch;

import java.util.List;

/**
 * @author : ttl
 * 2020/3/17 16:12
 * @return
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        int[] l1array = new int[]{ 2, 4};
        ListNode tail = l1;
        for (int i = 0; i < l1array.length; i++) {
            ListNode tmp = new ListNode(l1array[i]);
            tail.next = tmp;
            tail = tmp;
        }
        ListNode l2 = new ListNode(1);
        int[] l2array = new int[] {3,4};
        tail = l2;
        for (int i = 0;i< l2array.length ;i++){
            ListNode tmp = new ListNode(l2array[i]);
            tail.next = tmp;
            tail = tmp;
        }
        StopWatch stopWatch = new StopWatch("mergeTwoLists");
        stopWatch.start("mergeTwoLists");
        System.out.println(mergeTwoLists(l1, l2));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());

    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode tmpIndex = null;
        ListNode header = new ListNode(0);
        tmpIndex = header;
        while (l1 != null && l2!= null){
            if (l1.val <= l2.val){
                tmpIndex.next = l1;
                l1 = l1.next;
            }else {
                tmpIndex.next = l2;
                l2 = l2.next;
            }
            tmpIndex = tmpIndex.next;
        }
        if (l1 == null){
            tmpIndex.next = l2;
        }else {
            tmpIndex.next = l1;
        }
        return header.next;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val > l2.val) {
            return mergeTwoLists(l2, l1);
        }
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    }
}
