package cn.edu.ustc.jianzhioffer;


import java.util.ArrayList;
import java.util.Collections;

/*
HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,
他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
*/

public class Number30 {
    public int FindGreatestSumOfSubArray(int[] array) {//动态规划
        int len=array.length;
        int[] dp=new int[len];
        dp[0]=array[0];
        int max=array[0];
        for(int i=1;i<len;i++){
            dp[i]=array[i]+(dp[i-1]>0?dp[i-1]:0);
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    public int FindGreatestSumOfSubArray2(int[] array) {
        int len=array.length;
        int curMax=0;
        int max=-Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            if(curMax<=0){
                curMax=array[i];
            }else if(curMax>0){
                curMax+=array[i];
            }
            if(curMax>max){
                max=curMax;
            }
        }
        return  max;

    }
}
