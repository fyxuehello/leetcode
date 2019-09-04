package cn.edu.ustc.leetcode.linkedlist;

import cn.edu.ustc.leetcode.util.ListNode;
/*
题目：
反转链表；
思路：
使用两个指针，一个指向前一个，另一个指向当前节点。
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
public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
       ListNode dummy=new ListNode(0);
       ListNode pre=null,cur=head;
       while(cur!=null){
           ListNode temp=cur.next;
           cur.next=pre;
           pre=cur;
           cur=temp;
       }
       return pre;
    }
    
}
