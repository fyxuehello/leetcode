package cn.edu.ustc.leetcode.linkedlist;
/*
题目：
给定一个排好序的链表，使重复的元素仅出现一次；
例如：
Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3

思路：
我们可以直接在原链表上操作，判断当前节点和它下一个节点是否相等，相等的话就跳过，否则就添加。
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
public class LinkedList83 {
    //方法1优于方法2
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        ListNode cur=head;
        while(cur!=null&&cur.next!=null){
            if(cur.val==cur.next.val){
                cur.next=cur.next.next;
            }else{
                cur=cur.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if(head==null)
            return null;

        ListNode dummy=new ListNode(0==head.val?1:0);
        dummy.next=head;
        ListNode cur=head;

        ListNode first=dummy;
        while(cur!=null&&cur.next!=null){
            if(cur.val!=cur.next.val){
                first.next=cur;
                first=first.next;
            }
            cur=cur.next;
        }
        first.next=cur;
        first=first.next;

        first.next=null;

        return dummy.next;
    }

}
