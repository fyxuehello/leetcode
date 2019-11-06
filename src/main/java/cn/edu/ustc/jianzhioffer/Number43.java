package cn.edu.ustc.jianzhioffer;


/*
汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
*/

import java.util.ArrayList;

public class Number43 {
    public String LeftRotateString(String str,int n) {
        if(str==null)
            return str;
        char[] c=str.toCharArray();
        int len=c.length;
        for(int i=0,j=n-1;i<j;i++,j--){
            swap(c,i,j);
        }
        for(int i=n,j=len-1;i<j;i++,j--){
            swap(c,i,j);
        }
        for(int i=0,j=len-1;i<j;i++,j--){
            swap(c,i,j);
        }
        StringBuilder sb=new StringBuilder();
        for(char cc:c){
            sb.append(cc);
        }
        return sb.toString();
    }
    private void swap(char[] c,int i,int j){
        char temp=c[i];
        c[i]=c[j];
        c[j]=temp;
    }
}
