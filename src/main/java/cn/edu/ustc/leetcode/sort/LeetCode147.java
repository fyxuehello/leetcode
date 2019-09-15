package cn.edu.ustc.leetcode.sort;

import cn.edu.ustc.leetcode.util.ListNode;

/*
题目：
给定一个链表，按照插入排序将其排序

思路：
使用三个指针，pre，cur和next；
 */
public class LeetCode147 {
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode dummy=new ListNode(0);
        ListNode pre=dummy,cur=head,next=null;
        while(cur!=null){
            next=cur.next;
            while(pre.next!=null && pre.next.val<cur.val){
                pre=pre.next;//找到合适的插入位置
            }

            cur.next=pre.next;
            pre.next=cur;

            cur=next;
            pre=dummy;
        }
        return dummy.next;
    }
}
