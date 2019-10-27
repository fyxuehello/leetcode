package cn.edu.ustc.leetcode.binarysearch;

/**
 * 二分查找
 * 时间复杂度为O(logn)，空间复杂度为O(1)
 * 查询区间为[left,right]
 *
 * 碰到有序数组，并要求时间复杂度在O(logn)的情况，优先考虑二分查找
 *循环条件while(left<=right)时，right=mid-1;
 *循环条件while(left<right)时，right=mid;
 */
public class summary {
    /*
    基本形式：给定一个数组nums,和一个需要查找的target，返回找到元素的下标；
    注意，数组中没有重复的元素
     */
    public int binarySearch(int[] nums,int target){
        if(nums==null||nums.length==0)
            return -1;
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]==target){
                return mid;
            }else{
                right=mid-1;
            }
        }
        return left;
    }
    /*
    变形1：
    在一个有重复元素的数组中查找 key 的最左位置
     */
    public int binarySearch1(int[] nums,int target){
        if(nums==null||nums.length==0)
            return -1;
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>=target){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }
    /*
    变形2：
    求开方sqrt(x)
     */
    public int binarySearch2(int x){
        if(x==0||x==1)
            return x;
        int left=1,right=x;
        while(left<=right) {
            int mid=left+(right-left)/2;
            if(mid==x/mid){//防止溢出
                return mid;
            }else if(mid>x/mid){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return right;
    }
    /*
    变形3：
    大于给定元素的最小元素
    给定一个有序的字符数组 letters 和一个字符 target，
    要求找出 letters 中大于 target 的最小字符，如果找不到就返回第 1 个字符。
     */
    public int binarySearch3(char[] nums,char target){
        int left=1,right=nums.length-1;
        while(left<=right) {
            int mid=left+(right-left)/2;
            if(nums[mid]<=target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left<nums.length?nums[left]:nums[0];
    }
    /*
    变形4：有序数组的 Single Element
    题目描述：一个有序数组只有一个数不出现两次，找出这个数。
    Input: [1, 1, 2, 3, 3, 4, 4, 8, 8]
    Output: 2
    要求以 O(logN) 时间复杂度进行求解，因此不能遍历数组并进行异或操作来求解，
    这么做的时间复杂度为 O(N)。
     */
    //public int binarySearch4(int[] nums){

    //}
    /*
    旋转数组的最小数字
    Input: [3,4,5,1,2],
    Output: 1
     */
    public int binarySearch4(int[] nums){
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<=nums[right]){
                mid=right;
            }else{
                mid=left+1;
            }
        }
        return nums[left];
    }
}
