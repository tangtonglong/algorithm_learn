package com.pro;

import com.base.TreeNode;
import org.springframework.util.StopWatch;

import java.util.*;

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
        stopWatch.start("rightSideViewV2");
        System.out.println(rightSideViewV2(root));
        stopWatch.stop();
        stopWatch.start("rightSideViewV3");
        System.out.println(rightSideViewV3(root));
        stopWatch.stop();
        stopWatch.start("rightSideViewV4");
        System.out.println(rightSideViewV4(root));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }


    /**
     * 层次遍历，设置两个队列，一个放当前层，另一个放下一层；取这两个队列的最后一个元素；
     *
     * @param root
     * @return
     */
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

    /**
     * 层次遍历
     * @param root
     * @return
     */
    public static List<Integer> rightSideViewV2(TreeNode root) {
        List<Integer> rightSideList = new LinkedList<>();
        if (root == null){
            return rightSideList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int currentFloorCount = queue.size();
            //v1方法的优化
            for (int i = 0; i < currentFloorCount; i++) {
                TreeNode tmpNode = queue.remove();
                if (tmpNode.left != null){
                    queue.add(tmpNode.left);
                }
                if (tmpNode.right != null){
                    queue.add(tmpNode.right);
                }
                if (i == currentFloorCount - 1){
                    rightSideList.add(tmpNode.val);
                }
            }
        }
        return rightSideList;
    }

    public static List<Integer> rightSideViewV3(TreeNode root) {
        List<Integer> rightSideList = new LinkedList<>();
        if (root == null){
            return rightSideList;
        }

        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        int max_depth = -1;

        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> depthStack = new Stack<Integer>();
        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if (node != null) {
                // 维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);

                // 如果不存在对应深度的节点我们才插入
                if (!rightmostValueAtDepth.containsKey(depth)) {
                    rightmostValueAtDepth.put(depth, node.val);
                }

                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth+1);
                depthStack.push(depth+1);
            }
        }

        for (int depth = 0; depth <= max_depth; depth++) {
            rightSideList.add(rightmostValueAtDepth.get(depth));
        }

        return rightSideList;
    }

    public static List<Integer> rightSideViewV4(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res); // 从根节点开始访问，根节点深度是0
        return res;
    }

    private static void dfs(TreeNode root, int depth, List<Integer> res) {
        if (root == null) {
            return;
        }
        // 先访问 当前节点，再递归地访问 右子树 和 左子树。
        if (depth == res.size()) {
            // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth, res);
        dfs(root.left, depth, res);
    }
}
