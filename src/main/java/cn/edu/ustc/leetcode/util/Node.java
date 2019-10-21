package cn.edu.ustc.leetcode.util;


public class Node {
    public int val;
    public static Node left;
    public static Node right;
    public static Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
    public static Node random;


    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }

}
