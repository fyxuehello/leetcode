package cn.edu.ustc.jianzhioffer;

import cn.edu.ustc.leetcode.util.ListNode;
import cn.edu.ustc.leetcode.util.TreeNode;

/*
输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
*/
public class Number17 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root1==null||root2==null)
            return false;
        return helper(root1,root2)||helper(root1.left,root2)||helper(root1.right,root2);
    }
    private boolean helper(TreeNode root1,TreeNode root2){
        if(root2==null)
            return true;
        if(root1==null)
            return false;
        if(root1.val==root2.val){
            return helper(root1.left,root2.left)&&
                    helper(root1.right,root2.right);
        }else{
            return false;
        }

    }
}
