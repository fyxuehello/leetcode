package cn.edu.ustc.leetcode.tree;
/*
题目：将一颗二叉树倒转；

思路：
递归：找到递归结束条件，然后递归调用即可；

迭代：类似于层序遍历，只是将左右节点的值交换；
 */

import cn.edu.ustc.leetcode.util.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
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
public class LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        TreeNode left=root.left;
        TreeNode right=root.right;

        root.left=invertTree(right);
        root.right=invertTree(left);

        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if(root==null)
            return null;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
                TreeNode node=queue.poll();
                TreeNode left=node.left;
                node.left=node.right;
                node.right=left;

            if (node.left != null) {
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        return root;
    }
}


