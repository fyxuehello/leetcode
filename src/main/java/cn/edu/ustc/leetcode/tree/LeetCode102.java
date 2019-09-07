package cn.edu.ustc.leetcode.tree;
/*
题目：
层序遍历一个二叉树
For example:
Given binary tree [3,9,20,null,null,15,7]

return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

思路：
二叉树的前序、中序和后序遍历都可以利用stack来协助，
层序遍历我们是用queue来存树的每一层的节点，只要当前节点的左子树或右子树不为空，就把当前节点的子节点添加到queue。
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
public class LeetCode102 {
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
            res.add(subList);
        }
        return res;
    }
}
