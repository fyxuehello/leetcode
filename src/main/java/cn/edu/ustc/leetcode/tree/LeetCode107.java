package cn.edu.ustc.leetcode.tree;
/*
题目：
给出一个二叉树，返回其从底到顶，层序遍历的结果
FFor example:
Given binary tree [3,9,20,null,null,15,7],
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]

思路：
二叉树的前序、中序和后序遍历都可以利用stack来协助，
层序遍历我们是用queue来存树的每一层的节点，只要当前节点的左子树或右子树不为空，就把当前节点的子节点添加到queue。

使用ArrayList.add(0,value)方法；
 */

import cn.edu.ustc.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode107 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();

        if(root==null)
            return res;

        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> subList=new ArrayList<>();
            int levelNum=queue.size();
            for(int i=0;i<levelNum;i++){
                if(queue.peek().left!=null){
                    queue.add(queue.peek().left);
                }
                if(queue.peek().right!=null){
                    queue.add(queue.peek().right);
                }
                subList.add(queue.poll().val);
            }
            res.add(0,subList);
        }
        return res;
    }
}
