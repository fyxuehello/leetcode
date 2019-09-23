package cn.edu.ustc.leetcode.dynamicProgramming;

import cn.edu.ustc.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
题目：
给一个数字 n ,BST的各节点由(1,n)组成，输出不重复的BST。
Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
思路：
利用动态规划做，BST的中序遍历是1~n,则以为根节点，则其左子树为1~i-1,右子树为i+1~n；
递归调用这个根节点的左子树和右子树，然后连接所有可能的组合。
 */
public class LeetCode95 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list=new ArrayList<>();
        list=getTree(1,n);
        if(list.get(0)==null){
            return new ArrayList<>();
        }else{
            return list;
        }
    }
    private List<TreeNode> getTree(int start,int end){
        List<TreeNode> list=new ArrayList<>();
        if(start>end){
            list.add(null);
            return list;
        }
        List<TreeNode> left,right;
        for(int i=start;i<=end;i++){
            left=getTree(start,i-1);
            right=getTree(i+1,end);
            for(TreeNode lleft:left){
                for(TreeNode rright:right){
                    TreeNode root=new TreeNode(i);
                    root.left=lleft;
                    root.right=rright;
                    list.add(root);
                }
            }
        }
        return list;
    }
}

