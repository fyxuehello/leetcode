package cn.edu.ustc.leetcode.tree;
/*
题目：输出一棵二叉树右视图的结果

思路：

迭代：类似于层序遍历，只是我们只输出每一层最右边的结果；
 */

import cn.edu.ustc.leetcode.util.TreeNode;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();

        if(root==null)
            return res;
        queue.add(root);

        while (!queue.isEmpty()){
            int levelNum=queue.size();
            while(levelNum-->0){
                TreeNode cur=queue.poll();
                if (levelNum == 0) {
                    res.add(cur.val);
                }
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                }
            }
        }
        return res;
    }
}


