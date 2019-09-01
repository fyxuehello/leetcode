package cn.edu.ustc.leetcode.linkedlist;

import cn.edu.ustc.leetcode.util.ListNode;
/*
题目：
将链表的节点两两交换；

思路：
用三个指针指向当前current，当前指针的下一个first，当前指针的下下一个second;
然后改变它们的指向，达到我们的要求即可。
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        ListNode result=new ListNode(0);
        result.next=head;
        ListNode current=result;
        while(current.next!=null&&current.next.next!=null){
            ListNode first=current.next;
            ListNode second=current.next.next;

            first.next=second.next;
            second.next=first;
            current.next=second;
            current=first;
        }
        return result.next;

    }
}
