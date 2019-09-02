package cn.edu.ustc.leetcode.linkedlist;
/*
题目：
给定一个链表，L: L0→L1→…→Ln-1→Ln,
反转之后: L0→Ln→L1→Ln-1→L2→Ln-2→…

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.

Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

思路：
第一步：先找到链表的中点；
第二步：将链表中点之后的链表反转
第三步：将两个链表合并即可。
 */

import cn.edu.ustc.leetcode.util.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LeetCode143 {
    public void reorderList(ListNode head) {
        if(head==null)
            return;
        //第一步
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //第二步
        ListNode head2=reverse(slow.next);
        slow.next=null;

        //第三步
        while(head!=null&&head2!=null){
            ListNode temp1=head.next;
            ListNode temp2=head2.next;

            head2.next=head.next;
            head.next=head2;
            head=temp1;
            head2=temp2;
        }
    }
    private ListNode reverse(ListNode node){
        ListNode prev=null;
        ListNode cur=node;
        while(cur!=null){
            ListNode temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        return prev;
    }
}
