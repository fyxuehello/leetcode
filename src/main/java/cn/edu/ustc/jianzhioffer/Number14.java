package cn.edu.ustc.jianzhioffer;

import cn.edu.ustc.leetcode.util.ListNode;

/*
输入一个链表，输出该链表中倒数第k个结点。
 */
public class Number14 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if(head==null)
            return head;
        int count=0;
        ListNode node=head;
        while(node!=null){
            node=node.next;
            count++;
        }
        if(count<k)
            return null;
        ListNode res=head;
        for(int i=0;i<count-k;i++){
            res=res.next;
        }
        return res;
    }
}
