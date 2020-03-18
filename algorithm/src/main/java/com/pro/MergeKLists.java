package com.pro;

import com.base.ListNode;
import org.springframework.util.StopWatch;

import java.util.List;

/**
 *
 * 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * @author : ttl
 * 2020/3/18 15:50
 * @return
 */
public class MergeKLists {

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        int[] l1array = new int[]{ 4, 5};
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
        ListNode l3 = new ListNode(2);
        int[] l3array = new int[] {6};
        tail = l3;
        for (int i = 0;i< l3array.length ;i++){
            ListNode tmp = new ListNode(l3array[i]);
            tail.next = tmp;
            tail = tmp;
        }

        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = l1;
        listNodes[1] = l2;
        listNodes[2] = l3;
        StopWatch stopWatch = new StopWatch("mergeKLists");
        stopWatch.start("mergeKLists");
        ListNode resultList = mergeKLists(listNodes);
        stopWatch.stop();
        while (resultList != null){
            System.out.printf( resultList.val + " ,");
            resultList = resultList.next;
        }
        System.out.println(stopWatch.prettyPrint());

    }

    /**
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        return digui2Merger(lists, 0, lists.length - 1);

    }

    /**
     * 分治 思想
     * 仿照 2 路归并算法的过程
     * 递归调用，剩2个链表时使用 2个有序链表的合并方法
     * O(2*n*log(m)) m为链表的个数， n为链表的平均长度
     *
     * 当然也可以相邻的两个合并之后和第3个合并，合并完之后和第四个合并
     * （1，2），3），4），5）·····），m)
     * 但是
     * @param lists
     * @param left
     * @param right
     * @return
     */
    public static ListNode digui2Merger(ListNode[] lists, int left, int right){
        if (right - left == 1){
            ListNode listNode = MergeTwoLists.mergeTwoLists(lists[left], lists[right]);
            return listNode;
        }else if (left == right){
            return lists[left];
        }
        else {
            int mid = (left + right)/2;
            ListNode leftList = digui2Merger(lists, left, mid);
            ListNode rightList = digui2Merger(lists, mid + 1, right);
            ListNode listNode = MergeTwoLists.mergeTwoLists(leftList, rightList);
            return listNode;
        }
    }


}
