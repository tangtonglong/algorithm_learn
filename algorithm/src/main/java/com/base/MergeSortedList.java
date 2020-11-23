package com.base;

public class MergeSortedList {


    public static void main(String[] args) {

    }


    static ListNode merge(ListNode p1, ListNode p2){
        ListNode header = new ListNode(0);

        if (p1 == null){
            return p2;
        }

        if (p2 == null){
            return p1;
        }

        ListNode tmp = header;
        while (p1 != null && p2 != null){
            if (p1.val > p2.val){
               tmp.next = p2;
               p2 = p2.next;
            }else {
                tmp.next = p1;
                p1 = p1.next;
            }
            tmp = tmp.next;
        }
        if (p1 != null && p2 == null){
            tmp.next = p1;
        }else if (p1 == null && p2 != null){
            tmp.next = p2;
        }
        return header.next;
    }
}
