package cn.edu.ustc.leetcode.linkedlist;
/*
题目：
给定一个链表，利用插入排序将其排序；
Example 1:

Input: 4->2->1->3
Output: 1->2->3->4

Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
思路：
利用一个游针(prev)，来回在已经排序好的链表进行比较，然后找到合适的位置插入。
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
public class LeetCode147 {
    public ListNode insertionSortList(ListNode head) {
        if(head==null)
            return head;
        ListNode dummy=new ListNode(0);
        ListNode cur=head;
        ListNode prev=dummy;//节点插入在prev和prev.next中间
        ListNode next=null;
        while (cur != null) {
            next=cur.next;
            //找到合适的插入点
            while(prev.next!=null&&prev.next.val<cur.val){
                prev=prev.next;
            }
            //插入节点
            cur.next=prev.next;
            prev.next=cur;

            prev=dummy;
            cur=next;
        }
        return dummy.next;
    }
}
