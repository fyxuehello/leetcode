package cn.edu.ustc.leetcode.linkedlist;
/*
题目：
判别两个链表是否有交叉点；
思路：
如果两个链表有交点，情况一：在交点之前，两个链表的长度相等，则它们同时到达交点；
情况二:在交点之前，两个长度不相等，则当链表到达末尾后，接上另一个链表，它们到达交点时也同时到达交点。
 */

import cn.edu.ustc.leetcode.util.ListNode;

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
public class LeetCode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode curA=headA,curB=headB;
        while(curA!=curB){
            curA=curA==null?headB:curA.next;
            curB=curB==null?headA:curB.next;
        }
        return curA;
    }
}
