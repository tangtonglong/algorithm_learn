package com.pro;

import com.base.ListNode;

/**
 * @author : ttl
 * 2020/2/24 17:11
 * @return
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
//        int[] l1array = new int[]{1, 6};
//        ListNode tail = l1;
//        for (int i = 0; i < l1array.length; i++) {
//            ListNode tmp = new ListNode(l1array[i]);
//            tail.next = tmp;
//            tail = tmp;
//        }
        ListNode l2 = new ListNode(5);
//        int[] l2array = new int[] {5,6};
//        tail = l2;
//        for (int i = 0;i< l2array.length ;i++){
//            ListNode tmp = new ListNode(l2array[i]);
//            tail.next = tmp;
//            tail = tmp;
//        }
        ListNode sumed = addTwoNumbers(l1, l2);
        while (sumed != null) {
            System.out.println(sumed.val);
            sumed = sumed.next;
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jinwei = 0;
        ListNode head = new ListNode((l1.val + l2.val) % 10);
        jinwei = (l1.val + l2.val) >= 10 ? 1 : 0;
        l1 = l1.next;
        l2 = l2.next;
        ListNode tail = head;
        while (l1 != null && l2 != null) {
            ListNode tmp = new ListNode((l1.val + l2.val + jinwei) % 10);
            jinwei = (l1.val + l2.val + jinwei) >= 10 ? 1 : 0;
            tail.next = tmp;
            tail = tmp;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null && l2 == null) {
            ListNode tmp = new ListNode((l1.val + jinwei) % 10);
            jinwei = (l1.val + jinwei) >= 10 ? 1 : 0;
            tail.next = tmp;
            tail = tmp;
            l1 = l1.next;
        }
        while (l1 == null && l2 != null) {
            ListNode tmp = new ListNode((l2.val + jinwei) % 10);
            jinwei = (l2.val + jinwei) >= 10 ? 1 : 0;
            tail.next = tmp;
            tail = tmp;
            l2 = l2.next;
        }
        if (jinwei == 1) {
            tail.next = new ListNode(jinwei);
        }
        return head;
    }

}
