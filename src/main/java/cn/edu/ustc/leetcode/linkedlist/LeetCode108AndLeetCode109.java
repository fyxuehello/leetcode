package cn.edu.ustc.leetcode.linkedlist;

import cn.edu.ustc.leetcode.util.ListNode;
import cn.edu.ustc.leetcode.util.TreeNode;
/*
leetcode108
题目：
给定一个数组，其中元素按升序排序，将其转换为高度平衡的BST。
高度平衡的二叉树被定义为二叉树，其中每个节点的两个子树的深度从不相差超过1。

思路：
首先找到数组的中点，将中点作为根节点，中点的左边作为根节点的左子树，根节点的右边作为根节点的右子树；
递归生成根节点以及根节点的左子树和右子树

leetcode109
题目：
给定一个链表，其中链表的元素按升序排序，将其转换为高度平衡的BST。
高度平衡的二叉树被定义为二叉树，其中每个节点的两个子树的深度从不相差超过1。

思路：
同样找到链表的中点，然后再依次生成左子树和右子树即可。
链表不能像数组那样通过索引或许元素的值，必须一个个元素的轮回来找到中点；
我们可以通过两个指针来找到中点，第一个指针每次移动一格，第二个指针每次移动两个，
这样当第二个指针到达末尾时，第一个指针刚好到达中点。
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode108AndLeetCode109 {
    //leetcode108
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    public TreeNode helper(int[] nums,int left,int right){
        if(left>right)
            return null;
        int mid=left+(right-left)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=helper(nums,left,mid-1);
        root.right=helper(nums,mid+1,right);

        return root;
    }

    //leetcode 109
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        return helper2(head,null);
    }
    public TreeNode helper2(ListNode head,ListNode tail){
        if(head==tail)
            return null;//递归退出条件

        ListNode slow=head;
        ListNode fast=head;

        while(fast!=tail&&fast.next!=tail){
            fast=fast.next.next;
            slow=slow.next;
        }//slow对应的中点

        TreeNode root=new TreeNode(slow.val);
        root.left=helper2(head,slow);
        root.right=helper2(slow.next,tail);

        return root;
    }

}
