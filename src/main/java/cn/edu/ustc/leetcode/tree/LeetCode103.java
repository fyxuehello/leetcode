package cn.edu.ustc.leetcode.tree;
/*
题目：
按照zigzag层序遍历二叉树输出；
For example:
Given binary tree [3,9,20,null,null,15,7]

return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

思路：
仍然按照层序遍历的思路，用zigzag作为标记，如果其为false正常遍历，否则逆序遍历；
逆序遍历可以使用ArrayList.add(0,value)方法；若使用栈的话则浪费空间。
 */

import cn.edu.ustc.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null)
            return res;
        queue.add(root);
        boolean zigzag = false;
        while (!queue.isEmpty()) {
            List<Integer> subList = new ArrayList<>();
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null)
                    queue.add(queue.peek().left);
                if (queue.peek().right != null) {
                    queue.add(queue.peek().right);
                }
                if (zigzag == false) {
                    subList.add(queue.poll().val);
                } else {
                    subList.add(0, queue.poll().val);
                }
            }
            res.add(subList);
        }
        return res;
    }
}
