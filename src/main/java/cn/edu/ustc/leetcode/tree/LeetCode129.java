package cn.edu.ustc.leetcode.tree;
/*
题目：
给定一颗二叉树，每个节点的值在0-9之间，每一个从跟到叶子的路径作为一个值；
An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Input: [1,2,3]，
Output: 25;25=12+13;
思路：
采用迭代的思路，使用两个stack，一个用来存储节点，另一个用来存储路径；
当到达叶子节点时，就把该路径作为一个值加起来；
 */

import cn.edu.ustc.leetcode.util.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
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
public class LeetCode129 {
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;

        Stack<TreeNode> nodeStack=new Stack<>();
        Stack<String> nodePath=new Stack<>();
        nodeStack.push(root);
        nodePath.push(""+root.val);
        int res=0;
        while(!nodeStack.isEmpty()){
            TreeNode currentNode=nodeStack.pop();
            String currentPath=nodePath.pop();
            if(currentNode.right!=null){
                nodeStack.push(currentNode.right);
                nodePath.push(currentPath+currentNode.right.val);
            }
            if(currentNode.left!=null){
                nodeStack.push(currentNode.left);
                nodePath.push(currentPath+currentNode.left.val);
            }
            if(currentNode.left==null&&currentNode.right==null){
                res=res+Integer.valueOf(currentPath);
            }
        }
        return res;
    }
}

