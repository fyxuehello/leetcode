package cn.edu.ustc.jianzhioffer;

//import cn.edu.ustc.leetcode.util.ListNode;
//import cn.edu.ustc.leetcode.util.TreeLinkNode;

import cn.edu.ustc.leetcode.util.TreeLinkNode;

/*
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Number57 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode==null)
            return pNode;
        if(pNode.right!=null){//如果该节点有右子树的话
            pNode=pNode.right;
            while(pNode.left!=null){
                pNode=pNode.left;
            }
            return pNode;
        }
        while(pNode.next!=null){
            if(pNode.next.left==pNode)
                return pNode.next;
            pNode=pNode.next;
        }
        return null;
    }

}
