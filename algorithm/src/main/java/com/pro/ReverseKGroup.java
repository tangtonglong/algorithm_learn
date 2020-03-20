package com.pro;

import com.base.ListNode;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * <p>
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * @author : ttl
 * 2020/3/19 16:50
 * @return
 */
public class ReverseKGroup {

    public static void main(String[] args) {
        ListNode tail = null;
        ListNode l2 = new ListNode(-256);
        tail = l2;
        for (int i = 0; i < 1000000; i++) {
            ListNode tmp = new ListNode(2 * i);
            tail.next = tmp;
            tail = tail.next;
        }

        ListNode l3 = new ListNode(0);
        tail = l3;
        for (int i = 0; i < 1000000; i++) {
            ListNode tmp = new ListNode(2 * i + 1);
            tail.next = tmp;
            tail = tail.next;
        }
        List<String> a = new ArrayList<>();

        StopWatch stopWatch = new StopWatch("reverseKGroup");
        stopWatch.start("reverseKGroup");
        ListNode listNode2 = reverseKGroup(l2, 3);
        stopWatch.stop();

        stopWatch.start("reverseKGroupV2");
        ListNode listNode3 = reverseKGroupV2(l3, 3);
        stopWatch.stop();

//        while (listNode2 != null){
//            System.out.println(listNode2.val);
//            listNode2 = listNode2.next;
//        }
//        System.out.println("----------------------");
//        while (listNode3 != null){
//            System.out.println(listNode3.val);
//            listNode3 = listNode3.next;
//        }
        System.out.println(stopWatch.prettyPrint());
    }

    /**
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode tmpHead = new ListNode(-256);
        tmpHead.next = head;
        ListNode p = tmpHead;
        ListNode q = p;
        Stack<ListNode> nodeStack = new Stack<>();
        boolean conFlag = true;
        while (conFlag) {
            for (int i = 0; i < k; i++) {
                if (q.next != null) {
                    q = q.next;
                } else {
                    conFlag = false;
                    break;
                }
                nodeStack.push(q);
            }
            ListNode tmp = q.next;
            while (!nodeStack.isEmpty() && conFlag) {
                p.next = nodeStack.pop();
                p = p.next;
            }
            q = p;
            p.next = tmp;
        }
        if (nodeStack.size() > 0) {
            ListNode tmpNode = null;
            while (!nodeStack.isEmpty()) {
                tmpNode = nodeStack.pop();
            }
            p.next = tmpNode;
        }
        return tmpHead.next;
    }

    /**
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroupV2(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;

            end = pre;
        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
