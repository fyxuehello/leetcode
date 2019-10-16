package cn.edu.ustc.leetcode.tree;
/*
题目：
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Example 1:

Input: [1,3,null,null,2]

   1
  /
 3
  \
   2

Output: [3,1,null,null,2]

   3
  /
 1
  \
   2
Example 2:

Input: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

Output: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3

Follow up:

A solution using O(n) space is pretty straight forward.
Could you devise a constant space solution?
思路：

 */

import cn.edu.ustc.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode99 {
    TreeNode firstNode, secondNode, prevNode;

    public void recoverTree(TreeNode root) {
        inOrder(root);

        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }

    private void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.left);
        if (firstNode == null && (prevNode == null || prevNode.val >= root.val))
            firstNode = prevNode;
        if (firstNode != null && prevNode.val >= root.val)
            secondNode = root;
        inOrder(root.right);
    }
}
