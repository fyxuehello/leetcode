package cn.edu.ustc.nowcoderalgorithm.sort;

/*
快速排序，时间复杂度O(NlogN)，空间复杂度O(logN),不稳定；

思路：
最重要的一步就是patition过程，以数组的最后一个元素为界，大于它的放在右边，小于它的放在左边，等于的放在中间。

*/
public class QuickSort {
    public void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1)
            return;
        quickSort(arr, 0, arr.length);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            swap(arr,left+(int)Math.random()*(right-left+1),right);
            int[] p=partition(arr,left,right);
            quickSort(arr,left,p[0]-1);
            quickSort(arr,p[1]+1,right);
        }
    }

    private int[] partition(int[] arr, int left, int right) {
        int less = left - 1;
        int more = right;
        while (left < right) {
            if (arr[left] < arr[right]) {
                swap(arr, ++less, left++);
            } else if (arr[left] > arr[right]) {
                swap(arr,--more,left);
            }else{
                left++;
            }
        }
        swap(arr,more,right);

        return new int[]{less+1,more};
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
