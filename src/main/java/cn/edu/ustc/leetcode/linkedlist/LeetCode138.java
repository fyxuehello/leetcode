package cn.edu.ustc.leetcode.linkedlist;

import cn.edu.ustc.leetcode.util.ListNode;
import cn.edu.ustc.leetcode.util.Node;

import java.util.PriorityQueue;
/*
题目：
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
Example 1:
Input:
{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

Explanation:
Node 1's value is 1, both of its next and random pointer points to Node 2.
Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
思路：

 */

/**
 * // Definition for a Node.
 * class Node {
 * public int val;
 * public Node next;
 * public Node random;
 * <p>
 * public Node() {}
 * <p>
 * public Node(int _val,Node _next,Node _random) {
 * val = _val;
 * next = _next;
 * random = _random;
 * }
 * };
 */
public class LeetCode138 {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        //第一轮循环，将复制的节点添加到原来的链表当中
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = new Node(cur.val, next, null);
            cur = next;
        }
        //第二轮循环是把复制节点的随机指针加上
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //
        cur = head;
        Node copyHead = cur.next;
        while (cur != null) {
            Node next = cur.next.next;
            Node copy = cur.next;
            cur.next = next;
            if (next != null) {
                copy.next = next.next;
            }
            cur = next;
        }
        return copyHead;
    }
}
