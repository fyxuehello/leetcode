package cn.edu.ustc.jianzhioffer;


/*
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
*/

import cn.edu.ustc.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Number39 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null)
            return true;
        return Math.abs(getHeight(root.left)-getHeight(root.right))<=1
                &&IsBalanced_Solution(root.left)
                &&IsBalanced_Solution(root.right);
    }
    private int getHeight(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
}
