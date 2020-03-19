package com.pro;

import com.base.ListNode;
import org.springframework.util.StopWatch;

/**
 *
 * 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * @author : ttl
 * 2020/3/18 18:02
 * @return
 */
public class SwapPairs {

    public static void main(String[] args){
        ListNode tail = null;
        ListNode l2 = new ListNode(1);
        tail = l2;
        for (int i = 0;i< 100 ;i++){
            ListNode tmp = new ListNode(2*i);
            tail.next = tmp;
            tail = tail.next;
        }

        ListNode l3 = new ListNode(0);
        tail = l3;
        for (int i = 0;i< 100 ;i++){
            ListNode tmp = new ListNode(2*i+1);
            tail.next = tmp;
            tail = tail.next;
        }

        StopWatch stopWatch = new StopWatch("swapPairs");
        stopWatch.start("swapPairs");
        ListNode listNode3 = swapPairs(l3);
        stopWatch.stop();
        stopWatch.start("swapPairsV2");
        ListNode listNode2 = swapPairsV2(l2);
        stopWatch.stop();
        while (listNode3 != null){
            System.out.println(listNode3.val);
            listNode3 = listNode3.next;
        }
        while (listNode2 != null){
            System.out.println(listNode2.val);
            listNode2 = listNode2.next;
        }
        System.out.println(stopWatch.prettyPrint());
    }


    public static ListNode swapPairs(ListNode head){
        ListNode tmpHead = new ListNode(-256);
        tmpHead.next = head;
        ListNode p = tmpHead;
        if (head == null || head.next == null){
            return head;
        }
        ListNode q = p.next.next;
        while (q != null){

            p.next.next = q.next;
            q.next = p.next;
            p.next = q;
            p = p.next.next;
            if (p.next != null && p.next.next != null){
                q = p.next.next;
            }else {
                break;
            }
        }
        return tmpHead.next;
    }

    /**
     *
     * @return
     */
    public static ListNode swapPairsV2(ListNode head){
        ListNode tmpHead = new ListNode(-256);
        tmpHead.next = head;
        ListNode p = tmpHead;
        if (head == null || head.next == null){
            return head;
        }
        ListNode q = p.next.next;
        recursion(p, q);
        return tmpHead.next;
    }

    public static void recursion(ListNode p, ListNode q){
        p.next.next = q.next;
        q.next = p.next;
        p.next = q;
        p = p.next.next;
        if (p.next != null && p.next.next != null){
            q = p.next.next;
            recursion(p, q);
        }else {
            return ;
        }
    }
}
