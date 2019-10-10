package cn.edu.ustc.leetcode.intt;

/*
题目：
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

思路：

*/
public class LeetCode31 {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2)
            return;
        int n = nums.length, pos = -1, posValue = 0;
        //从后向前找到第一个不递增的数字
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pos = i;
                posValue = nums[i];
                break;
            }
        }
        //6,5,4,3,2,1的情况
        if (pos == -1) {
            reverse(nums, 0, n);
            return;
        }
        //从后向前找到第一个大于pos位置上的数字，并交换
        for (int i = n; i >= 0; i--) {
            if (nums[i] > posValue) {
                swap(nums, i, pos);
                break;
            }
        }
        //从pos+1的位置开始往后反转
        reverse(nums, pos + 1, n);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
