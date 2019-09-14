package cn.edu.ustc.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
题目：合并区间

Example 1:
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:
Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

思路：
首先按照每个子区间的第一个数字的大小进行排序；
然后遍历二维数组得到一维数组，判断一维数组是否有重叠的区间；
 */
public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1)
            return intervals;
        //排序
        Arrays.sort(intervals,(i1,i2)->Integer.compare(i1[0],i2[0]));

        List<int[]> res=new ArrayList<>();
        int[] preInterval=intervals[0];
        res.add(preInterval);
        for(int[] interval:intervals){
            if(interval[0]<=preInterval[1]){
                preInterval[1]=Math.max(interval[1],preInterval[1]);
            }else{
                preInterval=interval;
                res.add(preInterval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
