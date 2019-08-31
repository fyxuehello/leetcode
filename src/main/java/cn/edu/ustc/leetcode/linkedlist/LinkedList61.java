package cn.edu.ustc.leetcode.linkedlist;

import cn.edu.ustc.leetcode.util.ListNode;
/*
题目：
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL
示例 2:

输入: 0->1->2->NULL, k = 4
输出: 2->0->1->NULL
解释:
向右旋转 1 步: 2->0->1->NULL
向右旋转 2 步: 1->2->0->NULL
向右旋转 3 步: 0->1->2->NULL
向右旋转 4 步: 2->0->1->NULL
 */

/**
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LinkedList61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null)return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;

        ListNode slow=dummy;
        ListNode fast=dummy;

        int i=0;
        for (;fast.next!=null;i++){//Get the total length
            fast=fast.next;
        }

        for(int j=i-k%i;j>0;j--){
            slow=slow.next;
        }

        fast.next=dummy.next;
        dummy.next=slow.next;
        slow.next=null;

        return dummy.next;
    }
}
