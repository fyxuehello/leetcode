package cn.edu.ustc.nowcoderalgorithm.sort;

/*
桶排序，时间复杂度O(N+K)，空间复杂度O(N+K),稳定；

思路：

 */
public class BucketSort {
    public void bucketSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        //找到所有元素的最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        //构造max+1个桶
        int[] bucket = new int[max + 1];

        //把元素放到相应的桶内,记录每个元素出现多少次
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        //把桶中的元素依次倒出即可
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0) {
                arr[i++] = j;
            }
        }
    }
}
