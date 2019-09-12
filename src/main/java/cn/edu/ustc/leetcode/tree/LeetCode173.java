package cn.edu.ustc.leetcode.tree;
/*
题目：给定一个二叉树BST,要求实现两个函数，next返回下一个最小的元素；
hasNext返回是否还有下一个最小的元素；

思路：
按照BST的中序遍历可以得到一个排序的链表；
 */

import cn.edu.ustc.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode173 {
    Stack<TreeNode> stack;
    TreeNode node;
    public LeetCode173(TreeNode root) {
        stack=new Stack<>();
        node=root;
    }

    /** @return the next smallest number */
    public int next() {
        while(node!=null){
            stack.push(node);
            node=node.left;
        }

        node=stack.pop();
        int res=node.val;
        node=node.right;

        return res;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty()||node!=null;
    }
}
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

