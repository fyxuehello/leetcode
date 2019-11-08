package cn.edu.ustc.jianzhioffer;


import cn.edu.ustc.leetcode.util.ListNode;

/*
给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
*/
/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Number53 {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null||pHead.next==null||pHead.next.next==null)
            return null;
        ListNode slow=pHead.next;
        ListNode fast=pHead.next.next;
        while(slow!=fast){
            if(fast.next!=null&&fast.next.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }else{
                return null;
            }
        }
        //从而证明有环
        slow=pHead;
        while(slow!=fast){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }

}
