package cn.edu.ustc.jianzhioffer;


import cn.edu.ustc.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.Collections;

/*
输入两个链表，找出它们的第一个公共结点。
*/

public class Number36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1=pHead1;
        ListNode p2=pHead2;
        while(p1!=p2){
            p1=p1==null?pHead2:p1.next;
            p2=p2==null?pHead1:p2.next;
        }
        return p1;
    }
    //解法二，分别先计算出两条链表的长度，然后让长的链表先走二者的长度差；
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        int len1=FindLen(pHead1);
        int len2=FindLen(pHead2);
        if(len1<len2){
            pHead2=walkFirst(pHead2,len2-len1);
        }else{
            pHead1=walkFirst(pHead1,len1-len2);
        }
        while(pHead1 != null){
            if(pHead1 == pHead2) return pHead1;
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }


    private int FindLen(ListNode list){
        int len=0;
        while(list!=null){
            len++;
            list=list.next;
        }
        return len;
    }
    private ListNode walkFirst(ListNode list,int step){
        while(step-->0){
            list=list.next;
        }
        return list;
    }
}
