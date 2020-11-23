package com.pro;

import com.base.ListNode;

public class InsertionSortList {

    public static void main(String[] args) {
        String a = "123456";
        System.out.printf(a.substring(0,2));
    }

    public ListNode solution(ListNode head){
        if (head == null){
            return head;
        }
        ListNode tmpHead = new ListNode(Integer.MIN_VALUE);
        tmpHead.next = head;
        ListNode moveIndex = tmpHead;
        ListNode waitForInsert = head.next;
        head.next = null;
        while (waitForInsert != null){
            ListNode nextWaitForInsert = waitForInsert.next;
            while (moveIndex != null){
                if (moveIndex.val <= waitForInsert.val && moveIndex.next != null && moveIndex.next.val <= waitForInsert.val){
                    moveIndex = moveIndex.next;
                }else {
                    break;
                }
            }
            //插入到 moveIndex 之后
            ListNode after = moveIndex.next;
            moveIndex.next = waitForInsert;
            waitForInsert.next = after;

            //moveIndex回归到头部
            moveIndex = tmpHead;
            //下一个要插入的节点
            waitForInsert = nextWaitForInsert;
        }
        return tmpHead.next;
    }
}
