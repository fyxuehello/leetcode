package cn.edu.ustc.jianzhioffer;


import cn.edu.ustc.leetcode.util.RandomListNode;

/*
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
*/
/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Number28 {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null)
            return null;
        RandomListNode cur=pHead;

        while(cur!=null){
            RandomListNode cloneNode=new RandomListNode(cur.label);
            RandomListNode curNext=cur.next;
            cur.next=cloneNode;
            cloneNode.next=curNext;

            cur=curNext;
        }

        cur=pHead;
        while(cur!=null){
            if(cur.random!=null){
                cur.next.random=cur.random.next;
            }
            cur=cur.next.next;
        }

        //
        cur=pHead;
        RandomListNode res=cur.next;
        while(cur!=null){
            RandomListNode oldNext=cur.next.next;
            RandomListNode copy=cur.next;
            cur.next=oldNext;
            if(oldNext!=null){
                copy.next=oldNext.next;
            }
            cur=oldNext;
        }
        return res;
    }
}
