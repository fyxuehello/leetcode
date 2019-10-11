package cn.edu.ustc.leetcode.linkedlist;

import cn.edu.ustc.leetcode.util.ListNode;

import java.util.PriorityQueue;
/*
题目：
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
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
public class LeetCode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return partion(lists,0,lists.length-1);
    }
    public static ListNode partion(ListNode[] lists,int s,int e){
        if(s==e)  return lists[s];
        if(s<e){
            int q=(s+e)/2;
            ListNode l1=partion(lists,s,q);
            ListNode l2=partion(lists,q+1,e);
            return merge(l1,l2);
        }else
            return null;
    }

    //This function is from Merge Two Sorted Lists.
    public static ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                tail.next=l1;
                l1=l1.next;
            }else{
                tail.next=l2;
                l2=l2.next;
            }
            tail=tail.next;
        }
        if(l1!=null){
            tail.next=l1;
        }
        if(l2!=null){
            tail.next=l2;
        }
        return dummy.next;
    }
    public ListNode mergeKLists2(ListNode[] lists) {
        if(lists==null||lists.length==0)
            return null;
        PriorityQueue<ListNode> queue=new PriorityQueue<>(lists.length,(a1,a2)->(a1.val-a2.val));
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        for(ListNode node:lists){
            if(node!=null){
                queue.add(node);
            }
        }
        while(!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            if(tail.next!=null){
                queue.add(tail.next);
            }
        }
        return dummy.next;
    }
}
