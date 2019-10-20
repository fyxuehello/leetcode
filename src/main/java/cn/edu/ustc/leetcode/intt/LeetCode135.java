package cn.edu.ustc.leetcode.intt;

/*
题目：
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
Example 1:

Input: [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
             The third child gets 1 candy because it satisfies the above two conditions.
思路：

*/
public class LeetCode135 {
    public int candy(int[] ratings) {
        if(ratings.length==0)
            return 0;
        int res=0;
        int[] num=new int[ratings.length];
        num[0]=1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1])
                num[i]=num[i-1]+1;
            else
                num[i]=1;
        }
        for(int i=ratings.length-1;i>0;i--){
            if(ratings[i-1]>ratings[i])
                num[i-1]=Math.max(num[i]+1,num[i-1]);
        }

        for(int i=0;i<num.length;i++){
            res+=num[i];
        }
        return res;
    }
}
