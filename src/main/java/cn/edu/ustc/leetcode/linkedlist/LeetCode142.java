package cn.edu.ustc.leetcode.linkedlist;
/*同上一题，都是链表有环的问题，这题要求返回链表环开始的地方；
Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
Example 2:

Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.
思路：我们用三个指针，第一个指针每次走两步，第二个指针每次走一步；
当二者重合的时候(说明其链表存在环)第三个指针开始走，当第二个指针和第三个指针重合的时候返回第三个指针即可。
提示：当第一个指针和第二个指针重合的时候距离环开始的地方与第三个指针到环开始的地方相等。

 */

import cn.edu.ustc.leetcode.util.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LeetCode142 {
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        ListNode slow=head,fast=head,start=head;
        while (fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                while(slow!=start){
                    slow=slow.next;
                    start=start.next;
                }
                return start;
            }
        }
        return null;
    }
}
