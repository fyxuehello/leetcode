package cn.edu.ustc.leetcode.tree;
/*
题目：
二叉树的前序遍历(根节点，左节点，右节点)
思路：
我们使用一个栈，首先将当前节点的值添加结果中，然后判断当前节点是否有右节点；
如果有的话，将其入栈；将当前节点的左节点作为下一个节点，继续遍历下去；
 */

import cn.edu.ustc.leetcode.util.TreeNode;

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
public class LeetCode144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        while(root!=null){
            res.add(root.val);

            if(root.right!=null){
                stack.push(root.right);
            }
            root=root.left;

            if(root==null&&!stack.isEmpty()){
                root=stack.pop();
            }
        }
        return res;
    }
}

