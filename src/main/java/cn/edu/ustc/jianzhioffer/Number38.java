package cn.edu.ustc.jianzhioffer;


/*
输入一棵二叉树，求该树的深度。
从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
*/

import cn.edu.ustc.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Number38 {
    //递归
    public int TreeDepth(TreeNode root) {
        if(root==null)
            return 0;
        int leftDepth=TreeDepth(root.left);
        int rightDepth=TreeDepth(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }
    //循环,利用层次遍历
    public int TreeDepth2(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int depth=0,count=0,levelCount=1;
        while(queue.size()!=0){
            TreeNode top=queue.poll();
            count++;
            if(top.left!=null)
                queue.add(top.left);
            if(top.right!=null)
                queue.add(top.right);
            if(count==levelCount){
                levelCount=queue.size();
                count=0;
                depth++;
            }
        }
        return depth;
    }
}
