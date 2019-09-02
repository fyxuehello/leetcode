package cn.edu.ustc.leetcode.linkedlist;

/*
题目：
给定一个链表判定其是否存在环；

Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the first node.

Example 3:

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.

思路：
我们用两个指针，第一个指针每次走两步，第二个指针每次走一步；
如果这两个指针有重合的时候，那么该链表有环；否则，没有。
 */

import cn.edu.ustc.leetcode.util.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Leetcode141 {
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return  false;

        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast)
                return true;
        }
        return false;
    }
}
