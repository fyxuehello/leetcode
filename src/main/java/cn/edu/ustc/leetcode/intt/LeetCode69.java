package cn.edu.ustc.leetcode.intt;

/*
题目：
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since
             the decimal part is truncated, 2 is returned.
思路：

 */
public class LeetCode69 {
    public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;
        int left = 1, right = x;
        while (true) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if ((mid + 1) > x / (mid + 1))
                    return mid;
                left = mid - 1;
            }
        }
    }
    public int mySqrt2(int x) {
        if(x==0||x==1){
            return x;
        }
        int left=1,right=x;
        while(left<=right){
            int mid=left+right>>>1;
            if(mid>mid/x){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return right;
    }
}
