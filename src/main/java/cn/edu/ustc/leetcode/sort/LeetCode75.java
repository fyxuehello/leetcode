package cn.edu.ustc.leetcode.sort;
/*
题目：
Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
要求：
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's,
then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?

思路：
使用两个指针low和high，low对应着数字0，high对应着数字2，从两端开始巡回。
 */
public class LeetCode75 {
    public void sortColors(int[] nums) {
        if(nums==null||nums.length<=1)
            return;
        int low=0,high=nums.length-1;
        for(int i=0;i<=high;){
            if(nums[i]==0){
                int temp=nums[low];
                nums[low]=nums[i];
                nums[i]=temp;
                 i++;low++;//此处有i++的原因是，low和i交换了数字，low在前面，i在后面，这样交换后的i的值肯定还可以再遇到；
            }else if(nums[i]==2){
                int temp=nums[high];
                nums[high]=nums[i];
                nums[i]=temp;
                high--;//此处没有i++的原因是，high和i交换了数字，high在后面，判断条件是i<=high，这样交换后需要再次处理这个值
            }else{
                i++;
            }
        }
    }
}
