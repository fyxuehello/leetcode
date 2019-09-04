package cn.edu.ustc.leetcode.linkedlist;

import cn.edu.ustc.leetcode.util.ListNode;
/*
题目：
给定一个值，移除链表中所有与之相等的节点

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5

思路：
我们直接的遍历链表，如果与给定的值相等那么久跳过，否则就添加。
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
public class LeetCode203 {
    //使用两个指针
    public ListNode removeElements1(ListNode head, int val) {
        if(head==null)
            return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy,cur=head;
        while(cur!=null){
            if(cur.val==val){
                pre.next=cur.next;
            }else {
                pre=pre.next;
            }
            cur=cur.next;
        }
        return dummy.next;
    }
    //使用一个指针
    public ListNode removeElements2(ListNode head, int val) {
        if(head==null||head.next==null)
            return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode cur=dummy;
        while(cur.next!=null){
            if(cur.next.val==val){
                cur.next=cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
