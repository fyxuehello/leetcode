package cn.edu.ustc.leetcode.linkedlist;

import cn.edu.ustc.leetcode.util.ListNode;

import java.util.PriorityQueue;
/*
题目：
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
思路：

 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LeetCode92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null)
            return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        for(int i=1;i<m;i++){
            pre=pre.next;
        }
        ListNode start=pre.next;
        ListNode then=start.next;
        for(int i=0;i<n-m;i++){
            start.next=then.next;
            then.next=pre.next;
            pre.next=then;
            then=start.next;
        }
        return dummy.next;
    }
}
