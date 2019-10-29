package cn.edu.ustc.jianzhioffer;
/*
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Number13 {
    public void reOrderArray(int [] array) {
        if(array==null||array.length<=1)
            return;
        for(int i=0;i<array.length-1;i++){//遇到前偶后奇就交换，此法类似于冒泡排序
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]%2==0&&array[j+1]%2==1){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j]=temp;
                }
            }
        }
    }
    /*
    时间复杂度O(n)，空间复杂度O(n)
    整体思路：
首先统计奇数的个数
然后新建一个等长数组，设置两个指针，奇数指针从0开始，偶数指针从奇数个数的末尾开始 遍历，填数
     */
    public void reOrderArray2(int [] array) {
        if(array.length==0||array.length==1) return;
        int oddCount=0,oddBegin=0;
        int[] newArray=new int[array.length];
        for(int i=0;i<array.length;i++){
            if((array[i]&1)==1) oddCount++;
        }
        for(int i=0;i<array.length;i++){
            if((array[i]&1)==1) newArray[oddBegin++]=array[i];
            else newArray[oddCount++]=array[i];
        }
        for(int i=0;i<array.length;i++){
            array[i]=newArray[i];
        }
    }
}
