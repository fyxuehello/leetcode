package cn.edu.ustc.leetcode.linkedlist;

import cn.edu.ustc.leetcode.util.ListNode;
/*
题目：
判断一个链表是否是回文链表。
Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true

思路：
首先找到链表的中点，以中点为节点分为两部分，将后一部分反转后和前一部分进行比较；
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LeetCode234 {
    public boolean isPalindrome(ListNode head) {
        if(head==null)
            return true;
        //第一步，找到链表的中点
        ListNode slow=head,fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //第二步，反转后一半的链表
        slow=reverse(slow);
        fast=head;
        //第三步，逐一比较
        while(slow!=null&&fast!=null){
            if(slow.val!=fast.val){
                return false;
            }
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }
    private ListNode reverse(ListNode node){
        ListNode cur=node,pre=null;
        while(cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
    
}
