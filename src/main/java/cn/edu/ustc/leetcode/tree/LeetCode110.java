package cn.edu.ustc.leetcode.tree;
/*
题目：
判断一个二叉树是否是二叉平衡树；

思路：
平衡二叉树（Balanced Binary Tree）具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，
并且左右两个子树都是一棵平衡二叉树。平衡二叉树的常用实现方法有红黑树、AVL、替罪羊树、Treap、伸展树等。
最小二叉平衡树的节点的公式如下 F(n)=F(n-1)+F(n-2)+1 这个类似于一个递归的数列，
可以参考Fibonacci数列，1是根节点，F(n-1)是左子树的节点数量，F(n-2)是右子树的节点数量。

方法1：
计算出每个节点的高度，判断其是否平衡；若平衡，再计算其子树的高度；按照二叉平衡书的定义来；
时间复杂度为O(nlogn)
方法2：利用dfs计算每个节点的深度，判断其是否是平衡二叉树，若是的话则返回其高度，否则返回-1；
时间复杂度为O(n)
 */

import cn.edu.ustc.leetcode.util.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode110 {
    public boolean isBalanced(TreeNode root){//时间复杂度为O(nlogn)
        if(root==null)
            return true;
        int leftHight=hight(root.left);
        int rightHight=hight(root.right);

        return Math.abs(leftHight-rightHight)<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }
    private int hight(TreeNode root){
        if(root==null)
            return 0;
        int left=hight(root.left);
        int right=hight(root.right);

        return Math.max(left,right)+1;
    }


    //方法2
    public boolean isBalanced2(TreeNode root){//时间复杂度为O(n)
        return dfsHight(root)!=-1;
    }
    private int dfsHight(TreeNode root){
        if(root==null)
            return 0;
        int left=dfsHight(root.left);
        if(left==-1)
            return -1;

        int right=dfsHight(root.right);
        if(right==-1)
            return -1;

        if(Math.abs(left-right)>1)
            return -1;

        return Math.max(left,right)+1;
    }
}
