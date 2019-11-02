package cn.edu.ustc.jianzhioffer;


import cn.edu.ustc.leetcode.util.RandomListNode;
import cn.edu.ustc.leetcode.util.TreeNode;

import java.util.Stack;

/*
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/

public class Number26 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=pRootOfTree;
        TreeNode pre=null;//中序遍历的前一个节点
        boolean isFirst=true;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            if(isFirst){
                pRootOfTree=cur;
                pre=pRootOfTree;
                isFirst=false;
            }else{
                pre.right=cur;
                cur.left=pre;
                pre=cur;
            }
            cur=cur.right;
        }
        return pRootOfTree;
    }
}
