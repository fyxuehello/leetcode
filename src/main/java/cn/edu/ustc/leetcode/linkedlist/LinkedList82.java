package cn.edu.ustc.leetcode.linkedlist;
/*
题目：
给定一个排好序的链表，移除它所有重复的元素，返回那些独一无二的元素；

Example 1:
Input: 1->2->3->3->4->4->5
Output: 1->2->5


Example 2:
Input: 1->1->1->2->3
Output: 2->3

思路：
使用两个指针，一个指向前一个元素，另一个指向当前元素，判断前一个元素，
当前元素以及当前元素的下一个是否相等，只要有相等的便移除所有相等的元素。
注意，最后一个元素要单独判别。
 */

import cn.edu.ustc.leetcode.util.ListNode;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LinkedList82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        ListNode dummy=new ListNode(0==head.val?1:0);
        dummy.next=head;

        ListNode pre=dummy;
        ListNode cur=head;
        ListNode first=dummy;
        while(cur!=null&&cur.next!=null){
            if(cur.val!=pre.val&&cur.next.val!=cur.val){
                first.next=cur;
                first=first.next;
            }
            pre=cur;
            cur=cur.next;
        }
        if(pre.val!=cur.val){
            first=cur;
            first=first.next;
        }
        first.next=null;

        return dummy.next;
    }
}