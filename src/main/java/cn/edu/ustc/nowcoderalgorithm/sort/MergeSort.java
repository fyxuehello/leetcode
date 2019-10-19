package cn.edu.ustc.nowcoderalgorithm.sort;
/*
归并排序，时间复杂度O(nlogn),空间复杂度O(n),稳定；
思路：
从中间把数组分成两部分并排序，分成的两部分再递归调用分成另外的两部分...
最后把它们合并起来即可。
 */
public class MergeSort {
    public void mergeSort(int[] arr){
        if(arr==null||arr.length<=1){
            return;
        }
        mergeSort(arr,0,arr.length);
    }
    private void mergeSort(int[] arr,int left,int right){
        if(left==right)
            return;
        int mid=left+(right-left)/2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }
    private void merge(int[] arr,int left,int mid,int right){
        int[] temp=new int[right-left+1];
        int p1=left,p2=mid+1;
        int i=0;
        while(p1<=mid&&p2<=right){
            if(arr[p1]<arr[p2]){
                temp[i]=p1;
                p1++;
            }else{
                temp[i]=p2;
                p2++;
            }
            i++;
        }
        while(p1<=mid){
            temp[i++]=arr[p1++];
        }
        while(p2<=right){
            temp[i++]=p2++;
        }
        //把temp 中的数据拷贝回arr
        for(i=0;i<temp.length;i++){
            arr[left+i]=temp[i];
        }
    }
}
