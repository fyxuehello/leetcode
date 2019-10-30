package cn.edu.ustc.jianzhioffer;

import cn.edu.ustc.leetcode.util.ListNode;

/*
输入一个链表，反转链表后，输出新链表的表头。
 */
public class Number15 {
    public ListNode ReverseList(ListNode head) {
        if(head==null)
            return head;
        ListNode pre=null;
        ListNode next=null;
        while(head!=null){
            next=head.next;
            head.next=pre;

            pre=head;
            head=next;
        }
        return pre;
    }
}
