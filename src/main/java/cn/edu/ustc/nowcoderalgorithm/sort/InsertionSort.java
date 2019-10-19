package cn.edu.ustc.nowcoderalgorithm.sort;
/*
插入排序，时间复杂度O(N^2)，空间复杂度O(1),稳定；

思路：
把第一个元素作为有序的排列，比较它后面的元素是否比它小，小的话就交换。


 */
public class InsertionSort {
    public void insertionSort(int[] arr){
        if(arr==null||arr.length<=1)
            return;
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[j]>arr[j+1])
                    swap(arr,j,j+1);
            }
        }
    }
    private void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[i+1];
        arr[i+1]=temp;
    }
}
