package cn.edu.ustc.nowcoderalgorithm.sort;
/*
冒泡排序，时间复杂度O(N^2)，空间复杂度O(1),稳定；

思路：从数组的最后一个元素开始，依次向前；
只要前面一个数大于后面一个数就交换；

提升，可以设一个flag表示前面的数是否已经有序，如果有序的话就不用交换。
 */
public class BubbleSort {
    public void bubbleSort(int[] arr){
        if(arr==null||arr.length<=1)
            return;
        int len=arr.length-1;
        for(int i=len;i>=0;i--){//从最后一个开始
            for(int j=0;j<i;i++){
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
