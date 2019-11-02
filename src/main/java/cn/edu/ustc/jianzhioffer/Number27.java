package cn.edu.ustc.jianzhioffer;


import cn.edu.ustc.leetcode.util.RandomListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
输入一个字符串,按字典序打印出该字符串中字符的所有排列。
例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。

输入描述:
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
*/


public class Number27 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res=new ArrayList<>();
        if(str!=null&&str.length()>0){
            backtrace(str.toCharArray(),0,res);
            Collections.sort(res);
        }
        return res;
    }
    private void backtrace(char[] ch,int start,ArrayList<String> res){
        if(start==ch.length-1)
            res.add(String.valueOf(ch));
        else{
            Set<Character> set=new HashSet<>();
            for(int i=start;i<ch.length;i++){
                if(i==start||!set.contains(ch[i])){
                    set.add(ch[i]);
                    swap(ch,start,i);
                    backtrace(ch,start+1,res);
                    swap(ch,i,start);
                }
            }
        }
    }
    private void swap(char[] ch,int i,int j){
        char temp=ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
    }
}
