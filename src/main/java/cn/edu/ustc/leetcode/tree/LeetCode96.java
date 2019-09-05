package cn.edu.ustc.leetcode.tree;
/*
题目：
给定一个整数，输出有多少种二叉查找树(二叉搜索树或者二叉排序树)，这个二叉查找树的值为1-n;

思路：
二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）它或者是一棵空树，
或者是具有下列性质的二叉树： 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
它的左、右子树也分别为二叉排序树。

采用动态规划来做，首先我们定义两个函数G[n]，表示长度为n的二叉查找树的个数；
F[i,n]表示二叉查找树的根为i,长度为n的个数；
所以：G[n]=F[1,n]+F[2,n]+...F[n,n];G[0]=G[1]=1;
例如：F[4,8]表示[1,2,3]作为其左子树，[5,6,7,8]作为其右子树,所以F[4,8]=G[3]*G[4];
进而，F[i,n]=G[i-1]*G[n-i];
G[n]=G[0]*G[n-1]+G[1]*G[n-2]+...+G[n-1]G[0];
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
public class LeetCode96 {
    public int numTrees(int n) {
        int[] G=new int[n+1];
        G[0]=G[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                G[i]+=G[j-1]*G[i-j];
            }
        }
        return G[n];
    }
}
