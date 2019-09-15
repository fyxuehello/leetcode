package cn.edu.ustc.leetcode.sort;

import cn.edu.ustc.leetcode.util.ListNode;

/*
题目：
Sort a linked list in O(n log n) time using constant space complexity.

思路：
从中间的位置将链表分为两部分，两部分分别递归调用原方法排序，最后再合并即可。
 */
public class LeetCode148 {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode slow=head,fast=head,pre=null;
        while(fast!=null&&fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        pre.next=null;//将链表从中点处截断

        ListNode l1=sortList(head);
        ListNode l2=sortList(slow);
        return merge(l1,l2);
    }
    private ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;

        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;

        }
        if(l1!=null)
            cur.next=l1;
        if(l2!=null)
            cur.next=l2;
        return dummy.next;
    }
}
