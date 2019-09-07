package cn.edu.ustc.leetcode.tree;
/*
题目：
给出一个二叉树的前序和中序遍历得到的数组，重构此二叉树；

思路：
递归重构二叉树，三步走；
第一步：明确方法的作用；
第二步：递归退出条件；
第三步：递推关系式。首先根据先序遍历结果找到根节点，其次找到根节点在中序遍历中的索引；
再推出二叉树的左子树和右子树对应的前序和中序遍历的数组，递归调用即可；
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
public class LeetCode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //递归退出条件
        if(preorder==null||inorder==null||preorder.length==0||inorder.length==0)
            return null;
        //找出根节点
        TreeNode root=new TreeNode(preorder[0]);
        //根节点在中序遍历中的索引
        int i=0;
        for(;i<inorder.length;i++){
            if(inorder[i]==preorder[0])
                break;
        }
        //根节点的左子树的先序和中序遍历数组
        int[] leftPreorder= Arrays.copyOfRange(preorder,1,i+1);
        int[] leftInOrder=Arrays.copyOfRange(inorder,0,i);

        //根节点的右子树的先序和中序遍历结果
        int[] rightPreorder=Arrays.copyOfRange(preorder,i+1,preorder.length);
        int[] rightInorder=Arrays.copyOfRange(inorder,i+1,inorder.length);

        //递归重构根节点的左子树和右子树
        root.left=buildTree(leftPreorder,leftInOrder);
        root.right=buildTree(rightPreorder,rightInorder);

        return root;
    }
}
