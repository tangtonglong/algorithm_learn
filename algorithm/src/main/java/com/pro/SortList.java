package com.pro;

import com.base.ListNode;

import java.util.List;

public class SortList {

    public static void main(String[] args) {

        String a= "";
    }

    public static ListNode solution(ListNode head){

        if (head == null || head.next == null){
            return head;
        }
        //分割 cut 环节： 找到当前链表中点，并从中点将链表断开（以便在下次递归 cut 时，链表片段拥有正确边界）；
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //找到中点 slow 后，执行 slow.next = None 将链表切断。
        //递归分割时，输入当前链表左端点 head 和中心节点 slow 的下一个节点 tmp(因为链表是从 slow 切断的)。
        //cut 递归终止条件： 当head.next == None时，说明只有一个节点了，直接返回此节点。
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = solution(head);
        ListNode right = solution(tmp);

        //合并 merge 环节： 将两个排序链表合并，转化为一个排序链表。
        //双指针法合并，建立辅助ListNode h 作为头部。
        //设置两指针 left, right 分别指向两链表头部，比较两指针处节点值大小，由小到大加入合并链表头部，指针交替前进，直至添加完两个链表。
        //返回辅助ListNode h 作为头部的下个节点 h.next。
        //时间复杂度 O(l + r)，l, r 分别代表两个链表长度
        ListNode h = new ListNode(Integer.MIN_VALUE);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;

    }


    public static ListNode solution2(ListNode head){

        if (head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow.next;
        slow.next = null;
        ListNode left = solution2(head);
        ListNode right = solution2(middle);
        return merge2list(left, right);
    }

    public static ListNode merge2list(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

//        if (l1.val < l2.val) {
//            l1.next = merge2list(l1.next, l2);
//            return l1;
//        }else {
//            l2.next = merge2list(l1, l2.next);
//            return l2;
//        }
        if (l1.val > l2.val) {
            return merge2list(l2, l1);
        }
        l1.next = merge2list(l1.next, l2);
        return l1;
    }
}
