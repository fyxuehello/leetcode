package cn.edu.ustc.leetcode.tree;
/*
题目：
二叉树的后序遍历(左节点，右节点，根节点)
思路：

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
public class LeetCode145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        while(root!=null||!stack.isEmpty()){
            if(root!=null){
                stack.push(root);
                res.add(root.val);
                root=root.right;
            }else{
                root=stack.pop().left;
            }
        }
        Collections.reverse(res);
        return res;
    }
}

