package cn.edu.ustc.jianzhioffer;

import cn.edu.ustc.leetcode.util.TreeNode;

import java.util.*;


/*
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
*/
public class Number22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null)
            return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            if(queue.peek().left!=null)
                queue.add(queue.peek().left);
            if(queue.peek().right!=null){
                queue.add(queue.peek().right);
            }
            res.add(queue.poll().val);
        }
        return res;
    }
}
