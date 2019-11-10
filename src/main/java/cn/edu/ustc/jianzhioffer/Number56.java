package cn.edu.ustc.jianzhioffer;

import cn.edu.ustc.leetcode.util.ListNode;

/*
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Number56 {
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead==null)
            return pHead;
        ListNode head=new ListNode(0);
        head.next=pHead;
        ListNode pre=head;
        ListNode cur=head.next;
        while(cur!=null){
            if(cur.next!=null&&cur.val==cur.next.val){
                while(cur.next!=null&&cur.val==cur.next.val){
                    cur=cur.next;
                }
                pre.next=cur.next;
                cur=cur.next;
            }else{
                pre=pre.next;
                cur=cur.next;
            }
        }
        return head.next;
    }
}
