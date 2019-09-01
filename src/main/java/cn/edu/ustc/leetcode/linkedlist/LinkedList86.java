package cn.edu.ustc.leetcode.linkedlist;
/*
题目：
给定链表和值x，对其进行分区，使得小于x的所有节点都在大于或等于x的节点之前。
例如：
Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5

思路：
定义两个链表，第一个链表存储比x值小的元素，第二个链表存储大于或等于x值得元素。
最后再将两个链表连接起来即可。
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
public class LinkedList86 {
    public ListNode partition(ListNode head, int x) {
        ListNode smaller=new ListNode(0),bigger=new ListNode(0);
        ListNode smallerCur=smaller,biggrCur=bigger;
        while(head!=null){
            if(head.val<x){
                smallerCur.next=head;
                smallerCur=smallerCur.next;
            }else{
                biggrCur.next=head;
                biggrCur=biggrCur.next;
            }
            head=head.next;
        }
        biggrCur.next=null;
        smallerCur.next=bigger.next;
        return smaller.next;
    }
}
