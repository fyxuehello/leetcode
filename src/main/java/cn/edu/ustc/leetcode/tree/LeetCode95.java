package cn.edu.ustc.leetcode.tree;
/*
题目：
给定一个整数，输出值为1~n的所有二叉查找树。

思路：
根节点的值为i，则其左子树为1~i-1,右子树为i+1~n;递归遍历其左右子树；

 */

import cn.edu.ustc.leetcode.util.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode95 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list=new ArrayList<>();
        list=getTrees(1,n);
        if(list.get(0)==null){
            return new ArrayList<TreeNode>();
        }else{
            return list;
        }
    }
    private List<TreeNode> getTrees(int start,int end){
        List<TreeNode> list=new ArrayList<>();
        if(start>end) {
            list.add(null);
            return list;
        }

        for(int i=start;i<=end;i++){
            List<TreeNode> leftList=getTrees(start,i-1);
            List<TreeNode> rightList=getTrees(i+1,end);
            for(TreeNode left:leftList){
                for(TreeNode right:rightList){
                    TreeNode root=new TreeNode(i);
                    root.left=left;
                    root.right=right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
