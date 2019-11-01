package cn.edu.ustc.jianzhioffer;

import cn.edu.ustc.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/*

输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

二叉搜索树的后序遍历，
最后一个节点是根节点，那么它的右子树都大于此节点，左子树都小于此节点。
右子树和左子树都符合此性质。
*/
public class Number23 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0)
            return false;
        return helper(sequence,0,sequence.length-1);
    }
    private boolean helper(int[] sequence,int l,int r){
        if(l>=r)
            return true;
        int i=r;
        while(i>l&&sequence[i-1]>sequence[r])
            i--;
        for(int j=i-1;i>=l;i--){
            if(sequence[j]>sequence[r])
                return false;
        }
        return helper(sequence,l,i-1)&&helper(sequence,i,r-1);
    }
}
