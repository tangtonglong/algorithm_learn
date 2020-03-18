package com.pro;

import com.base.ListNode;
import org.springframework.util.StopWatch;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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
//        ListNode l1 = new ListNode(1);
//        int[] l1array = new int[]{ 4, 5};
        ListNode tail = null;
//        for (int i = 0; i < l1array.length; i++) {
//            ListNode tmp = new ListNode(l1array[i]);
//            tail.next = tmp;
//            tail = tmp;
//        }
//        ListNode l2 = new ListNode(1);
//        int[] l2array = new int[] {3,4};
//        tail = l2;
//        for (int i = 0;i< l2array.length ;i++){
//            ListNode tmp = new ListNode(l2array[i]);
//            tail.next = tmp;
//            tail = tmp;
//        }
        ListNode l3 = new ListNode(0);
        tail = l3;
        for (int i = 0;i< 100 ;i++){
            ListNode tmp = new ListNode(2*i+1);
            tail.next = tmp;
            tail = tail.next;
        }

        ListNode l4 = new ListNode(0);
        tail = l4;
        for (int i = 0;i<= 100 ;i++){
            ListNode tmp = new ListNode(2*i);
            tail.next = tmp;
            tail = tail.next;
        }

        ListNode[] listNodes = new ListNode[2];
        listNodes[0] = l3;
        listNodes[1] = l4;
//        listNodes[2] = l3;
//        listNodes[3] = l4;
        StopWatch stopWatch = new StopWatch("mergeKLists");
//        stopWatch.start("mergeKLists");
//        ListNode resultList = mergeKLists(listNodes);
//        stopWatch.stop();
//        stopWatch.start("mergeKListsV2");
//        mergeKListsV2(listNodes);
//        stopWatch.stop();
        stopWatch.start("mergeKListsV21");
        mergeKListsV21(listNodes);
        stopWatch.stop();
//        while (resultList != null){
//            System.out.printf( resultList.val + " ,");
//            resultList = resultList.next;
//        }
        System.out.println("");
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

    /**
     * 优先级队列方式
     * 优先级队列一般是用堆来实现的，所以其实是和暴力法差不多，差别在于一个用堆排序，一个用快排
     *
     * 时间复杂度： O(Nlogk) ，其中 k 是链表的数目。
     *
     * 弹出操作时，比较操作的代价会被优化到 O(logk) 。同时，找到最小值节点的时间开销仅仅为 O(1)。
     * 最后的链表中总共有 N 个节点。
     * 空间复杂度：
     *
     * O(n) 。创造一个新的链表需要 O(n) 的开销。
     * O(k) 。以上代码采用了重复利用原有节点，所以只要 O(1) 的空间。同时优先队列（通常用堆实现）需要 O(k) 的空间（远比大多数情况的 N要小）。
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKListsV2(ListNode[] lists) {
        if(lists == null || lists.length < 0){
            return null;
        }
        PriorityQueue<Integer> queue = new PriorityQueue();
        for(ListNode node:lists){
            while(node != null){
                queue.add(node.val);
                node = node.next;
            }
        }
        ListNode res = new ListNode(0);
        ListNode tmp= res;
        while(!queue.isEmpty()){
            ListNode temp = new ListNode(queue.poll());
            tmp.next = temp;
            tmp = tmp.next;
        }
        return res.next;
    }

    public static ListNode mergeKListsV21(ListNode[] lists) {
        if(lists == null || lists.length < 0){
            return null;
        }
        //创建一个堆，并设置元素的排序方式
        PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return (o1.val - o2.val);
            }
        });

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        //这里跟上一版不一样，不再是一股脑全部放到堆中
        //而是只把k个链表的第一个节点放入到堆中
        for(int i=0;i<lists.length;i++) {
            if(lists[i]!=null) {
                queue.add(lists[i]);
            }
        }
        //之后不断从堆中取出节点，如果这个节点还有下一个节点，
        //就将下个节点也放入堆中
        while(queue.size()>0) {
            ListNode tmp = queue.poll();
            System.out.println("lists = [" + tmp.val + "]");
            cur.next = tmp;
            if (tmp.next != null){
                tmp = tmp.next;
                queue.add(tmp);
            }
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }

    /**
     * 暴力法
     * 遍历所有链表，将所有节点的值放到一个数组中。
     * 将这个数组排序，然后遍历所有元素得到正确顺序的值。
     * 用遍历得到的值，创建一个新的有序链表。
     */
//    public ListNode mergeKListsV3(ListNode[] lists){
//
//    }
}
