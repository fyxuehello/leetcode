package cn.edu.ustc.nowcoderalgorithm.sort;

/*
堆排序，时间复杂度O(NlogN)，空间复杂度O(N),稳定；

思路：
*/
public class HeapSort {
    public void heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {//形成一个大顶堆
            insertHeap(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);//第一个元素是最大值，把它和最后一个元素交换
        while (heapSize > 0) {//把最后一个元素前面的再次形成大顶堆
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    private void insertHeap(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (index < heapSize) {
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index)
                break;
            swap(arr, largest, index);

            index = largest;
            left = index * 2 + 1;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


