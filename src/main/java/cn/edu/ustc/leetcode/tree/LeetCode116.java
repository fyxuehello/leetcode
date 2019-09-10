package cn.edu.ustc.leetcode.tree;
/*
题目：
Populating Next Right Pointers in Each Node.
Populate each next pointer to point to its next right node.
If there is no next right node, the next pointer should be set to NULL.

思路：
每一个节点都指向其右侧节点，最右侧节点指向null；
一层一层的开始往下遍历，从每一层的最左边开始，到最右边结束；

 */

import cn.edu.ustc.leetcode.util.Node;


/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
public class LeetCode116 {
    public Node connect(Node root) {//一层一层的往下执行
        Node res=root;
        while(root!=null&&root.left!=null){
            Node cur=root;
            while(cur!=null){
                cur.left.next=cur.right;
                cur.right.next=cur.next==null?null:cur.next.left;
                cur=cur.next;
            }
            root=root.left;
        }
        return res;
    }
}
