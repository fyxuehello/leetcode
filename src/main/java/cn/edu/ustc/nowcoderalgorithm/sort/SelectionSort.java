package cn.edu.ustc.nowcoderalgorithm.sort;

/*
选择排序，时间复杂度O(N^2)，空间复杂度O(1),稳定；

思路：


 */
public class SelectionSort {
    public void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1)
            return;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
