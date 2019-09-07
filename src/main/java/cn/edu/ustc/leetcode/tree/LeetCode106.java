package cn.edu.ustc.leetcode.tree;
/*
题目：
给出一个二叉树的中序和后序遍历得到的数组，重构此二叉树；

思路：
先序遍历：跟、左、右
中序遍历：左、跟、右
后序遍历：左、右、跟

递归重构二叉树，三步走；
第一步：明确方法的作用；
第二步：递归退出条件；
第三步：递推关系式。首先根据后序遍历结果找到根节点，其次找到根节点在中序遍历中的索引；
再推出二叉树的左子树和右子树对应的中序和后序遍历的数组，递归调用即可；
 */

import cn.edu.ustc.leetcode.util.TreeNode;

import java.util.Arrays;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //递归退出条件
        if(inorder==null||postorder==null||inorder.length==0||postorder.length==0)
            return null;
        //二叉树根节点
        TreeNode root=new TreeNode(postorder[postorder.length-1]);
        //中序遍历根节点的索引
        int i=0;
        for(;i<inorder.length;i++){
            if(inorder[i]==postorder[postorder.length-1])
                break;
        }
        //构造左子树的中序和后序遍历数组
        int[] leftIn=Arrays.copyOfRange(inorder,0,i);
        int[] leftPost=Arrays.copyOfRange(postorder,0,i);

        //构造右子树的中序和后序遍历数组
        int[] rightIn=Arrays.copyOfRange(inorder,i+1,inorder.length);
        int[] rightPost=Arrays.copyOfRange(postorder,i,postorder.length-1);
        //
        root.left=buildTree(leftIn,leftPost);
        root.right=buildTree(rightIn,rightPost);
        return root;
    }
}
