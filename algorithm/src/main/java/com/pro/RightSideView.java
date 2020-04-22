package com.pro;

import com.base.TreeNode;
import org.springframework.util.StopWatch;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * @author : ttl
 * 2020/4/22 14:49
 * @return
 */
public class RightSideView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        StopWatch stopWatch = new StopWatch("rightSideView");
        stopWatch.start("rightSideView");
        System.out.println(rightSideView(root));
        stopWatch.stop();
        stopWatch.start("rightSideView");
        System.out.println(rightSideView(root));
        stopWatch.stop();
        stopWatch.start("rightSideView");
        System.out.println(rightSideView(root));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }


    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideList = new LinkedList<>();
        if (root == null){
            return rightSideList;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        Queue<TreeNode> nextQueue = new ArrayDeque<>();
        while (!queue.isEmpty() || !nextQueue.isEmpty()){
            while (!queue.isEmpty()){
                TreeNode tmpNode = queue.remove();
                if (queue.size() == 0){
                    rightSideList.add(tmpNode.val);
                }
                if (tmpNode.left != null){
                    nextQueue.add(tmpNode.left);
                }
                if (tmpNode.right != null){
                    nextQueue.add(tmpNode.right);
                }
            }
            while (!nextQueue.isEmpty()){
                TreeNode tmpNode = nextQueue.remove();
                if (nextQueue.size() == 0){
                    rightSideList.add(tmpNode.val);
                }
                if (tmpNode.left != null){
                    queue.add(tmpNode.left);
                }
                if (tmpNode.right != null){
                    queue.add(tmpNode.right);
                }
            }
        }
        return rightSideList;
    }
}
