package cn.edu.ustc.jianzhioffer;


import cn.edu.ustc.leetcode.util.TreeNode;

import java.util.ArrayList;

/*
输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
(注意: 在返回值的list中，数组长度大的数组靠前)

*/
public class Number24 {
    ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    ArrayList<Integer> list=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root==null)
            return res;
        list.add(root.val);
        target-=root.val;
        if(target==0&&root.left==null&&root.right==null)
            res.add(new ArrayList<Integer>(list));
        else{
            FindPath(root.left,target);
            FindPath(root.right,target);
        }
        list.remove(list.size()-1);
        return res;
    }

    //法2
    public ArrayList<ArrayList<Integer>> FindPath2(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null)
            return res;
        backtrace(root,target,res,list);
        return res;
    }
    private void backtrace(TreeNode root,int target,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> list){
        if(root==null)
            return;
        list.add(root.val);
        if(root.left==null&&root.right==null&&root.val==target){
            res.add(new ArrayList<Integer>(list));
        }else{
            backtrace(root.left,target-root.val,res,list);
            backtrace(root.right,target-root.val,res,list);
        }
        list.remove(list.size()-1);
    }
}
